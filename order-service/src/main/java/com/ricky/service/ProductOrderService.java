package com.ricky.service;

import com.ricky.domain.ProductOrder;

/**
 * @author ricky
 * @create 2019-10-11 19:44
 */
public interface ProductOrderService {

    ProductOrder save(int userId,int productId);
}
