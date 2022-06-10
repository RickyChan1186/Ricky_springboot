package com.ricky.example;

import com.ricky.example.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author ricky
 * @create 2020-10-21 20:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJdk {

    private List<Customer> names = new ArrayList<>();


    @Test
    public void test01(){
        List<Customer> names1 = new ArrayList<Customer>();
        List<Customer> names2 = new ArrayList<Customer>();

        for(int i=0; i<3; i++){
            Customer customer = new Customer();
            customer.setId(i);
            customer.setName(UUID.randomUUID().toString());
            customer.setAddress("address"+i);

            names1.add(customer);
            names2.add(customer);
        }

        System.out.println("排序前："+names1.toString());

        System.out.println("使用 Java 7 语法: ");
        sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");
        System.out.println(names2);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<Customer> names){
        Collections.sort(names, new Comparator<Customer>() {
            @Override
            public int compare(Customer s1, Customer s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<Customer> names){
        Collections.sort(names, (s1, s2) -> s2.getName().compareTo(s1.getName()));
    }


    @Test
    public void test02(){

        names.add(new Customer(1,"aa","aa"));
        names.add(new Customer(2,"bb","bb"));
        names.add(new Customer(3,"cc","cc"));

        sortUsingJava8(names);
        names.forEach(System.out::println);
    }
}
