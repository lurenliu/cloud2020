package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/1 22:10
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class,args);
    }

}
