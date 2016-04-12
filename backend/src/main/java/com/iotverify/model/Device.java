package com.iotverify.model;

import javax.persistence.*;

/**
 * Created by lede on 4/7/16.
 */
@Entity
@Table(name="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long deviceId;
    @Column(name = "device_UUID")
    private String deviceUUID;
    @Column(name = "user_id")
    private String deviceCompUdid;
    @Column(name = "tag_ID")
    private String tagId;
    @Column(name = "android_id")
    private String androidId;
    @Column(name = "device_name")
    private String deviceName;
    @Column(name = "imei")
    private String imei;
    @Column(name = "wifi_mac_address")
    private String wifiMacAddress;
    @Column(name = "serial_no")
    private String serialNo;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getDeviceUUID() {
        return deviceUUID;
    }

    public void setDeviceUUID(String deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getWifiMacAddress() {
        return wifiMacAddress;
    }

    public void setWifiMacAddress(String wifiMacAddress) {
        this.wifiMacAddress = wifiMacAddress;
    }

    public String getDeviceCompUdid() {
        return deviceCompUdid;
    }

    public void setDeviceCompUdid(String deviceCompUdid) {
        this.deviceCompUdid = deviceCompUdid;
    }
}
