package com.yy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:08 2021/9/14
 *Description : gateway配置
 *Version     : 
 ***/
//@Configuration
public class GatewayConfig {
//    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route(r->r.path("/aa").uri("目标网址")).build();
        return routes.build();
    }
}
