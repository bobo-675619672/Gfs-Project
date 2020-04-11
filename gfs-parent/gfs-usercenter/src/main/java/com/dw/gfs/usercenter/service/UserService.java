package com.dw.gfs.usercenter.service;

import com.dw.gfs.common.entity.dto.UserDto;

/**
 * 用户管理接口类
 * @author liaodewen
 */
public interface UserService {

    UserDto queryUserDtoById(Long id);

}
