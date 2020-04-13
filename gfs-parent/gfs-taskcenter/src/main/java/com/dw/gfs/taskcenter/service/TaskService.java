package com.dw.gfs.taskcenter.service;

import com.dw.gfs.taskcenter.entity.dto.TaskDto;
import com.dw.gfs.taskcenter.entity.vo.TaskQueryReqVo;

import java.util.List;

public interface TaskService {

    List<TaskDto> myTask();

    List<TaskDto> list(TaskQueryReqVo reqVo);
}
