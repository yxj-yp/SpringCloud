package com.yy.cloudalibaba.controller;

import com.yy.cloudalibaba.domain.CommonResult;
import com.yy.cloudalibaba.domain.Order;
import com.yy.cloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:48 2021/11/1
 *Description : 
 *Version     : 
 ***/
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
