package com.dw.gfs.usercenter.service;

import com.dw.gfs.usercenter.entity.vo.LoginReponseVo;
import com.dw.gfs.usercenter.entity.vo.LoginRequestVo;

/**
 * Token接口类
 * @author liaodewen
 */
public interface TokenService {

    LoginReponseVo login(LoginRequestVo vo);

}
