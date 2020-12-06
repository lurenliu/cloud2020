package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tiam
 * @version 1.0
 * @date 2020/11/25 20:26
 */
@Component
@Slf4j
public class LBImpl implements LoadBlancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);



    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);

    }

    public final int getAndIncrement(){

        int value;
        int next;
        do{
             value = this.atomicInteger.get();
            log.info("-----------------next-------------- " + value);
             next = value >= 2147483647 ? 0 : value + 1;
        }while(!atomicInteger.compareAndSet(value , next));
        System.out.println("********** next : " + next);
        return next;
    }


//    public
}
