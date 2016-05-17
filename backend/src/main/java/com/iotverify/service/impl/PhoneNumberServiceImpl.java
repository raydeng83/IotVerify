package com.iotverify.service.impl;

import com.iotverify.dao.PhoneNumberDao;
import com.iotverify.model.PhoneNumber;
import com.iotverify.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lede on 5/12/16.
 */

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService{

    @Autowired
    private PhoneNumberDao phoneNumberDao;

    public PhoneNumber save (PhoneNumber phoneNumber) {
        return phoneNumberDao.save(phoneNumber);
    }

    @Transactional
    public void deleteByUserId (Long userId) {
        phoneNumberDao.deleteByUserId(userId);
    }

    public List<PhoneNumber> findByUserId (Long userId) {
        return phoneNumberDao.findByUserId(userId);
    }

}
