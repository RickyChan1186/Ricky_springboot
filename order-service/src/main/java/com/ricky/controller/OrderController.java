package com.ricky.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ricky.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ricky
 * @create 2019-10-11 19:42
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService ;

    @GetMapping(value = "/save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")int userId,@RequestParam("product_id")int productId){
        productOrderService.save(userId,productId);
        Map<String,Object> map = new HashMap<>();
        map.put("status","1");
        map.put("return","true");
        return map;
    }

    //注意方法签名一定要跟api保持一致
    public Object saveOrderFail(int userId,int productId){
        Map<String,Object> map = new HashMap<>();
        map.put("status","0");
        map.put("return","fail");
        return map;
    }
}
