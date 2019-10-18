package com.ricky.fallback;

import com.ricky.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * @author ricky
 * @create 2019-10-18 14:01
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public Object findById(int id) {
        System.out.println("调用异常，熔断链路");
        return null;
    }
}
