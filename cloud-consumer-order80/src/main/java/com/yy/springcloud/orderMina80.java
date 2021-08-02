package com.yy.springcloud;

import com.yy.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:34 2020/12/30
 *Description : 
 *Version     : 
 ***/
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)//自定选择ribbn负载均衡算法
public class orderMina80 {
    public static void main(String[] args) {
        SpringApplication.run(orderMina80.class,args);
    }
}
