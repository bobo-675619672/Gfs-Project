package com.dw.gfs.usercenter.feign.fallback;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.enums.HttpEnum;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.feign.client.ContentCenterFeignClient;
import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 内容中心Feign熔断处理Factory
 *
 * @author liaodewen
 */
@Slf4j
@Component
public class ContentcenterFeignClientFallbackFactory implements FallbackFactory<ContentCenterFeignClient> {

    @Override
    public ContentCenterFeignClient create(Throwable throwable) {
        log.warn("内容中心熔断了...");
        return result -> Lists.newArrayList();
    }

}
