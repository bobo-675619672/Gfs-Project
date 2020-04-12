package com.dw.gfs.usercenter.feign.client;

import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.feign.fallback.TaskcenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "tasktcenter", fallbackFactory = TaskcenterFeignClientFallbackFactory.class)
public interface TaskCenterFeignClient {

    /**
     * 根据用户id查询作业
     * @param userId 用户id
     * @return 作业封装实体
     */
    @GetMapping(value = "/task/myTask/{userId}")
    List<TaskDto> myTask(@PathVariable("userId") Long userId);


}
