package com.ricky.example.service;

import java.util.Map;

/**
 * @author ricky
 * @create 2019-10-29 20:08
 */
public interface UserService {

    int insertUser(Map<String,Object> userMap);
    int delUser(String id);
    int updateUser(Map<String,Object> userMap);
    Map<String,Object> findById(String id);
}
