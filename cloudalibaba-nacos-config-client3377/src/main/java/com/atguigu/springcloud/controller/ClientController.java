package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/16 23:44
 */
@RestController
@RefreshScope  // SpringCloud原生注解 支持Nacos的动态刷新功能
public class ClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/nacos/configinfo")
    public String configInfo(){
        return configInfo;
    }

}
