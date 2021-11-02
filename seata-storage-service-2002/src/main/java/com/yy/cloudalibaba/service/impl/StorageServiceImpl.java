package com.yy.cloudalibaba.service.impl;

import com.yy.cloudalibaba.service.StorageService;
import com.yy.cloudalibaba.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:42 2021/11/2
 *Description : 
 *Version     : 
 ***/
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("-------------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("-------------->storage-service中扣减库存结束");
    }
}
