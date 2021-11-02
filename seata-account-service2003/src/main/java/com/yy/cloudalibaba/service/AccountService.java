package com.yy.cloudalibaba.service;

import com.yy.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:15 2021/11/1
 *Description : 
 *Version     : 
 ***/
public interface AccountService {

    void decrease(Long userId,BigDecimal money);
}
