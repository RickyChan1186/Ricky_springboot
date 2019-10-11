package com.ricky.controller;

import com.ricky.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String save(@RequestParam("user_id")int userId,@RequestParam("product_id")int productId){
        productOrderService.save(userId,productId);
        return null;
    }
}
