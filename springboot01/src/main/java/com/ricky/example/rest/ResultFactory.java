package com.ricky.example.rest;


import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author ricky
 * @create 2020-01-31 9:56
 */
public class ResultFactory {
    private static final String successMsg="操作成功";
    private static final String failedMsg="操作失败";

    public static Result create(boolean success) {
        return new Result(success, success ? successMsg : failedMsg);
    }

    public static Result create(boolean success, String msg) {
        return new Result(success, msg);
    }

    public static <T> SingleResult<T> create(T data) {
        return new SingleResult<T>(true, successMsg, data);
    }

    public static <T> ListResult<T> create(List<T> data) {
        return new ListResult<T>(true, successMsg, data);
    }

    public static <T> PageResult<T> create(List<T> data, int total) {
        return new PageResult<T>(true, successMsg, data, total);
    }

    public static <T> PageResult<T> createPageResult(List<T> data) {
        PageResult<T> result = null;
        if (data instanceof Page) {
            Page<T> page = (Page<T>) data;
            result = new PageResult<T>(true, successMsg, data, page.getTotal());
        } else {
            throw new RuntimeException("无法获取分页参数！");
//			result = new PageResult<T>(true, successMsg, data, data.size());
        }

        return result;
    }
}
