package com.iotverify.model;

import java.util.Date;

/**
 * Created by Le on 4/11/2016.
 */
public class Key {
    private long keyId;
    private String key;
    private int level;
    private int ignore_limits;
    private Date date_created;

    public long getKeyId() {
        return keyId;
    }

    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIgnore_limits() {
        return ignore_limits;
    }

    public void setIgnore_limits(int ignore_limits) {
        this.ignore_limits = ignore_limits;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }
}
