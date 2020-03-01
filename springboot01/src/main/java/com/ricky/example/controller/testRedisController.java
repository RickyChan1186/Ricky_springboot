package com.ricky.example.controller;

import com.ricky.example.rest.SingleResult;
import com.ricky.example.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2020-03-01 14:23
 */
@RestController
@RequestMapping(value = "/testRedisController")
@Api(value = "Redis测试Controller")
public class testRedisController {

    private Map<String,Object> mapObj = new HashMap<>();

    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "/getExpireValue")
    @GetMapping(value = "/getExpireValue")
    public SingleResult<Map<String,Object>> getExpireValue(String valueKey){

        mapObj.put("valueKey",redisUtil.getExpire(valueKey));

        return new SingleResult<>(true,"操作成功",mapObj);
    }

    @ApiOperation(value = "/setValueKey")
    @GetMapping(value = "/setValueKey")
    public void setValueKey(String key,long time){

        redisUtil.set(key,"AAAA",time);

    }
}
