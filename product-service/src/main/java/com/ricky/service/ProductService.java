package com.ricky.service;

import com.ricky.domain.product;

import java.util.List;

/**
 * @author ricky
 * @create 2019-10-08 21:05
 */
public interface ProductService {
    List<product> listProduct();
    product findById(int id);

}
