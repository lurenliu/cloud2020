package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/18 21:48
 */
@RestController
@Slf4j
public class OrderZKController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    public static  final String PAYMENT_URL = "http://cloud-provider-service";

    @GetMapping("/customer/payment/testZoo")
    public String testZoo(){
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/testZoo", String.class);
    }

}
