package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:33
 */
@Mapper
public interface AccountDao {

    /*  修改账户余额  */
    void decrease(@Param("userId")Long userID, @Param("total")BigDecimal total);

}
