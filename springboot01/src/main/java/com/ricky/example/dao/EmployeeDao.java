package com.ricky.example.dao;

import com.ricky.example.entity.Employee;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:30
 */

public interface EmployeeDao {

    int insert(Employee employee);

    int delete(Integer id);

    int update(Employee employee);

    Employee findById(Integer id);

    List<Employee> queryAll();


}
