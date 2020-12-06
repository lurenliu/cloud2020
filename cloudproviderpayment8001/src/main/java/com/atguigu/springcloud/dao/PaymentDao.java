package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/14 21:01
 */
@Mapper
public interface PaymentDao {

    // 添加一个 payment
    public int createPayment(@Param("payment") Payment payment);

    // 通过id  查询
    public Payment getPeymentByid(@Param("id") Long id);

}
