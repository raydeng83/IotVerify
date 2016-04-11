package com.iotverify.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Le on 4/11/2016.
 */
public class LogEvent {
    private long logEventId;
    private String eventName;
    private String eventDescription;
    private Date creationDate;
    private UUID deviceUUID;
    private long userId;
    private long tagId;

    public long getLogEventId() {
        return logEventId;
    }

    public void setLogEventId(long logEventId) {
        this.logEventId = logEventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public UUID getDeviceUUID() {
        return deviceUUID;
    }

    public void setDeviceUUID(UUID deviceUUID) {
        this.deviceUUID = deviceUUID;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }
}
