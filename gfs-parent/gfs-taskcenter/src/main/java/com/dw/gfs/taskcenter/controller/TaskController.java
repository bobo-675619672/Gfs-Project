package com.dw.gfs.taskcenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.taskcenter.entity.dto.TaskDto;
import com.dw.gfs.taskcenter.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/myTask/{userId}")
    public List<TaskDto> myTask(@PathVariable("userId") Long userId) {
        return taskService.myTask(userId);
    }


}
