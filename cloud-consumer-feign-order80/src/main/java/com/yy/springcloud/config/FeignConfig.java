package com.yy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:32 2021/1/4
 *Description : 
 *Version     : 
 ***/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
