package com.yy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:40 2020/12/30
 *Description : 
 *Version     : 
 ***/
@Configuration
public class ApplicationContextConfig {
    @Bean
//测试自己写的负载均衡算法  注释掉    @LoadBalanced//负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
