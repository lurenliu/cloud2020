package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/14 21:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommenResult createPayment(@RequestBody Payment payment){
//        if(true)
//            return null;
        int result = paymentService.createPayment(payment);
        if(result > 0){
            return new CommenResult(1,"success, serverPort: " + servicePort);
        }else{
            return new CommenResult(444, "failed");
        }
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommenResult createPayment(@PathVariable("id")Long id){
        log.info("~~~~~~~~~~~~~~~~~~" +  id);
        Payment payment = paymentService.getPeymentByid(id);
        if(payment != null){
            return new CommenResult(200,"success, serverPort: " + servicePort,payment);
        }else{
            return new CommenResult(444, "failed",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service : services){
            log.info(" service : " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for(ServiceInstance serviceInstance : instances){
            log.info(serviceInstance.getHost() + "\t" + serviceInstance.getServiceId() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb/payment")
    public String testLB(){
        return servicePort;
    }



    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "一秒睡眠";
    }

}
