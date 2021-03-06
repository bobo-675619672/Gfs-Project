package com.dw.gfs.usercenter.feign.fallback;

import com.dw.gfs.common.enums.HttpEnum;
import com.dw.gfs.common.enums.ResultEnum;
import com.dw.gfs.common.exception.GfsRuntimeException;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.usercenter.feign.client.ContentCenterFeignClient;
import com.dw.gfs.usercenter.feign.client.TaskCenterFeignClient;
import com.google.common.collect.Lists;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作业中心Feign熔断处理Factory
 * @author liaodewen
 */
@Slf4j
@Component
public class TaskcenterFeignClientFallbackFactory implements FallbackFactory<TaskCenterFeignClient> {

    @Override
    public TaskCenterFeignClient create(Throwable throwable) {
        log.warn("作业中心熔断了...");

        throw new GfsRuntimeException(ResultEnum.TOKEN_EMPTY);

//        return new TaskCenterFeignClient() {
//            @Override
//            public List<TaskDto> myTask() {
//                return Lists.newArrayList();
//            }
//
//            @Override
//            public List<TaskDto> list(TaskQueryReqVo reqVo) {
//                return Lists.newArrayList();
//            }
//        };
    }

}
