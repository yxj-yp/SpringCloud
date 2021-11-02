package com.yy.cloudalibaba.dao;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.math.BigDecimal;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:47 2021/11/1
 *Description : 
 *Version     : 
 ***/
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);//扣额度
}
