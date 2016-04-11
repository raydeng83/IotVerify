package com.iotverify.service.impl;

import com.iotverify.model.User;
import com.iotverify.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Le on 4/11/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User user1 = new User();
        user1.setUserId(1);
        user1.setFullName("Garret Grajek");
        user1.setUserName("ggrajek");
        user1.setPassword("test123");
        user1.setEmailAddress("ggrajek@test.com");
        user1.setType("normal");
        user1.setCreationDate(new Date());
        user1.setTokenId(256081);
        user1.setTokenExpireTime(600);
        user1.setUID("ggrajek");
        user1.setTempToken("5686b4c41779e");

        User user2 = new User();
        user2.setUserId(1);
        user2.setFullName("Garret Grajek");
        user2.setUserName("ggrajek");
        user2.setPassword("test123");
        user2.setEmailAddress("ggrajek@test.com");
        user2.setType("normal");
        user2.setCreationDate(new Date());
        user2.setTokenId(256081);
        user2.setTokenExpireTime(600);
        user2.setUID("ggrajek");
        user2.setTempToken("5686b4c41779e");

        users.add(user1);
        users.add(user2);

        return users;
    }
}
