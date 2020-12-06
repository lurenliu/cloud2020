package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/25 20:23
 */
public interface LoadBlancer {

    // 使用自旋算法 完成轮询
     public ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
