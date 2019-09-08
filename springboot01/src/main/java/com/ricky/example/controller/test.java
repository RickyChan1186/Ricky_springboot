package com.ricky.example.controller;

import com.ricky.example.entity.User;
import com.ricky.example.handle.MyException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2019-09-01 15:31
 */
@RestController
public class test {

    Map<String,Object> params = new HashMap<>();

    @RequestMapping(value = "/getMethod")
    @ResponseBody
    public String getMethod(){
        return "Hello world";
    }

    @GetMapping(value = "/v1/pageUser")
    public Object pageUser(@RequestParam(name = "pageId" ) int id, String name){
        params.clear();
        params.put("id",id);
        params.put("name",name);
        return params;
    }

    @PostMapping(value = "/v1/postMethod")
    public Object postMethod(int id,String name){
        params.clear();
        params.put("id",id);
        params.put("name",name);
        return params;
    }



    @PostMapping(value = "/v1/postJsonMethod")
    public Object postJsonMethod(@RequestBody Map<String,Object>user){
        params.clear();
        params.put("id",user.get("id"));
        params.put("name",user.get("name"));
        System.out.println("1111");
        System.out.println("2322323");

        return params;
    }

    @GetMapping(value = "/getUserMethod")
    public Object getUserMethod(){
        int i = 10/0;
        User user = new User(1,"ricky","13726261186",new Date());
        return user;
    }


    @GetMapping(value = "/getUserMethod2")
    public Object getUserMethod2(){

        User user = new User(1,"ricky","13726261186",new Date());
        return user;
    }


    @GetMapping(value = "/getMyException")
    public void getMyException(){

        throw new MyException("404","fail to connect");
    }


    @GetMapping(value = "/api/filter/getLoginFilter")
    public Object getLoginFilter(){
        params.clear();
        params.put("success","成功");
        return params;
    }

    @GetMapping(value = "/intercepter/getIntercepter")
    public Object getIntercepter(){
        params.clear();
        params.put("success","成功");
        return params;
    }

}
