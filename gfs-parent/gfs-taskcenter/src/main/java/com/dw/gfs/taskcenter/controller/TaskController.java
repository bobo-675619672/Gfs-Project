package com.dw.gfs.taskcenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.taskcenter.entity.dto.TaskDto;
import com.dw.gfs.taskcenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.taskcenter.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/myTask")
    public List<TaskDto> myTask() {
        return taskService.myTask();
    }

    @PostMapping("/list")
    public List<TaskDto> list(@RequestBody TaskQueryReqVo reqVo) {
        return taskService.list(reqVo);
    }

}
