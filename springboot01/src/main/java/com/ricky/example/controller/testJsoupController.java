package com.ricky.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ricky.example.rest.Result;
import com.ricky.example.rest.SingleResult;
import com.ricky.example.util.HttpUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2020-02-01 14:32
 */
@Api
@RestController
@RequestMapping(value = "/testJsoupController")
public class testJsoupController {



    @ApiOperation(value = "/getResultValueReq")
    @GetMapping(value = "/getResultValueReq")
    public SingleResult<Map> getResultValueReq(String name, String address){

        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("address",address);

        return new SingleResult<>(true,"操作成功",map);

    }


    @ApiOperation(value = "/getOperationMethod01")
    @GetMapping(value = "/getOperationMethod01")
    public Result getOperationMethod01(){

        Map<String,String> map = new HashMap<>();
        map.put("name","Ricky");
        map.put("address","tttttttt");
        String returnStr = HttpUtil.getByNoLogin("http://localhost:8080/testJsoupController/getResultValueReq",map);

        System.out.println("返回值："+returnStr);

        return new Result(true,"操作成功");
    }


    @ApiOperation(value = "/postResultValueReq")
    @PostMapping(value = "/postResultValueReq")
    public SingleResult<JSONObject> postResultValueReq(){

        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String reqBbody = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
            JSONObject jsonObject = JSON.parseObject(reqBbody);

            return new SingleResult<>(true,"操作成功",jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
            return new SingleResult<>(true,e.getMessage());
        }
    }



    @ApiOperation(value = "/getOperationMethod02")
    @PostMapping(value = "/getOperationMethod02")
    public Result getOperationMethod02(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("A-1","111");
        jsonObject.put("B-2","222");
        System.out.println(jsonObject.toJSONString());


        String returnStr = HttpUtil.postRequst("http://localhost:8080/testJsoupController/postResultValueReq",jsonObject.toJSONString());

        System.out.println("返回值："+returnStr);

        return new Result(true,"操作成功");
    }


    @ApiOperation(value = "/getMapValue")
    @PostMapping(value = "/getMapValue")
    public SingleResult<Map>getMapValue(String id,String name){

        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        return new SingleResult<>(true,"操作成功",map);
    }


    @ApiOperation(value = "/getOperationMethod03")
    @PostMapping(value = "/getOperationMethod03")
    public Result getOperationMethod03(){

        Map<String,Object> map = new HashMap<>();
        map.put("id","1111");
        map.put("name","ricky");

        String returnStr = HttpUtil.postRequst("http://localhost:8080/testJsoupController/getMapValue",map);

        return new Result(true,"操作成功");
    }



}
