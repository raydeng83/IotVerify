package com.iotverify.model;

/**
 * Created by lede on 4/7/16.
 */
public class Device {
    private long deviceId;
    private String deviceUUID;
    private String deviceCompUdid;
    private String tagId;
    private String androidId;
    private String deviceName;
    private String imei;
    private String wifiMacAddress;
    private String serialNo;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
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
