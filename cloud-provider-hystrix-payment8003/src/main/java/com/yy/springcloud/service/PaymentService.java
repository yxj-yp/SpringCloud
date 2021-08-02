package com.yy.springcloud.service;


/***
 *Auth        : yanxiaojin
 *Date        : Create in 19:19 2021/1/4
 *Description : 
 *Version     : 
 ***/
public interface PaymentService {
     String paymentInfo_OK(Integer id);
     String paymentInfo_TimeOut(Integer id);
     String paymentCircuitBreaker(Integer id);
}
