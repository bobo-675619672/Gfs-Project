package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.usercenter.entity.vo.LoginRequestVo;
import com.dw.gfs.usercenter.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "Token管理")
@RestController
@RequestMapping("/token")
public class TokenController extends BaseController {

    @Autowired
    private TokenService tokenService;

    @ApiOperation(value = "用户登录", notes = "获取token")
    @GetMapping("/login")
    public ResultData login(@RequestBody LoginRequestVo vo) {
        return  success(tokenService.login(vo));
    }

}
