package com.yy.springcloud.loadbalance.impl;

import com.yy.springcloud.loadbalance.MyLB;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:21 2021/1/4
 *Description : 自定义负载均衡算法（手写）
 *Version     : 
 ***/
@Component
public class myLBImpl implements MyLB {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current,next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("****第几次访问，次数next："+next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
