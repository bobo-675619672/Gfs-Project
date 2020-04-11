package com.dw.gfs.common.feign;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.ContentDto;
import com.dw.gfs.common.feign.fallback.ContentcenterFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 内容中心Feign
 * @author liaodewen
 */
@FeignClient(name = "contentcenter", fallbackFactory = ContentcenterFeignFallbackFactory.class)
public interface ContentcenterFeign {

    /**
     * 根据id查询内容
     * @param id 内容id
     * @return 内容封装实体
     */
    @GetMapping(value = "/content/query/{id}")
    ResultData<ContentDto> queryById(@PathVariable("id") Long id);

}
