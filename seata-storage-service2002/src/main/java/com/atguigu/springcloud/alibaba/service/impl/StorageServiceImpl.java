package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:53
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("--------------> Storage Service 开始库存扣除流程");
        storageDao.decrease(productId, count);
        log.info("--------------> Storage Service 库存扣除流程结束");
    }
}
