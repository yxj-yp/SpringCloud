package com.yy.cloudalibaba.controller;

import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 11:03 2021/10/31
 *Description : 
 *Version     : 
 ***/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {//模拟从数据库获取数据
        hashMap.put(1L, new Payment(1L,"11111111111111111"));
        hashMap.put(2L, new Payment(2L,"22222222222222222"));
        hashMap.put(3L, new Payment(3L,"33333333333333333"));
    }
    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult = new CommonResult(200, "from mysql,serverProt:" + serverPort,payment);
        return commonResult;
    }
}
