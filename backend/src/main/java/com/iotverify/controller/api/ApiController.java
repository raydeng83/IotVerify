package com.iotverify.controller.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iotverify.model.Device;
import com.iotverify.model.PhoneNumber;
import com.iotverify.model.User;
import com.iotverify.service.DeviceService;
import com.iotverify.service.PhoneNumberService;
import com.iotverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
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
    private PhoneNumberService phoneNumberService;

    @RequestMapping(value = "/tagIdentification", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public Map<String, Object> tagIdentify(@RequestBody MultiValueMap<String, String> parametersMultiMap) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Map<String, String> formParameters = parametersMultiMap.toSingleValueMap();

        if (!(formParameters.get("tag_id")==null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables")==null)) {

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
                    List<PhoneNumber> phoneNumbers = phoneNumberService.findByUserId(userId);

                    map.put("username", username);
                    map.put("phones", phoneNumbers);
                    for(PhoneNumber phoneNumber : phoneNumbers) {
                        String tempPhone = phoneNumber.getPhone();
                        tempPhone="XXX-XXX-"+tempPhone.substring(tempPhone.length()-4);
                        phoneNumber.setPhone(tempPhone);
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

        if (!(formParameters.get("tag_id")==null) && !formParameters.get("device_variables").isEmpty() &&
                !(formParameters.get("device_variables")==null) && !(formParameters.get("username")==null)) {

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
                List<PhoneNumber> phoneNumbers = phoneNumberService.findByUserId(user.getUserId());
                for(PhoneNumber phoneNumber : phoneNumbers) {
                    String tempPhone = phoneNumber.getPhone();
                    tempPhone="XXX-XXX-"+tempPhone.substring(tempPhone.length()-4);
                    phoneNumber.setPhone(tempPhone);
                }
                map.put("phones", phoneNumbers);

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

}
