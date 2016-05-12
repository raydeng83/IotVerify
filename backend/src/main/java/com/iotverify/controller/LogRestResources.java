package com.iotverify.controller;

import com.iotverify.model.LogEvent;
import com.iotverify.service.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public LogEvent addUser(@RequestBody LogEvent logEvent) {

        return  logEventService.save(logEvent);
    }

    @RequestMapping(value="/delete/{logEventId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(value = "logEventId") String logEventId) {
        logEventService.delete(Long.parseLong(logEventId));

        return "delete log success.";
    }
}
