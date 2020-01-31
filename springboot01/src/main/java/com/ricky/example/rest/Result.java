package com.ricky.example.rest;

import java.io.Serializable;

/**
 * @author ricky
 * @create 2020-01-31 9:51
 */

public class Result implements Serializable {

    private String msg;

    private boolean success;

    private static final long serialVersionUID = 1L;

    public Result(){

    }

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}