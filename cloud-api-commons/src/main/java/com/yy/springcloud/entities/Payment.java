package com.yy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 14:33 2020/12/24
 *Description : 
 *Version     : 
 ***/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
