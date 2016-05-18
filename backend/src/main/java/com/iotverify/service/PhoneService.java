package com.iotverify.service;

import com.iotverify.model.Phone;

import java.util.List;

/**
 * Created by lede on 5/12/16.
 */
public interface PhoneService {
    Phone save (Phone phone);

    void deleteByUserId (Long userId);

    List<Phone> findByUserId (Long userId);

    Phone findOne (Long phoneNumberId);


}
