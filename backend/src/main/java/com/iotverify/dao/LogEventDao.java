package com.iotverify.dao;

import com.iotverify.model.LogEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */

@Repository
public interface LogEventDao extends CrudRepository<LogEvent, Long>{
    List<LogEvent> findAll();
}
