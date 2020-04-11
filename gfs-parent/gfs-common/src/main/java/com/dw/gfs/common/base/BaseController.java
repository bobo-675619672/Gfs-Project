package com.dw.gfs.common.base;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.enums.HttpEnum;

/**
 * 基础控制类
 * @author liaodewen
 */
public class BaseController {

    public ResultData success() {
        return ResultData.builder()
                .code(HttpEnum.OK.getCode())
                .msg(HttpEnum.OK.getMsg())
                .build();
    }

    public <T>ResultData<T> success(T data) {
        return ResultData.<T>builder()
                .code(HttpEnum.OK.getCode())
                .msg(HttpEnum.OK.getMsg())
                .data(data)
                .build();
    }

    public ResultData error(String msg) {
        return ResultData.builder()
                .code(HttpEnum.FAIL.getCode())
                .msg(msg)
                .build();
    }

}
