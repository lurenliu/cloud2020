package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:44
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId")Long productId, @Param("count")Integer count);

}
