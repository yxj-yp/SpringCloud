package com.yy.cloud.controller;

import com.yy.cloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 14:09 2021/10/13
 *Description : 
 *Version     : 
 ***/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}
