package com.dw.gfs.taskcenter.service.impl;

import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.taskcenter.entity.dto.TaskDto;
import com.dw.gfs.taskcenter.entity.vo.TaskQueryReqVo;
import com.dw.gfs.taskcenter.service.TaskService;
import com.dw.gfs.taskcenter.utils.RequestUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Override
    public List<TaskDto> myTask() {
        TokenBean tokenBean = RequestUtil.getTokenBean();
        log.info("tokenBean: {}", tokenBean);
        return Lists.newArrayList(
                TaskDto.builder()
                        .id(1L)
                        .name("作业1")
                        .remark("GET数据")
                        .build()
        );
    }

    @Override
    public List<TaskDto> list(TaskQueryReqVo reqVo) {
        TokenBean tokenBean = RequestUtil.getTokenBean();
        log.info("tokenBean: {}", tokenBean);
        return Lists.newArrayList(
                TaskDto.builder()
                        .id(1L)
                        .name(reqVo.getTaskName())
                        .remark("POST数据")
                        .build()
        );
    }

}
