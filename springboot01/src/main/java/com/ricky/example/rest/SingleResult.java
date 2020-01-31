package com.ricky.example.rest;

/**
 * @author ricky
 * @create 2020-01-31 9:52
 */
public class SingleResult<T> extends Result {
    public SingleResult(){
        super();
    }

    public SingleResult(boolean success, String msg) {
        super(success, msg);
    }

    public SingleResult(boolean success, String msg, T data) {
        super(success, msg);
        this.data = data;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}