package com.yy.cloudalibaba.controller;

import com.yy.cloudalibaba.service.StorageService;
import com.yy.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:47 2021/11/2
 *Description : 
 *Version     : 
 ***/
@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long produceId, @RequestParam("count")Integer count){
        storageService.decrease(produceId, count);
        return  new CommonResult(200,"扣减库存成功");
    }
}
