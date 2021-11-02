package com.yy.cloudalibaba.controller;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.yy.cloudalibaba.service.AccountService;
import com.yy.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:48 2021/11/1
 *Description : 
 *Version     : 
 ***/
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping(value = "/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"额度扣减成功");
    }
}
