package com.yy.cloudalibaba.service;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:40 2021/11/2
 *Description : 
 *Version     : 
 ***/

public interface StorageService {
    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
