package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/28 13:42
 */
@Service
public class PaymentHystrixService {


    /*
    *   设置响应成功函数
    * */
    public String paymentInfo_OK(Integer id){
        return Thread.currentThread().getName() + " paymentInfo_OK : " + "O(∩_∩)O哈哈~  ~  ~~  id : " + id + " success ";
    }

    /*
    *   设置响应超时函数
    *   超时时长为 3s
    * */
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_timeOut(Integer id){
        Integer time = 2000;
        try {
            Thread.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " paymentInfo_timeOut : " + "┭┮﹏┭┮  ~  ~~  id : " + id + " timeOut : " + (time / 1000);
    }

    public String paymentInfo_timeOutHandler(Integer id){
        return Thread.currentThread().getName() + " 您的请求超时或者方法出现异常 : " + "┭┮﹏┭┮  ~  ~~  id : " + id + " fallback : ";
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String circuitBreakM(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id 不能为负数");
        }
        return  " 线程名: " + Thread.currentThread().getName()+ "   流水号 : " + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请确认后 再次重试 ~~~~~  id : " + id;
    }

}
