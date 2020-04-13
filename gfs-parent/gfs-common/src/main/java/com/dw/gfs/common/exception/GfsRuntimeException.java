package com.dw.gfs.common.exception;

import com.dw.gfs.common.enums.ResultEnum;
import com.dw.gfs.common.utils.StringUtil;
import lombok.Getter;

@Getter
public class GfsRuntimeException extends RuntimeException {

    public GfsRuntimeException(ResultEnum httpEnum, String ... params) {
        super(StringUtil.format(httpEnum.getMsg(), params));
        this.code = httpEnum.getCode();
    }

    public GfsRuntimeException(Exception e, ResultEnum httpEnum, String ... params) {
        super(StringUtil.format(httpEnum.getMsg(),params));
        this.code = httpEnum.getCode();
    }

    public GfsRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    private int code;

}
