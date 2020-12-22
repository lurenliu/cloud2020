package com.atguigu.springcloud.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommenResult;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/12/21 22:38
 */
public class MyBlockExceptionHandle {

    public static CommenResult myBlockException1(BlockException e){
        return new CommenResult(4444, e.getClass().getCanonicalName() + " ~~~~~11111", null);
    }

    public static CommenResult myBlockException2(BlockException e){
        return new CommenResult(4444, e.getClass().getCanonicalName() + " ~~~~~~~  22", null);
    }

}
