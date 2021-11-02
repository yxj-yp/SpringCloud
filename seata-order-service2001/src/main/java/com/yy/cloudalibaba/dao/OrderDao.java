package com.yy.cloudalibaba.dao;


import com.yy.cloudalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:47 2021/11/1
 *Description : 
 *Version     : 
 ***/
@Mapper
public interface OrderDao {
    void create(Order order);//新建订单
    void update(@Param("userId") Long userId, @Param("status") Integer status);//修改订单状态
}
