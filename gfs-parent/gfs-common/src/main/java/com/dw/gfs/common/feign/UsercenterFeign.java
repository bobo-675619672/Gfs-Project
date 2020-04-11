package com.dw.gfs.common.feign;

import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.UserDto;
import com.dw.gfs.common.feign.fallback.UsercenterFeignFallbackFactory;
import lombok.Builder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户中心Feign
 * @author liaodewen
 */
@FeignClient(name = "usercenter", fallbackFactory = UsercenterFeignFallbackFactory.class)
public interface UsercenterFeign {

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return 用户封装实体
     */
    @GetMapping(value = "/user/query/{id}")
    ResultData<UserDto> queryById(@PathVariable("id") Long id);

}
