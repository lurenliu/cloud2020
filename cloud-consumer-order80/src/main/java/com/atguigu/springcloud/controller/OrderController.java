package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBlancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/15 19:28
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBlancer loadBlancer;

//    public static final String PAYMENT_YRL = "http://127.0.0.1:8001";
    public static final String PAYMENT_YRL = "http://CLOUD-PROVIDER-SERVICE";

    @PostMapping("customer/payment/create")
    public CommenResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_YRL + "/payment/create" , payment, CommenResult.class);
    }

    @GetMapping("customer/payment/getPayment/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_YRL + "/payment/getPayment/" + id, CommenResult.class);
    }


    @GetMapping("/consumer/lb/payment")
    public String testLB(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(serviceInstances == null || serviceInstances.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBlancer.getInstance(serviceInstances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/lb/payment", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String zipkim(){
        return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
    }

}
