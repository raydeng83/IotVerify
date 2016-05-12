package com.iotverify.dao;

import com.iotverify.model.PhoneNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lede on 5/12/16.
 */

@Repository
public interface PhoneNumberDao extends CrudRepository<PhoneNumber, Long>{
    PhoneNumber save (PhoneNumber phoneNumber);

    void deleteByUserId (Long userId);
}
