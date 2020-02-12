package com.ricky.example.dao;

import com.ricky.example.entity.Customer;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:30
 */

public interface CustomerDao {
    public boolean insert(Customer ctu);

    public List<Customer> queryAll();

    public List<Customer> queryAllByName(Customer customer);
}
