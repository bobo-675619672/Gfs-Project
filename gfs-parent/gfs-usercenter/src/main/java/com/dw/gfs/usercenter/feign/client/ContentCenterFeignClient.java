package com.dw.gfs.usercenter.feign.client;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.feign.fallback.ContentcenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "contentcenter", fallbackFactory = ContentcenterFeignClientFallbackFactory.class)
public interface ContentCenterFeignClient {

    /**
     * 根据id查询内容
     *
     * @param userId 用户id
     * @return 内容封装实体
     */
    @GetMapping(value = "/content/query/{userId}")
    List<ContentDto> query(@PathVariable("userId") Long userId);

}
