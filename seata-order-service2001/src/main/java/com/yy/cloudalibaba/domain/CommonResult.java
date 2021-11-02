package com.yy.cloudalibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *Auth        : yanxiaojin
 *Date        : Create in 16:25 2021/11/1
 *Description : 
 *Version     : 
 ***/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String  message){
        this(code,message,null);
    }
}
