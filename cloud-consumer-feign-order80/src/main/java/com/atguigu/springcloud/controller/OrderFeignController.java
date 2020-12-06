package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/26 21:59
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/getPayment/{id}")    //哪个地址
    public CommenResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 进入  orderFeignController ");
        log.info("~~~~~~~~~~~~~~~~~~~~~~~~~~~~ id : " + id);
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

    @GetMapping("/test")
    public String hello(){
        log.info("~~~~~~~~~~~~~~ hello");
        return "hello";
    }

}
