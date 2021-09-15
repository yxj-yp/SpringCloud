package com.yy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 20:04 2021/9/15
 *Description : 
 *Version     : 
 ***/
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
