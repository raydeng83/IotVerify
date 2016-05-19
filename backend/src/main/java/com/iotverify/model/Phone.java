package com.iotverify.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Le on 4/11/2016.
 */
@Entity
@Table(name="phone_numbers")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long phoneId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "phone")
    private String phone;
    @Column(name = "creation_date")
    private Date creationDate;

    @Transient
    private String userName;

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
