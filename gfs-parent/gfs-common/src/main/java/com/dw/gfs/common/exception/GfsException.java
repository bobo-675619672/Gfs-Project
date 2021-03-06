package com.dw.gfs.common.exception;

import com.dw.gfs.common.enums.ResultEnum;
import lombok.Getter;

@Getter
public class GfsException extends Exception{

    public GfsException(ResultEnum httpEnum) {
        super(httpEnum.getMsg());
        this.code = httpEnum.getCode();
    }

    public GfsException(int code, String message) {
        super(message);
        this.code = code;
    }

    private int code;

}
