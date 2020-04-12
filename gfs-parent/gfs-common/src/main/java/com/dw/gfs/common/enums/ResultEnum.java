package com.dw.gfs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 结果枚举类
 * @author liaodewen
 */

@Getter
@AllArgsConstructor
public enum ResultEnum {

    // token: 1xxxx
    TOKEN_EMPTY(10001, "Token为空"),
    TOKEN_INVALID(10002, "Token失效"),
    TOKEN_ERROR(10003, "Token解析错误");

    private int code;
    private String msg;

}
