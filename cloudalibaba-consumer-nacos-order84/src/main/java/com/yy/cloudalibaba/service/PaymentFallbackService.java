package com.yy.cloudalibaba.service;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:34 2021/10/31
 *Description : 
 *Version     : 
 ***/
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService", new Payment(id,"error"));
    }
}
