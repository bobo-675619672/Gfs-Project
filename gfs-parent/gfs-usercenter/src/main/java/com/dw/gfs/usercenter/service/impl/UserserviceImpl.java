package com.dw.gfs.usercenter.service.impl;

import com.dw.gfs.common.entity.dto.UserDto;
import com.dw.gfs.usercenter.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户管理实现类
 * @author liaodewen
 */
@Service
public class UserserviceImpl implements UserService {

    @Override
    public UserDto queryUserDtoById(Long id) {
        return UserDto.builder()
                .id(id)
                .name("测试用户")
                .account("123456")
                .password("abcd")
                .build();
    }

}
