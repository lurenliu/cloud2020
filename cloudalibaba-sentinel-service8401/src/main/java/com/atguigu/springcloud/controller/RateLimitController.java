package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.myhandle.MyBlockExceptionHandle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/21 22:29
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",
            blockHandlerClass = MyBlockExceptionHandle.class,
            blockHandler = "myBlockException1")
    public CommenResult byResource(){
        return new CommenResult<String>(200, "~~~ byResource", "111");
    }

    @GetMapping("/sentinel/byUri")
    @SentinelResource(value = "byUri", blockHandler = "fail_test")
    public CommenResult byUri(){
        return new CommenResult<String>(200, "~~~ byUri", "111");
    }


    public CommenResult fail_test(BlockException e){
        return new CommenResult(500, e.getClass().getCanonicalName(), null);
    }


    @GetMapping("/myHandle")
    @SentinelResource(value = "myHandle",
            blockHandlerClass = MyBlockExceptionHandle.class,
            blockHandler = "myBlockException1")
    public CommenResult myHandle(){
        return new CommenResult<String>(200, "~~~ myHandle", "111");
    }

    @GetMapping("/sentinel/more")
    public String testF(){
        return "O(∩_∩)O哈哈~， 持久化实验 ~~~~~~~~~ ";
    }


}
