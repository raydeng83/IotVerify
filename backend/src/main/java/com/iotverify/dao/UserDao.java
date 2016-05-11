package com.iotverify.dao;

import com.iotverify.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Le on 4/11/2016.
 */

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByUserId (Long userId);

    void delete(Long userId);
}
