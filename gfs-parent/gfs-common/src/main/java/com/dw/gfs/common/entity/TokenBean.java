package com.dw.gfs.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenBean {

    private String userType;

    private String name;

    private Long userId;

    private String phone;

    private String unionId;

    private String openId;

    private String remark;

}
