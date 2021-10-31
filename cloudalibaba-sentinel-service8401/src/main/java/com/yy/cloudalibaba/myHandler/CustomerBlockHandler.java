package com.yy.cloudalibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yy.springcloud.entities.CommonResult;
import com.yy.springcloud.entities.Payment;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 13:52 2021/10/29
 *Description : 
 *Version     : 
 ***/

public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return  new CommonResult(4444,"自定义降级方法,global handerException----1",new Payment(2021L,"serial2021"));
    }

    public static CommonResult handlerException2(BlockException exception){
        return  new CommonResult(4444,"自定义降级方法,global handerException----2",new Payment(2021L,"serial2021"));
    }


}
