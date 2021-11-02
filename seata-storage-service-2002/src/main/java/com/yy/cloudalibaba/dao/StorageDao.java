package com.yy.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:33 2021/11/2
 *Description : 
 *Version     : 
 ***/
@Mapper
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
