package com.ricky.example.service.Imp;

import com.github.pagehelper.page.PageMethod;
import com.ricky.example.dao.CustomerDao;
import com.ricky.example.entity.Customer;
import com.ricky.example.rest.PageResult;
import com.ricky.example.rest.ResultFactory;
import com.ricky.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public List<Customer> queryAll() {
        return customerDao.queryAll();
    }

    @Override
    public PageResult<Customer> findPageCustomer(int pageIndex, int pageSize) {
        PageMethod.startPage(pageIndex,pageSize);

        List<Customer> customers = customerDao.queryAll();
        return ResultFactory.createPageResult(customers);
    }


}
