package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/23 22:05
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PutMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId")Long productId, @RequestParam("count")Integer count);

}
