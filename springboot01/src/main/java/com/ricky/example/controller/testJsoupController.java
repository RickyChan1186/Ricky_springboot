package com.ricky.example.controller;

import com.ricky.example.util.HttpUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ricky
 * @create 2020-02-01 14:32
 */
@RestController
@RequestMapping(value = "/testJsoupController")
public class testJsoupController {

    @ApiOperation(value = "/testJsoupGet",notes = "JsoupGet")
    @GetMapping(value = "/testJsoupGet")
    public String testJsoupGet(){

        String url = "http://localhost:8080/testRest/SingleResult";
        String rtn = HttpUtil.getByNoLogin(url,null);


        return rtn;
    }
}
