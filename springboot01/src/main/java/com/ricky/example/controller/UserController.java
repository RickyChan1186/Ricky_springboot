package com.ricky.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ricky.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author ricky
 * @create 2019-10-29 20:01
 */
@RestController
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/insertUser")
    public Object insertUser(@RequestBody String userStr){
        Map<String,Object> result = new HashMap<>();

        String id = UUID.randomUUID().toString();

        JSONObject userJson = JSON.parseObject(userStr);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",userJson.getString("name"));
        map.put("age",userJson.getInteger("age"));
        map.put("address",userJson.getString("address"));

        int flag = userService.insertUser(map);
        if(flag>0){
            result.put("success","插入成功");
            return result;
        }else{
            result.put("error","插入失败");
            return result;
        }
    }

    @GetMapping(value = "/findById")
    public Object findById(String id){
        return userService.findById(id);
    }



}
