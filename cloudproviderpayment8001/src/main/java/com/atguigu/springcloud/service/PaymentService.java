package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/14 21:24
 */
public interface PaymentService {

    // 添加一个 payment
    public int createPayment(Payment payment);

    // 通过id  查询
    public Payment getPeymentByid(Long id);

}
