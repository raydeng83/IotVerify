package com.iotverify.controller;

import com.iotverify.model.Device;
import com.iotverify.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lede on 5/10/16.
 */

@RestController()
@RequestMapping("/rest/device")
public class DeviceRestResources {

    @Autowired
    private DeviceService deviceService;

    @RequestMapping(value = "/userId", method = RequestMethod.POST)
    public List<Device> findDevicesByUserId (@RequestBody String userId) {
        return deviceService.findByDeviceCompUdid(userId);
    }

    @RequestMapping("/allDevices")
    public List<Device> findAllDevices() {
        return deviceService.findAll();
    }

    @RequestMapping(value="/delete/{deviceId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "deviceId") String deviceId) {

        deviceService.delete(Long.parseLong(deviceId));

        return "delete device success.";
    }
}
