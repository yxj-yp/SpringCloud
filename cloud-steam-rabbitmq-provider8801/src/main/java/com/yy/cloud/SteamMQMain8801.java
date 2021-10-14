package com.yy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:56 2021/10/13
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableEurekaClient
public class SteamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(SteamMQMain8801.class, args);
    }
}
