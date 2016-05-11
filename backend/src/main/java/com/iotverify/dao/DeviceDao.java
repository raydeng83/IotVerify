package com.iotverify.dao;

import com.iotverify.model.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lede on 5/10/16.
 */

@Repository
public interface DeviceDao extends CrudRepository<Device, Long>{

    List<Device> findByDeviceCompUdid(String deviceCompUdid);

    List<Device> findAll();
}
