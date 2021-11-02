package com.yy.cloudalibaba.domain;

import com.alibaba.fastjson.serializer.BigDecimalCodec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:56 2021/11/2
 *Description : 
 *Version     : 
 ***/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private Long userId;//用户id
    private BigDecimal total;//总额度
    private BigDecimal used;//已使用额度
    private BigDecimal residue;//剩余额度
}
