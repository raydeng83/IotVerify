package com.iotverify.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Le on 4/11/2016.
 */
@Entity
@Table(name="user_keys")
public class Key {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long keyId;
    @Column(name = "user_key")
    private String key;
    @Column(name = "level")
    private int level;
    @Column(name = "ignore_limits")
    private int ignoreLimits;
    @Column(name = "date_created")
    private Date dateCreated;

    public Long getKeyId() {
        return keyId;
    }

    public void setKeyId(Long keyId) {
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

    public int getIgnoreLimits() {
        return ignoreLimits;
    }

    public void setIgnoreLimits(int ignoreLimits) {
        this.ignoreLimits = ignoreLimits;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
