package com.ricky.example.service;

import com.ricky.example.entity.Customer;
import com.ricky.example.rest.PageResult;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:42
 */

public interface CustomerService {

    public boolean insert(Customer ctu);

    public List<Customer> queryAll();

    public PageResult<Customer> findPageCustomer(int pageIndex,int pageSize);


    public PageResult<Customer> findPageCustomer2(int pageIndex,int pageSize,Customer customer);
}
