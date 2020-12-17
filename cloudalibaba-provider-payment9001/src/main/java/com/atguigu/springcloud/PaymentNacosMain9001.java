package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/14 21:55
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentNacosMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentNacosMain9001.class,args);
    }
}
