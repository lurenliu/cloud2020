package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:39
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal total) {
        log.info(("--------------> Account Service  开始扣款流程"));
        accountDao.decrease(userId, total);
        log.info("---------------> Account Service  扣款流程结束");
    }
}
