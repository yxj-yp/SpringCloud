package com.yy.springcloud.service;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:23 2021/1/4
 *Description : 
 *Version     : 
 ***/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//使用
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
