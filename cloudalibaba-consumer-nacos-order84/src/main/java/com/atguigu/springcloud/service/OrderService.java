package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.impl.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/22 21:24
 */
@FeignClient(value = "nacos-payment-provider", fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/sentinel/feign")
    public CommenResult<Payment> feignTest();

}
