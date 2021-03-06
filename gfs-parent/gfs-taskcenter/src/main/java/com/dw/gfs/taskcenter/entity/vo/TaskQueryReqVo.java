package com.dw.gfs.taskcenter.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskQueryReqVo {

    private Long userId;

    private String taskName;

}
