package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/20 21:23
 */
@RestController
@Slf4j
public class FlowLimiteController {

    @GetMapping("/testA")
    public String testA(){
        return "test  A";
    }

    @GetMapping("/testB")
    public String testB(){
        return "test  B";
    }


    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info(" test   D ~~~~ ");
        return "test  D";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "fail_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false)String p1,
                             @RequestParam(value = "p2", required = false)String p2){
        return "~~~~~~~ testHotKey ~~~~~~~~~~~";
    }

    public String fail_testHotKey(String p1, String p2, BlockException e){
        return "~~~~~~~~~ fail_testHotKey ~~~~~~~~~~";
    }

}
