package com.iotverify.service;

import com.iotverify.model.PhoneNumber;

import java.util.List;

/**
 * Created by lede on 5/12/16.
 */
public interface PhoneNumberService {
    PhoneNumber save (PhoneNumber phoneNumber);

    void deleteByUserId (Long userId);

    List<PhoneNumber> findByUserId (Long userId);

}
