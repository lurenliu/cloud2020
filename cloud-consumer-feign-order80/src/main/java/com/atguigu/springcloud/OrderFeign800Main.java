package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/26 21:55
 */
@SpringBootApplication
@EnableFeignClients
//@ComponentScan(value = {"com.atguigu.springcloud.service","com.atguigu.springcloud.controller"})
public class OrderFeign800Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeign800Main.class,args);
    }
}
