package com.dw.gfs.usercenter.feign.config;

import com.dw.gfs.usercenter.feign.interceptor.FeignBasicAuthRequestInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * 全局feign配置
 * 不要加@Configuration
 * @author liaodewen
 */
public class GlobalFeignConfiguration {

    @Bean
    public Logger.Level level(){
        // 让feign打印所有请求的细节
        return Logger.Level.FULL;
    }

    /**
     * 请求拦截器
     * @return
     */
    @Bean
    public FeignBasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }

}
