package com.yy.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:20 2021/1/4
 *Description : 
 *Version     : 
 ***/

public interface MyLB {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
