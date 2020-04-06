package com.ricky.example;

import com.ricky.example.entity.Employee;
import com.ricky.example.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ricky
 * @create 2020-04-06 17:03
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test01(){

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Ricky");
        employee.setAddress("address");

        redisUtil.set("employeeTest",employee);
        System.out.println(employee);
    }

    @Test
    public void test02(){

        Employee employee = (Employee) redisUtil.get("employeeTest");
        System.out.println(employee);
    }
}
