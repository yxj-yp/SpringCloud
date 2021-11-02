package com.yy.cloudalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 9:26 2021/11/2
 *Description : 
 *Version     : 
 ***/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long id;
    private Long productId;//产品id
    private Integer total;//总库存
    private Integer used;//已用库存
    private Integer residue;//剩余库存
}
