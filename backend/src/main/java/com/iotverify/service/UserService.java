package com.iotverify.service;

import com.iotverify.model.Device;
import com.iotverify.model.User;

import java.util.List;

/**
 * Created by Le on 4/11/2016.
 */
public interface UserService {
    List<User> getUsers();

    User findByUserId(Long userId);

    void delete(Long userId);

    User save (User user);

}
