package com.dw.gfs.taskcenter.utils;

import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.common.utils.TokenUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public static HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    public static TokenBean getTokenBean() {
        HttpServletRequest request = getHttpServletRequest();
        return TokenUtil.getTokenBean(request.getHeader(TokenUtil.TOKEN_NAME));
    }

}
