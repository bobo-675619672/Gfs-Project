package com.dw.gfs.common.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 内容封装实体
 * @author liaodewen
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentDto {

    private Long id;

    private String name;

    private String userName;

    private Long userId;

}
