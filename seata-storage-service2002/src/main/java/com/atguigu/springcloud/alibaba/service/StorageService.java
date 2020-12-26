package com.atguigu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:50
 */
public interface StorageService {

    /* 扣除库存 */
    void decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count);


}
