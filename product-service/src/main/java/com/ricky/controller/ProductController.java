package com.ricky.controller;

import com.ricky.domain.product;
import com.ricky.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ricky
 * @create 2019-10-08 21:01
 */
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

   @Autowired
    public ProductService productService;

    @GetMapping(value = "/listProduct")
    public Object listProduct(){
        return productService.listProduct();
    }

    @GetMapping(value = "/findById")
    public Object findById(int id){
        product p = new product();
        p = productService.findById(id);
        product result = new product();
        BeanUtils.copyProperties(p,result);

        result.setName( result.getName()+" From "+port);

        return result;
    }
}
