package com.dw.gfs.common.feign.fallback;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.UserDto;
import com.dw.gfs.common.enums.HttpEnum;
import com.dw.gfs.common.feign.UsercenterFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 用户中心Feign熔断处理Factory
 * @author liaodewen
 */
@Slf4j
@Component
public class UsercenterFeignFallbackFactory implements FallbackFactory<UsercenterFeign> {

    @Override
    public UsercenterFeign create(Throwable throwable) {
        log.error("用户中心熔断了!", throwable);
        return result -> ResultData.<UserDto>builder()
                .data(UserDto.builder()
                        .id(-1L)
                        .name("用户中心熔断了!")
                        .build())
                .code(HttpEnum.FAIL.getCode())
                .build();
    }


}
