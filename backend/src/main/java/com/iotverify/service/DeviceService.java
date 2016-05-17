package com.iotverify.service;

import com.iotverify.model.Device;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */
public interface DeviceService {

    List<Device> findByDeviceCompUdid(String deviceCompUdid);

    List<Device> findAll();

    void deleteByDeviceCompUdid(String userId);

    void delete (Long deviceId);

    List<Device> findByTagId (Long tagId);

}
