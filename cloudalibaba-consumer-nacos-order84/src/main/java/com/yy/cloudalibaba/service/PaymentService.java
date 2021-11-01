package com.yy.cloudalibaba.service;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:31 2021/10/31
 *Description : 
 *Version     : 
 ***/
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
