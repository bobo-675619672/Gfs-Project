package com.dw.gfs.taskcenter.service.impl;

import com.dw.gfs.taskcenter.entity.dto.TaskDto;
import com.dw.gfs.taskcenter.service.TaskService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDto> myTask(Long userId) {
        return Lists.newArrayList(
                TaskDto.builder()
                        .id(1L)
                        .name("作业1")
                        .remark("测试数据")
                        .build(),
                TaskDto.builder()
                        .id(2L)
                        .name("作业2")
                        .remark("测试数据")
                        .build()
        );
    }

}
