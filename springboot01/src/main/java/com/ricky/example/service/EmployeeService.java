package com.ricky.example.service;

import com.ricky.example.entity.Employee;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:42
 */

public interface EmployeeService {

    int insert(Employee employee);

    int delete(Integer id);

    int update(Employee employee);

    Employee findById(Integer id);

    List<Employee> queryAll();

}
