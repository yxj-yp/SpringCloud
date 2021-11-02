package com.yy.cloudalibaba.service;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.yy.cloudalibaba.domain.CommonResult;
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
@FeignClient(value = "seata-account-service")
public interface AccountService {
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
