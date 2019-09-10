package com.ricky.example.controller;

import com.ricky.example.entity.Customer;
import com.ricky.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2019-09-09 20:52
 */
@RestController
@RequestMapping(value = "/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/insertCustomer")
    public Object insertCustomer(int id,String name,String address){

        Customer ctu = new Customer(id,name,address);

        boolean result = customerService.insert(ctu);
        Map<String,Object> map = new HashMap<>();
        if(result){
            map.put("success",true);
            return map;
        }else{
            map.put("false",false);
            return map;
        }
    }
}
