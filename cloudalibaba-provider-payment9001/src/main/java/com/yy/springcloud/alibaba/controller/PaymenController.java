package com.yy.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 11:28 2021/10/14
 *Description : 
 *Version     : 
 ***/
@RestController
public class PaymenController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "nacos registy, serverPort: "+serverPort+"\t id:"+id;
    }
}
