package com.dw.gfs.common.feign.fallback;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.ContentDto;
import com.dw.gfs.common.enums.HttpEnum;
import com.dw.gfs.common.feign.ContentcenterFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 内容中心Feign熔断处理Factory
 * @author liaodewen
 */
@Slf4j
@Component
public class ContentcenterFeignFallbackFactory implements FallbackFactory<ContentcenterFeign> {

    @Override
    public ContentcenterFeign create(Throwable throwable) {
        log.error("内容中心熔断了!", throwable);
        return result -> ResultData.<ContentDto>builder()
                .data(ContentDto.builder()
                        .id(-1L)
                        .name("内容中心熔断了!")
                        .build())
                .code(HttpEnum.FAIL.getCode())
                .build();
    }


}
