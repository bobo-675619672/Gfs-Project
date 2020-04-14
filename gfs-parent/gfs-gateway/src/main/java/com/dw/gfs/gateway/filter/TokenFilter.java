package com.dw.gfs.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.gateway.config.WhitePathConfig;
import com.dw.gfs.gateway.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * Token过滤器
 * @author liaodewen
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private WhitePathConfig whitePathConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("请求经过TokenFilter!");
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        // 不在白名单列表
        if (!isWhitePath(path)) {
            log.info("Path:{} 需要校验Token!", path);
            String token = request.getHeaders().getFirst(TokenUtil.TOKEN_NAME);
            log.info("Token:{}", token);
            TokenBean tokenBean = TokenUtil.getTokenBean(token);
            // token验证
            log.info("TokenBean:{}", tokenBean);
        }
        // 在白名单列表
        else {
            log.info("Path:{} 允许匿名访问!", path);
        }
        return chain.filter(exchange);
    }

    private boolean isWhitePath(String path) {
        // path格式: /{微服务名}/{地址}
        try {
            List<String> whiteList = whitePathConfig.getWhiteList();
            for (String uri : whiteList) {
                if ((uri.endsWith("**")) && (path.indexOf(uri.substring(0, uri.lastIndexOf("**"))) == 0)) {
                    return true;
                }
                if (uri.equals(path)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.info("白名单处理异常!", e);
        }
        return false;
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