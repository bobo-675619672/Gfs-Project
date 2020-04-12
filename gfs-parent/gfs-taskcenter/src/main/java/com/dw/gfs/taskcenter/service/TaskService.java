package com.dw.gfs.taskcenter.service;

import com.dw.gfs.taskcenter.entity.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> myTask(Long userId);

}
