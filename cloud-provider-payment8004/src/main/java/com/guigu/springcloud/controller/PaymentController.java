package com.guigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/16 23:34
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/testZoo")
    public String testZoo(){
        return "是否连接到zookeeper : " + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
