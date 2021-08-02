package com.yy.springcloud.service;

import com.yy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 15:04 2020/12/24
 *Description : 
 *Version     : 
 ***/

public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
