package com.ricky.example.controller;

import com.ricky.example.entity.Customer;
import com.ricky.example.rest.ListResult;
import com.ricky.example.rest.PageResult;
import com.ricky.example.rest.Result;
import com.ricky.example.rest.SingleResult;
import com.ricky.example.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ricky
 * @create 2020-01-31 10:05
 */
@RestController
@RequestMapping(value = "/testRest")
public class testRest {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value = "/testResult",notes = "Result类型")
    @GetMapping(value = "/testResult")
    public Result testResult(){

        return new Result(true,"返回成功");
    }

    @ApiOperation(value = "/SingleResult",notes = "SingleResult类型")
    @GetMapping(value = "/SingleResult")
    public SingleResult<Map> testSingleResult(){
        Map<String,Object> mapObj = new HashMap<>();
        mapObj.put("A","AAA");
        mapObj.put("B","BBB");
        mapObj.put("C",123);

        return new SingleResult<Map>(true,"返回成功",mapObj);
    }


    @ApiOperation(value = "/testListResult",notes = "ListResult类型")
    @GetMapping(value = "/testListResult")
    public ListResult<Customer> testListResult(){

        try {
            List<Customer> customers = customerService.queryAll();
            return new ListResult<Customer>(true,"testListResult请求成功！",customers);
        } catch (Exception e) {
            e.printStackTrace();
            return new ListResult<Customer>(false,"testListResult请求失败！");
        }

    }

    @ApiOperation(value = "/testPageResult",notes = "PageResult类型")
    @GetMapping(value = "/testPageResult/{pageIndex}/{pageSize}")
    public PageResult<Customer> testPageResult(@PathVariable Integer pageIndex,@PathVariable Integer pageSize){
        try {
            PageResult<Customer> customers = customerService.findPageCustomer(pageIndex,pageSize);
            return  customers;
        } catch (Exception e) {
            e.printStackTrace();
            return new PageResult<>(false,"操作失败--"+e.getMessage());
        }
    }

    @ApiOperation(value = "/testCacheListResult",notes = "缓存测试")
    @GetMapping(value = "/testCacheListResult")
    public ListResult<Customer> testCacheListResult(){

        try {
            long begin = System.currentTimeMillis();
            List<Customer> customers = customerService.queryAll();
            long ing = System.currentTimeMillis();
            customers = customerService.queryAll();
            long end = System.currentTimeMillis();

            System.out.println("第一次查询耗时："+(ing-begin)+"ms");
            System.out.println("第一次查询耗时："+(end-ing)+"ms");

            return new ListResult<Customer>(true,"testListResult请求成功！",customers);
        } catch (Exception e) {
            e.printStackTrace();
            return new ListResult<Customer>(false,"testListResult请求失败！");
        }

    }


}
