package com.iotverify.controller.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iotverify.model.Device;
import com.iotverify.model.Phone;
import com.iotverify.model.User;
import com.iotverify.service.DeviceService;
import com.iotverify.service.PhoneService;
import com.iotverify.service.UserService;
import com.twilio.sdk.Twilio;
import com.twilio.sdk.creator.api.v2010.account.CallCreator;
import com.twilio.sdk.creator.api.v2010.account.MessageCreator;
import com.twilio.sdk.resource.api.v2010.account.Call;
import com.twilio.sdk.resource.api.v2010.account.Message;
import com.twilio.sdk.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lede on 5/17/16.
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/tagIdentification", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public Map<String, Object> tagIdentify(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

        if (!(formParameters.get("tag_id") == null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables") == null)) {

            String tagId = formParameters.get("tag_id");

            JsonParser parser = new JsonParser();
            JsonObject deviceVarObj = (JsonObject) parser.parse(formParameters.get("device_variables"));

            //define device fields
            String androidId = deviceVarObj.get("android_id").toString();
            String imei = deviceVarObj.get("imei").toString();
            String deviceName = deviceVarObj.get("device_name").toString();
            String serialNo = deviceVarObj.get("serial_no").toString();
            String wifiMacAddress = deviceVarObj.get("wifi_mac_address").toString();

            String deviceUdid = imei + "-" + androidId + "-" + serialNo;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(deviceUdid.getBytes(), 0, deviceUdid.length());

            String deviceCompUdid = new BigInteger(1, m.digest()).toString(16);

            List<Device> devices = deviceService.findByTagId(Long.parseLong(tagId));

//            if (devices.size() > 0) {
            Long userId = devices.get(0).getUserId();
            User user = userService.findByUserId(userId);
            String username = user.getUserName();

            if (devices.get(0).getTagId() != null) {

                if (devices.get(0).getDeviceCompUdid() != "") {
                    map.put("status", true);
                    map.put("username", username);

                    return map;
                } else {
                    List<Phone> phones = phoneService.findByUserId(userId);

                    map.put("username", username);
                    map.put("phones", phones);
                    for (Phone phone : phones) {
                        String tempPhone = phone.getPhone();
                        tempPhone = "XXX-XXX-" + tempPhone.substring(tempPhone.length() - 4);
                        phone.setPhone(tempPhone);
                    }
                    map.put("status", false);
                    map.put("error", "Please register for signing in from a new device.");

                    return map;
                }
            } else {
                map.put("status", false);
                map.put("error", "Please register this tag.");

                return map;
            }
//            }

        } else {
            map.put("status", false);
            map.put("error", "Invalid request from the application.");

            return map;
        }

    }

    @RequestMapping(value = "/userIdentification", method = RequestMethod.POST, consumes =
            {"application/x-www-form-urlencoded"})
    public Map<String, Object> userIdentification(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

        if (!(formParameters.get("tag_id") == null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables") == null) && !(formParameters.get("username") == null)) {

            String tagId = formParameters.get("tag_id");
            String userName = formParameters.get("username");
            JsonParser parser = new JsonParser();
            JsonObject deviceVarObj = (JsonObject) parser.parse(formParameters.get("device_variables"));

            //define device fields
            String androidId = deviceVarObj.get("android_id").toString();
            String imei = deviceVarObj.get("imei").toString();
            String deviceName = deviceVarObj.get("device_name").toString();
            String serialNo = deviceVarObj.get("serial_no").toString();
            String wifiMacAddress = deviceVarObj.get("wifi_mac_address").toString();

            String deviceUdid = imei + "-" + androidId + "-" + serialNo;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(deviceUdid.getBytes(), 0, deviceUdid.length());

            String deviceCompUdid = new BigInteger(1, m.digest()).toString(16);

            List<Device> devices = deviceService.findByTagId(Long.parseLong(tagId));

            User user = userService.findByUserName(userName);

            if (user != null) {
                map.put("status", true);
                map.put("phones", user.getUserName());
                List<Phone> phones = phoneService.findByUserId(user.getUserId());
                for (Phone phone : phones) {
                    String tempPhone = phone.getPhone();
                    tempPhone = "XXX-XXX-" + tempPhone.substring(tempPhone.length() - 4);
                    phone.setPhone(tempPhone);
                }
                map.put("phones", phones);

                return map;

            } else {
                map.put("status", false);
                map.put("error", "Username does not exist.");

                return map;
            }

        } else {
            map.put("status", false);
            map.put("error", "Invalid request from the application.");

            return map;
        }
    }

    @RequestMapping(value = "/tokenRequest", method = RequestMethod.POST, consumes =
            {"application/x-www-form-urlencoded"})
    public Map<String, Object> tokenRequest(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws
            Exception {

        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

        if (!(formParameters.get("tag_id") == null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables") == null) && !(formParameters.get("username") == null) && !
                (formParameters.get("phone_id") == null) && !(formParameters.get("action") == null)) {


            String tagId = formParameters.get("tag_id");
            String userName = formParameters.get("username");
            String phoneNumberId = formParameters.get("phone_id");
            String action = formParameters.get("action");
            JsonParser parser = new JsonParser();
            JsonObject deviceVarObj = (JsonObject) parser.parse(formParameters.get("device_variables"));

            //define device fields
            String androidId = deviceVarObj.get("android_id").toString();
            String imei = deviceVarObj.get("imei").toString();
            String deviceName = deviceVarObj.get("device_name").toString();
            String serialNo = deviceVarObj.get("serial_no").toString();
            String wifiMacAddress = deviceVarObj.get("wifi_mac_address").toString();

            String deviceUdid = imei + "-" + androidId + "-" + serialNo;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(deviceUdid.getBytes(), 0, deviceUdid.length());

            String deviceCompUdid = new BigInteger(1, m.digest()).toString(16);

            List<Device> devices = deviceService.findByTagId(Long.parseLong(tagId));

            Phone phone = phoneService.findOne(Long.parseLong(phoneNumberId));
            String phoneNumber = phone.getPhone();

            Long tokenId =100000 + (long) (Math.random() * ((999999-100000)+1));

            User user = userService.findByUserName(userName);
            user.setTokenId(tokenId);
            userService.save(user);

            //Twilio code
            final String ACCOUNT_SID = "AC5318177eafd83c44f5425a339139c35a";
            final String AUTH_TOKEN = "f629eb407740ffa33b43741341bd4255";

            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            if (action.equals("sms")) {
                Message message = new MessageCreator(
                        ACCOUNT_SID,
                        new PhoneNumber(phoneNumber), // TO number
                        new PhoneNumber("+15622739886"), // From Twilio number
                        "Your registration code is:"+tokenId
                ).execute();

                System.out.println(message.getSid());

                map.put("status", true);

                return map;
            } else if (action.equals("call")) {
                Call call = new CallCreator(ACCOUNT_SID,
                        new PhoneNumber(phoneNumber), // TO number
                        new PhoneNumber("+15622739886"), // From Twilio number
                        // Read TwiML at this URL when a call connects (hold music)
                        new URI("http://twimlets.com/holdmusic?Bucket=com.twilio.music.ambient")
                        ).execute();

                System.out.println(call.getSid());

                map.put("status", true);

                return map;
            } else {
                map.put("status", false);
                map.put("error", "Invalid request from the application.");

                return map;
            }
            //End Twilio code


        } else {
            map.put("status", false);
            map.put("error", "Invalid request from the application.");

            return map;
        }

    }

    @RequestMapping(value = "/tokenVerification", method = RequestMethod.POST, consumes =
            {"application/x-www-form-urlencoded"})
    public Map<String, Object> tokenVerification(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws
            Exception {

        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

        if (!(formParameters.get("tag_id") == null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables") == null) && !(formParameters.get("token") == null)) {

            String tagId = formParameters.get("tag_id");
            String tokenNumber = formParameters.get("token");
            JsonParser parser = new JsonParser();
            JsonObject deviceVarObj = (JsonObject) parser.parse(formParameters.get("device_variables"));

            //define device fields
            String androidId = deviceVarObj.get("android_id").toString();
            String imei = deviceVarObj.get("imei").toString();
            String deviceName = deviceVarObj.get("device_name").toString();
            String serialNo = deviceVarObj.get("serial_no").toString();
            String wifiMacAddress = deviceVarObj.get("wifi_mac_address").toString();

            User user = userService.findByTokenId(Long.parseLong(tokenNumber));

            if (user != null) {
                map.put("status", true);
                map.put("username", user.getUserName());

                return map;
            } else {
                map.put("status", false);
                map.put("error", "You have passed the wrong token number.");

                return map;
            }

        } else {
            map.put("status", false);
            map.put("error", "Invalid request from the application.");

            return map;
        }

    }


    @RequestMapping(value = "/userAuthentication", method = RequestMethod.POST, consumes =
            {"application/x-www-form-urlencoded"})
    public Map<String, Object> userAuthentication(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws
            Exception {

        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

    }

}
