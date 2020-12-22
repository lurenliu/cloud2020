package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/22 21:32
 */
@Component
public class OrderServiceFallback implements OrderService {
    @Override
    public CommenResult<Payment> feignTest() {
        return new CommenResult<>(200, "from mysql ~  fallback   feign " + null);
    }
}
