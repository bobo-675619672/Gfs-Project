package com.dw.gfs.gateway.filter;

import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.common.enums.ResultEnum;
import com.dw.gfs.common.exception.GfsRuntimeException;
import com.dw.gfs.common.utils.StringUtil;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.gateway.config.PathConfig;
import com.dw.gfs.gateway.constant.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * Token过滤器
 * @author liaodewen
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private PathConfig pathConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求经过TokenFilter!");
        ServerHttpRequest request = exchange.getRequest();
        List<String> whiteList = pathConfig.getWhiteList();
        String path = request.getPath().value();
        // 不在白名单列表
        if (!whiteList.contains(path)) {
            String token = request.getHeaders().getFirst(TokenUtil.TOKEN_NAME);
            log.info("Token:{}", token);
            TokenBean tokenBean = TokenUtil.getTokenBean(token);
            // token验证
            log.info("TokenBean:{}", tokenBean);
        }
        // 在白名单列表
        else {
            log.info("Path:{} 允许匿名访问!", request.getPath().value());
        }
        return chain.filter(exchange);
    }

    /**
     * 设置过滤器的执行顺序
     * @return
     */
    @Override
    public int getOrder() {
        return Constant.TOKEN_FILTER_ORDER;
    }

}