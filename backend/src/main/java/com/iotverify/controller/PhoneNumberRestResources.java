package com.iotverify.controller;

import com.iotverify.model.PhoneNumber;
import com.iotverify.service.PhoneNumberService;
import com.iotverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lede on 5/12/16.
 */

@RestController
@RequestMapping("rest/phoneNumber")
public class PhoneNumberRestResources {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public PhoneNumber addPhoneNumber(@RequestBody PhoneNumber phoneNumber) {

        phoneNumber.setUserId(userService.findByUserName(phoneNumber.getUserName()).getUserId());
        return phoneNumberService.save(phoneNumber);
    }
}
