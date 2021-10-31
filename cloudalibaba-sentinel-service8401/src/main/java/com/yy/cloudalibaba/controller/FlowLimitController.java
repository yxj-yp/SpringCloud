package com.yy.cloudalibaba.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.util.TimeUtil;
import com.yy.cloudalibaba.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:41 2021/10/20
 *Description : 流控
 *Version     : 
 ***/
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){

        return "_______testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "_______testB";
    }

    public void test(){
//        CopyOnWriteArrayList
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e ){
            e.printStackTrace();;
        }
        System.out.println("________testD RT");
        return "________testD RT";
    }

    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",
            blockHandlerClass = CustomerBlockHandler.class,//指定降级处理类
            blockHandler = "handlerException2")//指定降级处理方法
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,@RequestParam(value = "p2",required = false) String p2){
        return "________testHotKey";
    }

    //降级方法
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "__________deal_testHotKey;";
    }
}
