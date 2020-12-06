package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/26 22:16
 */
@Configuration
public class MyLevel {

    @Bean
    Logger.Level getLevel(){
        return Logger.Level.FULL;
    }

}
