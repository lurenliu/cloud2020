package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/26 15:42
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /*  扣款 */
    @PutMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId, @RequestParam("money") BigDecimal money){
        System.out.println("进入到  account controller 方法");
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣款流程完成", null);
    }

}
