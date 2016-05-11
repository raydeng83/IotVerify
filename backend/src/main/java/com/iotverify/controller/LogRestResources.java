package com.iotverify.controller;

import com.iotverify.model.LogEvent;
import com.iotverify.service.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */

@RestController
@RequestMapping("rest/log")
public class LogRestResources {

    @Autowired
    private LogEventService logEventService;

    @RequestMapping("/allLogs")
    public List<LogEvent> findAllLogs() {
        return logEventService.findAll();
    }
}
