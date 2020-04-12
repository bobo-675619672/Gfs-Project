package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.usercenter.entity.dto.LoginRequestVo;
import com.dw.gfs.usercenter.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Token控制类
 *
 * @author liaodewen
 */
@RestController
@RequestMapping("/token")
public class TokenController extends BaseController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/login")
    public ResultData login(@RequestBody LoginRequestVo vo) {
        return  success(tokenService.login(vo));
    }


}
