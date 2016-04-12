package com.iotverify.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Le on 4/11/2016.
 */
@Entity
@Table(name="log_events")
public class LogEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long logEventId;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_description")
    private String eventDescription;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "device_UUID")
    private UUID deviceUUID;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "tag_id")
    private Long tagId;

    public Long getLogEventId() {
        return logEventId;
    }

    public void setLogEventId(Long logEventId) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
