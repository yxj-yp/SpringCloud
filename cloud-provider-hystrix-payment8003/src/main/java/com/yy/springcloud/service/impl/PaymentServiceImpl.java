package com.yy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 19:21 2021/1/4
 *Description : 
 *Version     : 
 ***/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_OK,id:"+id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timenum = 5;
        try { TimeUnit.SECONDS.sleep(timenum); } catch (InterruptedException e) {  e.printStackTrace(); }
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_TimeOut,id:"+id+",耗时(s)："+timenum;
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： "+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id:"+id+"\t /(ㄒoㄒ)/~~";
    }

    //=======服务熔断

    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = " 10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("****id 不能为负数 #");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "lt" + " W15, iike: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
       return "id 不能负数。请稍后再试，/( ToT)/~~ id: " +id;

    }
}
