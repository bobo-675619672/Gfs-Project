package com.dw.gfs.usercenter.feign.client;

import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.usercenter.feign.config.GlobalFeignConfiguration;
import com.dw.gfs.usercenter.feign.fallback.TaskcenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "taskcenter", configuration = GlobalFeignConfiguration.class, fallbackFactory = TaskcenterFeignClientFallbackFactory.class)
public interface TaskCenterFeignClient {

    /**
     * Get无参请求
     * token自动填充
     * @return 作业封装实体
     */
    @GetMapping(value = "/task/myTask")
    List<TaskDto> myTask();

    /**
     * Post body请求
     * token自动填充
     * @param reqVo 请求vo
     * @return 作业封装实体
     */
    @PostMapping(value = "/task/list")
    List<TaskDto> list(@RequestBody TaskQueryReqVo reqVo);

}
