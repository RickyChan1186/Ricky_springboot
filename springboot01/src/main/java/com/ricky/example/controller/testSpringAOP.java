package com.ricky.example.controller;

import com.ricky.example.rest.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ricky
 * @create 2020-03-14 15:53
 */
@Api
@RequestMapping(value = "/testSpringAOP")
@RestController
public class testSpringAOP {

    @ApiOperation(value = "/aopMethod1")
    @GetMapping(value = "/aopMethod1")
    public Result aopMethod1(){
        return new Result(true,"操作成功");
    }


    @ApiOperation(value = "/aopMethod2")
    @GetMapping(value = "/aopMethod2")
    public void aopMethod2(){

        int i = 10/0;
    }
}
