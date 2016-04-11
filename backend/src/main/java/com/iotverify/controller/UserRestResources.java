package com.iotverify.controller;

import com.iotverify.model.User;
import com.iotverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Le on 4/11/2016.
 */
@RestController()
@RequestMapping("/rest/user")
public class UserRestResources {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
