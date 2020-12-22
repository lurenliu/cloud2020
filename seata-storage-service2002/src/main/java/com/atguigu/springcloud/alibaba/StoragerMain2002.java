package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/22 23:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StoragerMain2002 {
    public static void main(String[] args) {
        SpringApplication.run(StoragerMain2002.class,args);
    }
}
