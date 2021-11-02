package com.yy.cloudalibaba.service;

import com.yy.cloudalibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 17:15 2021/11/1
 *Description : 
 *Version     : 
 ***/
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
