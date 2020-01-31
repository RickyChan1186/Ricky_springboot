package com.ricky.example.rest;

import java.util.List;

/**
 * @author ricky
 * @create 2020-01-31 9:53
 */
public class ListResult<T> extends SingleResult {

    public ListResult(boolean success, String msg) {
        super(success, msg);
    }

    public ListResult(boolean success, String msg, List<T> data) {
        super(success, msg);
        this.data = data;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<T> data;

    private String sortby;

    private String orderType;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getSortby() {
        return sortby;
    }

    public void setSortby(String sortby) {
        this.sortby = sortby;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

}