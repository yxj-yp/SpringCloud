package com.yy.cloudalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:41 2021/10/20
 *Description : 流控
 *Version     : 
 ***/
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "_______testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "_______testB";
    }
}
