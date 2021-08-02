package com.yy.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 14:35 2020/12/24
 *Description : 
 *Version     : 
 ***/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public  CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
