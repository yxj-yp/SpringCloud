package com.yy.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 15:23 2021/3/15
 *Description : 
 *Version     : 
 ***/
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMian9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMian9001.class,args);
    }

}
