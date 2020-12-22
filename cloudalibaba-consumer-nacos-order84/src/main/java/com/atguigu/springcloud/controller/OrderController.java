package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/21 23:10
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    public static String URI = "http://nacos-payment-provider";

    @GetMapping("/consumer/getPayment/{id}")
    @SentinelResource(value = "getPayment", fallback = "fail_fallback")
    public CommenResult<Payment> getPayment(@PathVariable("id")Long id){
        CommenResult<Payment> result = restTemplate.getForObject(URI + "/getPayment/" + id, CommenResult.class);
        if(id == 4L){
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常。。。");
        }else if(result.getData() == null){
            throw new NullPointerException("NullPointerException， 没有该id对应的数据。。。。");
        }
        return result;
    }

    public CommenResult blockHandler(Long id, BlockException exception){
        Payment payment = new Payment(id, null);
        return new CommenResult<>(445, "blockHandler-sentinel 限流，无此流水号：blockException" + exception.getMessage(), payment);
    }


    public CommenResult<Payment> fail_fallback(@PathVariable("id")Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommenResult<>(4444, "fail_fallback  出现异常", payment);
    }

    @GetMapping("/consumer/sentinel/feign")
    public CommenResult<Payment> feignTest(){
        return orderService.feignTest();
    }

}
