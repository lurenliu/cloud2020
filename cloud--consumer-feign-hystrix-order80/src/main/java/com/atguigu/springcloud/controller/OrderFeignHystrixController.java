package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/28 16:01
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_defaultFallback")
public class OrderFeignHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable Integer id){
        return paymentHystrixService.paymentInfo_OK(id);
    }


//    @HystrixCommand(fallbackMethod = "payment_TimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable Integer id){
        Integer i = 10 / 0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    public String payment_TimeoutHandler(Integer i){
        return "我是消费者80，  抱歉请求时间过长或者 内部出现错误 ┭┮﹏┭┮  !! ";
    }

    /*
    * 全局通用的 fallback方法
    * */
    public String payment_Global_defaultFallback(){
        return " 你好， 我是全局通用的fallback方法 ！！！ ";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
