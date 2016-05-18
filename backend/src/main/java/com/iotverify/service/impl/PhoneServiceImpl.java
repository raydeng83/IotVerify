package com.iotverify.service.impl;

import com.iotverify.dao.PhoneDao;
import com.iotverify.model.Phone;
import com.iotverify.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lede on 5/12/16.
 */

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneDao phoneDao;

    public Phone save (Phone phone) {
        return phoneDao.save(phone);
    }

    @Transactional
    public void deleteByUserId (Long userId) {
        phoneDao.deleteByUserId(userId);
    }

    public List<Phone> findByUserId (Long userId) {
        return phoneDao.findByUserId(userId);
    }

    public Phone findOne (Long phoneNumberId) {
        return phoneDao.findOne(phoneNumberId);
    }

}
