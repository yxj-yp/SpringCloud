package com.yy.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yy.cloudalibaba.service.PaymentService;
import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.awt.*;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 11:32 2021/10/31
 *Description : 
 *Version     : 
 ***/
@RestController
public class CircleBreakerController {

    public static final String SERVER_RIL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * @SentinelResource注解的参数：
     * 1： fallback 处理运行时异常
     * 2： blockHandler 处理sentinel配置产生限流降级的 异常
     * 3： exceptionsToIgnore，忽略某个异常
     */
    @GetMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//无配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")//配置fallback
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler")//配置blockHandler
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",exceptionsToIgnore = IllegalArgumentException.class)
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVER_RIL + "/paymentSql/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常。。。");
        }else  if( result.getData() == null){
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常");
        }
        return result;
    }

    /**
     * 处理运行时异常的fallback
     * @param id
     * @param e
     * @return
     */
    public CommonResult handlerFallback(Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"异常handlerFallback，Exception内容："+ e.getMessage(), payment);
    }


    /**
     * 处理sentinel控制台配置流控的blockHandler
     * @param id
     * @param e
     * @return
     */
    public CommonResult blockHandler(Long id, BlockException e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,"blockHandler-sentinel限流，无此流水：blockException  "+ e.getMessage(), payment);
    }


    ///openFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable Long id){
        return paymentService.paymentSql(id);
    }
}
