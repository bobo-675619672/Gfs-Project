package com.dw.gfs.usercenter.feign.fallback;

import com.dw.gfs.usercenter.feign.client.ContentCenterFeignClient;
import com.dw.gfs.usercenter.feign.client.TaskCenterFeignClient;
import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 作业中心Feign熔断处理Factory
 *
 * @author liaodewen
 */
@Slf4j
@Component
public class TaskcenterFeignClientFallbackFactory implements FallbackFactory<TaskCenterFeignClient> {

    @Override
    public TaskCenterFeignClient create(Throwable throwable) {
        log.warn("作业中心熔断了...");
        return result -> Lists.newArrayList();
    }

}
