package com.iotverify.service.impl;

import com.iotverify.dao.UserDao;
import com.iotverify.model.Device;
import com.iotverify.model.User;
import com.iotverify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Le on 4/11/2016.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public User findByUserId(Long userId) {
        return userDao.findByUserId(userId);
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }


}
