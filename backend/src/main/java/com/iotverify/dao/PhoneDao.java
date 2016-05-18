package com.iotverify.dao;

import com.iotverify.model.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lede on 5/12/16.
 */

@Repository
public interface PhoneDao extends CrudRepository<Phone, Long>{
    Phone save (Phone phone);

    void deleteByUserId (Long userId);

    List<Phone> findByUserId (Long userId);

    Phone findOne (Long phoneNumberId);
}
