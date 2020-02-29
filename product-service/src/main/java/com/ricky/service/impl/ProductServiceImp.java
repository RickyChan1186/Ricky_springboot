package com.ricky.service.impl;

import com.ricky.domain.product;
import com.ricky.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ricky
 * @create 2019-10-08 21:08
 */
@Service
public class ProductServiceImp implements ProductService {

    public static final Map<Integer,product> doMap = new HashMap<>();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    static {
        doMap.put(1,new product(1,"phone",9999,99));
        doMap.put(2,new product(2,"phone",9999,99));
        doMap.put(3,new product(3,"phone",9999,99));
        doMap.put(4,new product(4,"phone",9999,99));
        doMap.put(5,new product(5,"phone",9999,99));
    }


    @Override
    public List<product> listProduct() {
        Collection<product> collection = doMap.values();
        List<product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public product findById(int id) {
        logger.info("findbyId");
        product p = doMap.get(id);
        return p;
    }
}
