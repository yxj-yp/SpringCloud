package com.yy.cloudalibaba.service.impl;

import com.yy.cloudalibaba.dao.OrderDao;
import com.yy.cloudalibaba.domain.Order;
import com.yy.cloudalibaba.service.AccountService;
import com.yy.cloudalibaba.service.OrderService;
import com.yy.cloudalibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:16 2021/11/1
 *Description : 
 *Version     : 
 ***/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------>开始新建订单");
        orderDao.create(order);

        log.info("------>订单微服务开始调用库存，扣减count");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------>订单微服务开始调用库存，扣减end");

        log.info("------>订单微服务开始调用账户，扣减money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------>订单微服务开始调用账户，扣减money end");

        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");

        log.info("------>下订单完成");

    }
}
