package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.dto.UserDto;
import com.dw.gfs.usercenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

    @GetMapping("/myTask")
    public ResultData<List<TaskDto>> myTask(@RequestHeader("token") String token) {
        log.info("token:{}, userId:{}", token);
        return success(userService.myTask());
    }

    @PostMapping("/task/list")
    public ResultData<List<TaskDto>> taskList(@RequestBody TaskQueryReqVo reqVo) {
        return success(userService.taskList(reqVo));
    }

}
