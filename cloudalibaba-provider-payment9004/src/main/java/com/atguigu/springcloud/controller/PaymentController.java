package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommenResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/21 23:06
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> payments = new HashMap<>();
    static {
        payments.put(1L, new Payment(1L,"111111111111111111111111111111"));
        payments.put(2L, new Payment(2L,"222222222222222222222222222222"));
        payments.put(3L, new Payment(3L,"333333333333333333333333333333"));
    }


    @GetMapping("/getPayment/{id}")
    public CommenResult<Payment> getPayment(@PathVariable("id")@RequestBody Long id){
        return new CommenResult<>(200, "from mysql ~ " + serverPort, payments.get(id));
    }

    @GetMapping("/sentinel/feign")
    public CommenResult<Payment> feignTest(){
        int i = 1 / 0;
        return new CommenResult<>(200, "from mysql ~ " + serverPort, payments.get(1));
    }
}
