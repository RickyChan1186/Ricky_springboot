package com.ricky.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ricky
 * @create 2019-12-11 23:04
 */
@ApiModel
public class Person {
    @ApiModelProperty(value = "姓名",name = "name")
    String name;

    @ApiModelProperty(value = "年龄",name = "age")
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
