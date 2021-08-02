package com.yy.springcloud.service;

import org.springframework.stereotype.Component;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:52 2021/1/14
 *Description : 
 *Version     : 
 ***/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back-----paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back-----paymentInfo_TimeOut";
    }
}
