package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.entity.dto.UserDto;
import com.dw.gfs.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/query/{id}")
    public ResultData<UserDto> queryUserDtoById(@PathVariable("id") Long id) {
        return success(userService.queryUserDtoById(id));
    }

    @GetMapping("/show/{msg}")
    public ResultData<String> show(@PathVariable("msg") String msg) {
        return success(msg);
    }

}
