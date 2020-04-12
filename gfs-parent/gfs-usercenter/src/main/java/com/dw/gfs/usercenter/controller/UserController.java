package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.dto.UserDto;
import com.dw.gfs.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/{userId}")
    public ResultData<UserDto> info(@PathVariable("userId") Long userId) {
        return success(userService.info(userId));
    }

    @GetMapping("/contents/{userId}")
    public ResultData<List<ContentDto>> contents(@PathVariable("userId") Long userId) {
        return success(userService.contents(userId));
    }

    @GetMapping("/myTask/{userId}")
    public ResultData<List<TaskDto>> myTask(@PathVariable("userId") Long userId) {
        return success(userService.myTask(userId));
    }


}
