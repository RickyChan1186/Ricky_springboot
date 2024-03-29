package com.ricky.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ricky.example.entity.User;
import com.ricky.example.handle.MyException;
import com.ricky.example.rest.Result;
import com.ricky.example.util.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final Logger logger = LoggerFactory.getLogger(getClass());

    Map<String,Object> params = new HashMap<>();

    @Autowired
    RedisUtil redisUtil;


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
        System.out.println(111);
        return params;
    }

    @PostMapping(value = "/postMethod")
    public Object postMethod(@RequestBody String json){

        JSONObject object = JSON.parseObject(json);

        System.out.println(object.toJSONString());
        return  object;
    }

    @RequestMapping(value = "/testSetRedis",method = RequestMethod.GET)
    public void testSetRedis(){
        redisUtil.set("value","value");
    }

    @RequestMapping(value = "/testGetRedis",method = RequestMethod.GET)
    public String testGetRedis(){
        return (String) redisUtil.get("value");

    }

    @ApiOperation(value = "/testLogback")
    @GetMapping(value = "/testLogback")
    public Result testLogback(){

        logger.debug("debug++++++++++++++++++++++++");
        logger.info("info++++++++++++++++++++++++");
        logger.error("error++++++++++++++++++++++++");
        return new Result(true,"success");
    }

    /**
     * @Author chenzefan
     * @Description df df
     * @Date 14:56 2022/2/7
     * @Param 
     * @Return 
     **/
    @ApiOperation(value = "/testLogback1")
    @GetMapping(value = "/testLogback1")
    public Result testLogback1(){

        logger.debug("debug++++++++++++++++++++++++");
        logger.info("info++++++++++++++++++++++++");
        logger.error("error++++++++++++++++++++++++");
        int id = 2001;
        String symbol = "debug log";
        logger.debug("Processing trade with id: {} and symbol: {}", id, symbol);
        return new Result(true,"success");
    }

}
