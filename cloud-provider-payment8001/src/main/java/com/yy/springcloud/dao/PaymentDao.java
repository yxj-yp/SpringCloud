package com.yy.springcloud.dao;

import com.yy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 14:38 2020/12/24
 *Description : 
 *Version     : 
 ***/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
