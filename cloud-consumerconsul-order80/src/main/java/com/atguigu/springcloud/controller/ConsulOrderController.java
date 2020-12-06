package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/24 20:43
 */
@RestController
@Slf4j
public class ConsulOrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String URL = "http://consul-provide-payment";

    @GetMapping("consumer/payment/consul")
    public String testConsul(){
       return restTemplate.getForObject("http://consul-provide-payment" + "/payment/consul", String.class);
    }

}
