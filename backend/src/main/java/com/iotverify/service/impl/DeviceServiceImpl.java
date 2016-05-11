package com.iotverify.service.impl;

import com.iotverify.dao.DeviceDao;
import com.iotverify.model.Device;
import com.iotverify.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    public List<Device> findByDeviceCompUdid(String deviceCompUdid) {
        return deviceDao.findByDeviceCompUdid(deviceCompUdid);
    }

    public List<Device> findAll() {
        return deviceDao.findAll();
    }
}