package com.iotverify.service.impl;

import com.iotverify.dao.LogEventDao;
import com.iotverify.model.LogEvent;
import com.iotverify.service.LogEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lede on 5/11/16.
 */

@Service
public class LogEventServiceImpl implements LogEventService {

    @Autowired
    private LogEventDao logEventDao;

    public List<LogEvent> findAll() {
        return logEventDao.findAll();
    }

    @Transactional
    public void deleteByUserId (Long userId){
        logEventDao.deleteByUserId(userId);
    }


    public LogEvent save (LogEvent logEvent) {
        return logEventDao.save(logEvent);
    }

    public void delete (Long logEventId) {
        logEventDao.delete(logEventId);
    }

}
