package com.dw.gfs.usercenter.feign.client;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.ContentDto;
import com.dw.gfs.usercenter.feign.fallback.ContentcenterFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "contentcenter", fallbackFactory = ContentcenterFeignClientFallbackFactory.class)
public interface ContentCenterFeignClient {

    /**
     * 根据id查询内容
     * @param id 内容id
     * @return 内容封装实体
     */
    @GetMapping(value = "/content/query/{id}")
    ResultData<ContentDto> queryById(@PathVariable("id") Long id);

}
