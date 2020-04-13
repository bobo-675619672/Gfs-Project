package com.dw.gfs.usercenter.service.impl;

import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.dto.UserDto;
import com.dw.gfs.usercenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.usercenter.feign.client.ContentCenterFeignClient;
import com.dw.gfs.usercenter.feign.client.TaskCenterFeignClient;
import com.dw.gfs.usercenter.service.UserService;
import com.dw.gfs.usercenter.utils.RequestUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理实现类
 * @author liaodewen
 */
@Slf4j
@Service
public class UserserviceImpl implements UserService {

    @Autowired
    private ContentCenterFeignClient contentCenterFeignClient;
    @Autowired
    private TaskCenterFeignClient taskCenterFeignClient;

    @Override
    public UserDto info(Long id) {
        return UserDto.builder()
                .id(id)
                .name("测试用户")
                .account("123456")
                .password("abcd")
                .build();
    }

    @Override
    public List<ContentDto> contents(Long userId) {
        List<ContentDto> result = contentCenterFeignClient.query(userId);
        result.stream().forEach(contentDto -> {
            contentDto.setUserName("测试用户");
        });
        return result;
    }

    @Override
    public List<TaskDto> myTask() {
        return taskCenterFeignClient.myTask();
    }

    @Override
    public List<TaskDto> taskList(TaskQueryReqVo reqVo) {
        TokenBean tokenBean = RequestUtil.getTokenBean();
        log.info("tokenBean: {}", tokenBean);
        return taskCenterFeignClient.list(reqVo);
    }

}
