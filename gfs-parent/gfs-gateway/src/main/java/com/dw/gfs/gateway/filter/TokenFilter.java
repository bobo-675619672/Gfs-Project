package com.dw.gfs.gateway.filter;

import com.alibaba.fastjson.JSONArray;
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

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Token过滤器
 * @author liaodewen
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private WhitePathConfig whitePathConfig;

    // path格式: /{微服务名}/{地址}
    private static final String PATH_PATTERN = "\\/(\\w*)(\\/.*)?";

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
        Pattern p = Pattern.compile(PATH_PATTERN);
        Matcher m = p.matcher(path);
        if (m.find()) {
            String appName = m.group(1);
            String realPath = m.group(2);
            if (isDefault(realPath)) {
                return true;
            }
            try {
                JSONArray whiteList = whitePathConfig.getWhiteList().getJSONArray(appName);
                if (!whiteList.isEmpty()) {
                    for (int i = 0; i < whiteList.size(); i++) {
                        String uri = whiteList.getString(i);
                        if ((uri.endsWith("**")) && (realPath.indexOf(uri.substring(0, uri.lastIndexOf("**"))) == 0)) {
                            return true;
                        }
                        if (uri.equals(realPath)) {
                            return true;
                        }
                    }
                }
            } catch (Exception e) {
                log.info("白名单处理异常!", e);
            }
        }
        return false;
    }

    private boolean isDefault(String path) {
        List<String> defaults = whitePathConfig.getDefaults();
        for (String temp : defaults) {
            if ((temp.endsWith("**")) && (path.indexOf(temp.substring(0, temp.lastIndexOf("**"))) == 0)) {
                return true;
            }
            if (temp.equals(path)) {
                return true;
            }
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