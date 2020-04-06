package com.ricky.example.service.Imp;

import com.ricky.example.dao.EmployeeDao;
import com.ricky.example.entity.Employee;
import com.ricky.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ricky
 * @create 2019-09-09 20:44
 */
@CacheConfig(cacheManager = "empCacheManager") //引入使用的缓存管理，不设置默认使用主缓存管理
@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public int insert(Employee employee) {
        return employeeDao.insert(employee);
    }

    @Override
    public int delete(Integer id) {
        return employeeDao.delete(id);
    }

    @Override
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Cacheable(cacheNames = {"emp"})
    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> queryAll() {
        return employeeDao.queryAll();
    }
}
