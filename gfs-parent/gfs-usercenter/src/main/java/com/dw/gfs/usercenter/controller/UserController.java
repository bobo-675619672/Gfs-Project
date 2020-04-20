package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.usercenter.entity.dto.ContentDto;
import com.dw.gfs.usercenter.entity.dto.TaskDto;
import com.dw.gfs.usercenter.entity.dto.UserDto;
import com.dw.gfs.usercenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.usercenter.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户信息")
    @GetMapping("/info/{userId}")
    public ResultData<UserDto> info(@PathVariable("userId") Long userId) {
        return success(userService.info(userId));
    }

    @ApiOperation("用户内容")
    @GetMapping("/contents/{userId}")
    public ResultData<List<ContentDto>> contents(@PathVariable("userId") Long userId) {
        return success(userService.contents(userId));
    }

    @ApiOperation("我的作业")
    @GetMapping("/myTask")
    public ResultData<List<TaskDto>> myTask(@RequestHeader("token") String token) {
        log.info("token:{}, userId:{}", token);
        return success(userService.myTask());
    }

    @ApiOperation("作业列表")
    @PostMapping("/task/list")
    public ResultData<List<TaskDto>> taskList(@RequestBody TaskQueryReqVo reqVo) {
        return success(userService.taskList(reqVo));
    }

}
