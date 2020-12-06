package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/28 20:42
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "~~~  进入fallback 方法 , paymentInfo_OK  请稍后重试";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "~~~  进入fallback 方法 , paymentInfo_TimeOut  请稍后重试";
    }
}
