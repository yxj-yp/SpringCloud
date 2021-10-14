package com.yy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 11:50 2021/9/28
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigMian3366 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMian3366.class, args);
    }
}
