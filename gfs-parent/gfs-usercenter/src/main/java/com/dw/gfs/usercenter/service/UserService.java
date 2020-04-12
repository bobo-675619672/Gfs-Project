package com.dw.gfs.usercenter.service;

import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.dto.UserDto;

import java.util.List;

/**
 * 用户管理接口类
 *
 * @author liaodewen
 */
public interface UserService {

    UserDto info(Long userId);

    List<ContentDto> contents(Long userId);

    List<TaskDto> myTask(Long userId);
}
