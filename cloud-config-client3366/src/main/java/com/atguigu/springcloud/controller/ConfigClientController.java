package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/7 21:36
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/config/info")
    public String getInfo(){
        return configInfo + " \t\t " + serverPort;
    }

}
