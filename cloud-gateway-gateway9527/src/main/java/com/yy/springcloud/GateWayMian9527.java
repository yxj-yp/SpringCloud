package com.yy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:05 2021/9/14
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableEurekaClient
public class GateWayMian9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMian9527.class,args);
    }
}
