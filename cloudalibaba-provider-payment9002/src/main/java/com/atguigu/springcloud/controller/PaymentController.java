package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/14 21:59
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/{id}")
    public String nacosPayment(@PathVariable("id")Long id){
        return "~~  nacosPayment method ~~      id : " + id + "\t serverPort : " + serverPort;
    }
}
