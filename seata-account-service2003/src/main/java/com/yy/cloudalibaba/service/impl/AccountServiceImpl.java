package com.yy.cloudalibaba.service.impl;

import ch.qos.logback.core.util.TimeUtil;
import com.yy.cloudalibaba.dao.AccountDao;
import com.yy.cloudalibaba.service.AccountService;
import com.yy.springcloud.entities.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 10:01 2021/11/2
 *Description : 
 *Version     : 
 ***/
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("---------->account-service中扣减账户余额开始");
        try {
            TimeUnit.SECONDS.sleep(20);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        accountDao.decrease(userId,money);
        log.info("---------->account-service中扣减账户余额结束");
    }
}
