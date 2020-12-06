package com.atguigu.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/28 15:58
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain800 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain800.class,args);
    }
}