package com.dw.gfs.usercenter.feign.interceptor;

import com.dw.gfs.common.utils.StringUtil;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.usercenter.utils.RequestUtil;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * feign请求拦截器
 * @author liaodewen
 */
@Slf4j
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("所有feign请求都经过这里...");
        HttpServletRequest httpServletRequest = RequestUtil.getHttpServletRequest();
        if (httpServletRequest != null) {
            String token = httpServletRequest.getHeader(TokenUtil.TOKEN_NAME);
            // 原来请求带token
            if (!StringUtil.isEmpty(token)) {
                template.header(TokenUtil.TOKEN_NAME, token);
                log.info("请求添加Token:{}", token);
            }
        }
    }

}
