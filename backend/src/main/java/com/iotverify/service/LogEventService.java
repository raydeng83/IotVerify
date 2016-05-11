package com.iotverify.service;

import com.iotverify.model.LogEvent;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */
public interface LogEventService {
    List<LogEvent> findAll();
}
