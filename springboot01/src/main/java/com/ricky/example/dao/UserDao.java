package com.ricky.example.dao;

import java.util.Map;

/**
 * @author ricky
 * @create 2019-10-29 20:04
 */
public interface UserDao {

    int insertUser(Map<String,Object> userMap);
    int delUser(String id);
    int updateUser(Map<String,Object> userMap);
    Map<String,Object> findById(String id);
    Map<String,Object> findById2(String id);
}
