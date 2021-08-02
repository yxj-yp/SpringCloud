package com.yy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 15:49 2020/12/30
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableEurekaServer
public class EurekaMian7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMian7002.class,args);
    }
}
