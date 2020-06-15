package com.ricky.example.service.Imp;

import com.ricky.example.dao.UserDao;
import com.ricky.example.service.LogService;
import com.ricky.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ricky
 * @create 2019-10-29 20:09
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogService logService;







    @Transactional
    public int insertUser(Map<String, Object> userMap) {
        try {
            int flag = userDao.insertUser(userMap);
            int i = 1/0;
            return  flag;
        }catch (Exception e){
            throw new RuntimeException("save 抛异常了");

        }finally {
            Map<String,Object> map = new HashMap<>();
            map.put("id", UUID.randomUUID().toString());
            map.put("method","insertUser");
            map.put("message","失败");

            logService.insertLog(map);
        }

    }

    @Override
    @Transactional
    public int delUser(String id) {
        return userDao.delUser(id);
    }

    @Override
    @Transactional
    public int updateUser(Map<String, Object> userMap) {
        return userDao.updateUser(userMap);
    }

    @Override
    @Transactional
    public Map<String, Object> findById(String id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public Map<String, Object> findById2(String id) {
        return userDao.findById2(id);
    }



}
