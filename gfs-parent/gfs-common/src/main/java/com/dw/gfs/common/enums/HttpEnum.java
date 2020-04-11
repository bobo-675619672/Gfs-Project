package com.dw.gfs.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请求返回枚举类
 * @author liaodewen
 */

@Getter
@AllArgsConstructor
public enum HttpEnum {

    OK(200, "成功"),
    FAIL(999, "失败");

    private int code;
    private String msg;

}
