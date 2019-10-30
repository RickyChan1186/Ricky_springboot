package com.ricky.example.service.Imp;

import com.ricky.example.dao.LogDao;
import com.ricky.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author ricky
 * @create 2019-10-30 20:48
 */
@Service
public class LogServiceImp implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertLog(Map<String, Object> map) {
        return logDao.insertLog(map);
    }
}
