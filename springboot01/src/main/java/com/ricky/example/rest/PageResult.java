package com.ricky.example.rest;

import java.util.List;

/**
 * @author ricky
 * @create 2020-01-31 9:55
 */
public class PageResult<T> extends ListResult<T> {

    public PageResult(boolean success, String msg) {
        super(success, msg);
    }

    public PageResult(boolean success, String msg, List<T> data, long total) {
        super(success, msg);
        this.data = data;
        this.total = total;
    }

    private static final long serialVersionUID = 1L;

    private List<T> data;

    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
