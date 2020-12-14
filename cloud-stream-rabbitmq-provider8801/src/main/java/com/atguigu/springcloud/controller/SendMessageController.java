package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/14 15:42
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageService;

    @GetMapping("/stream/send")
    public String sendMessage(){
        return iMessageService.send();
    }

}
