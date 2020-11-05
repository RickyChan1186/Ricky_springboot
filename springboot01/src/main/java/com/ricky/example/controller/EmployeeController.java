package com.ricky.example.controller;

import com.ricky.example.entity.Employee;
import com.ricky.example.rest.ListResult;
import com.ricky.example.rest.Result;
import com.ricky.example.rest.SingleResult;
import com.ricky.example.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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


    @ApiOperation(value = "/insert",notes = "插入employee对象")
    @PostMapping(value = "/insert")
    public Result insert(int id){

        try {
            Employee employee = new Employee();
            employee.setId(id);
            employee.setName(id+"-aaa");
            employee.setAddress(id+"-aaa");

            employeeService.insert(employee);

            return new Result(true,"操作成功");
        } catch (Exception e) {
            e.printStackTrace();

            return new Result(false,"操作失败");
        }
    }

    @ApiOperation(value = "/findById",notes = "获取employee对象")
    @GetMapping(value = "/findById")
    public SingleResult findById(int id){

        long start = new Date().getTime();
        Employee employee = employeeService.findById(id);
        long end = new Date().getTime();
        System.out.println("请求时间:"+(end-start));
        return new SingleResult(true,"操作成功",employee);
    }

    @ApiOperation(value = "/update",notes = "更新employee对象")
    @PostMapping(value = "/update")
    public SingleResult update(Employee employee){
        long start = new Date().getTime();
        int flag = employeeService.update(employee);
        long end = new Date().getTime();
        if(flag>0){
            return new SingleResult(true,"更新操作成功");
        }else {
            return new SingleResult(false,"更新操作失败");
        }
    }

    @ApiOperation(value = "/delete",notes = "删除employee对象")
    @PostMapping(value = "/delete")
    public Result delete(Integer id) {
        employeeService.delete(id);
        return new Result(true,"删除操作成功");
    }

    @ApiOperation(value = "/queryAll",notes = "查询所有employee对象")
    @GetMapping(value = "/queryAll")
    public ListResult queryAll(){
        long start = new Date().getTime();
        List<Employee> employeeList = employeeService.queryAll();
        long end = new Date().getTime();

        System.out.println("用时 ："+(end-start));
        return new ListResult(true,"查询所有操作成功",employeeList);
    }
}
