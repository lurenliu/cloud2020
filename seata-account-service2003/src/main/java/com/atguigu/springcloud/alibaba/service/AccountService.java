package com.atguigu.springcloud.alibaba.service;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:37
 */
public interface AccountService {

    /*  扣款 */
    void decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money);

}
