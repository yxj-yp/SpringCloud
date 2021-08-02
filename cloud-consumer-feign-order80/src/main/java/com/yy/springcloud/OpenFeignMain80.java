package com.yy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:21 2021/1/4
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableFeignClients//开启feign
public class OpenFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignMain80.class,args);
    }
}
