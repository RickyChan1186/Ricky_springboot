package com.ricky.example.entity;

import java.io.Serializable;

/**
 * @author ricky
 * @create 2019-09-09 20:27
 */
public class Employee implements Serializable{
    private Integer id;
    private String name;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
