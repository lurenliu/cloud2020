package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/14 17:55
 */
@Component
@EnableBinding(Sink.class)
public class ReviceMessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("~~~~~ 消费者1号， 获取到的消息Message : " + message.getPayload() + "\t" + " serverPort : " + serverPort);
    }

}
