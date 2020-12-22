package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/22 23:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String msg;
    private T      data;

    public CommonResult(Integer code, String msg){
        this(code, msg, null);
    }

}

