package com.ricky.domain;

import java.io.Serializable;

/**
 * @author ricky
 * @create 2019-10-08 21:02
 */
public class product implements Serializable {
    private int id;
    private String name;
    private int price;
    private int store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public product(){

    }

    public product(int id, String name, int price, int store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }
}
