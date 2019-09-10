package com.ricky.example.service.Imp;

import com.ricky.example.dao.CustomerDao;
import com.ricky.example.entity.Customer;
import com.ricky.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ricky
 * @create 2019-09-09 20:44
 */
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean insert(Customer ctu) {
        return customerDao.insert(ctu);
    }


}
