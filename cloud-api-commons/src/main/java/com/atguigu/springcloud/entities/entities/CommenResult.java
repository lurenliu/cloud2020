package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/14 20:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CommenResult<T> {

    private Integer code;

    private String message;

    private T      data;

    public CommenResult(Integer code, String message){
        this(code, message, null);
    }

}
