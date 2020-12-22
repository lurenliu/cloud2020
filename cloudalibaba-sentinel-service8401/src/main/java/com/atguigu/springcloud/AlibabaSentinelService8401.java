package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/20 21:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaSentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(AlibabaSentinelService8401.class,args);
    }
}
