package com.dw.gfs.gateway.handler;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.enums.HttpEnum;
import com.dw.gfs.common.exception.GfsRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(GfsRuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultData defultGfsRuntimeExcepitonHandler(HttpServletRequest request, GfsRuntimeException e) {
        log.error("运行时异常 API:{} ", request.getRequestURL());
        log.error("错误信息: {}", e.getMessage());
        return getResponseMsg(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData defultExcepitonHandler(HttpServletRequest request, Exception e) {
        log.error("系统异常 API:：{} ", request.getRequestURL(), e);
        log.error("错误信息：{}",e.getMessage());
        return getResponseMsg(HttpEnum.FAIL.getCode(), String.format(HttpEnum.FAIL.getMsg(), e.getMessage()));
    }

    private ResultData getResponseMsg(int code,String msg) {
        return ResultData.builder()
                .code(code)
                .msg(msg)
                .build();
    }

}