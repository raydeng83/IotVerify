package com.iotverify.controller;

import com.iotverify.model.Phone;
import com.iotverify.service.PhoneService;
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
    private PhoneService phoneService;

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Phone addPhoneNumber(@RequestBody Phone phone) {

        phone.setUserId(userService.findByUserName(phone.getUserName()).getUserId());
        return phoneService.save(phone);
    }
}
