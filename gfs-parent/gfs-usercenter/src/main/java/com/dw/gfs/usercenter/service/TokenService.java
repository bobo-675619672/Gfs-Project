package com.dw.gfs.usercenter.service;

import com.dw.gfs.usercenter.entity.dto.*;

import java.util.List;

/**
 * Token接口类
 * @author liaodewen
 */
public interface TokenService {

    LoginReponseVo login(LoginRequestVo vo);

}
