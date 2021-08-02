package com.yy.springcloud.service.impl;

import com.yy.springcloud.dao.PaymentDao;
import com.yy.springcloud.entities.Payment;
import com.yy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 15:05 2020/12/24
 *Description : 
 *Version     : 
 ***/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
