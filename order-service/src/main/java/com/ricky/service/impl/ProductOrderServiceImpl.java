package com.ricky.service.impl;

import com.ricky.domain.ProductOrder;
import com.ricky.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ricky
 * @create 2019-10-11 19:45
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ProductOrder save(int userId, int productId) {

        Object obj = restTemplate.getForObject("http://Product-Service/api/v1/product/findById?id="+productId,Object.class);
        System.out.println(obj);
        return null;
    }
}
