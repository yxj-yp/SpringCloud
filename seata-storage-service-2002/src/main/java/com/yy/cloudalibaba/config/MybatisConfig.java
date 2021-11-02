package com.yy.cloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:31 2021/11/1
 *Description : 
 *Version     : 
 ***/
@Configuration
@MapperScan({"com.yy.cloudalibaba.dao"})
public class MybatisConfig {
}
