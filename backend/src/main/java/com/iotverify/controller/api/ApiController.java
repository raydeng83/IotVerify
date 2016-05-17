package com.iotverify.controller.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iotverify.dao.DeviceDao;
import com.iotverify.dao.UserDao;
import com.iotverify.model.Device;
import com.iotverify.model.PhoneNumber;
import com.iotverify.model.User;
import com.iotverify.service.DeviceService;
import com.iotverify.service.PhoneNumberService;
import com.iotverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void tagIdentify(HttpServletRequest req, HttpServletResponse res, @RequestBody
    MultiValueMap<String,
            String>
            parametersMultiMap) throws Exception{

        Map<String,String> formParameters = parametersMultiMap.toSingleValueMap();
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
        m.update(deviceUdid.getBytes(), 0 , deviceUdid.length());

        String deviceCompUdid = new BigInteger(1,m.digest()).toString(16);

        List<Device> devices = deviceService.findByTagId(Long.parseLong(tagId));

        if (devices.size()>0) {
            Long userId = devices.get(0).getUserId();
            User user = userService.findByUserId(userId);
            String username=user.getUserName();

            if (devices.get(0).getDeviceCompUdid()!="") {
                Map<String, Object> map = new HashMap<>();
                map.put("status", true);
                map.put("username", username);
            } else {
                List<PhoneNumber> phoneNumbers = phoneNumberService.findByUserId(userId);
            }
        }

    }



}
