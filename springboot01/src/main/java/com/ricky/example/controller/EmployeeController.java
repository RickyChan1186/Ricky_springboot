package com.ricky.example.controller;

import com.ricky.example.entity.Employee;
import com.ricky.example.rest.SingleResult;
import com.ricky.example.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ricky
 * @create 2020-04-04 22:43
 */
@RestController
@Api
@RequestMapping(value = "/EmployeeController")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @ApiOperation(value = "/findById",notes = "获取employee对象")
    @GetMapping(value = "/findById")
    public SingleResult findById(int id){

        long start = new Date().getTime();
        Employee employee = employeeService.findById(id);
        long end = new Date().getTime();
        System.out.println("请求时间:"+(end-start));
        return new SingleResult(true,"操作成功",employee);
    }
}
