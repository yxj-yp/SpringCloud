package com.yy.springclout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationExtensionsKt;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:00 2021/9/15
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMian3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMian3344.class,args);
    }
}
