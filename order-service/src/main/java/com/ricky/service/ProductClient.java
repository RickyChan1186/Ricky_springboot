package com.ricky.service;

import com.ricky.fallback.ProductClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ricky
 * @create 2019-10-14 20:19
 */
@FeignClient(name = "Product-Service",fallback = ProductClientFallback.class)
public interface ProductClient {
    @GetMapping(value = "/api/v1/product/findById")
    Object findById(@RequestParam(value = "id") int id);
}
