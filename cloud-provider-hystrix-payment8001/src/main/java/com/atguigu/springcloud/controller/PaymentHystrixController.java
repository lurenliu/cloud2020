package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/28 13:48
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeOut(@PathVariable Integer id){
        return paymentHystrixService.paymentInfo_timeOut(id);
    }

    @GetMapping("/payment/circuit/{id}")
    public String circuitBeakerTest(@PathVariable("id") Integer id){
        String result = paymentHystrixService.circuitBreakM(id);
        log.info("~~~~~~~~~ result ~~~~~~ ~" + result);
        return result;
    }

}
