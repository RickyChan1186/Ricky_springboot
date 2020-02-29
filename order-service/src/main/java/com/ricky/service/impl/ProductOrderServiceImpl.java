package com.ricky.service.impl;

import com.ricky.domain.ProductOrder;
import com.ricky.service.ProductClient;
import com.ricky.service.ProductOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ricky
 * @create 2019-10-11 19:45
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {


    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @Override
    public ProductOrder save(int userId, int productId) {

        logger.info("save");
        //Object obj = restTemplate.getForObject("http://Product-Service/api/v1/product/findById?id="+productId,Object.class);
        Object obj = productClient.findById(1);
        System.out.println(obj);
        return null;
    }
}
