package com.dw.gfs.usercenter.entity.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;

    private String account;

    private String name;

    private String password;

    private int status;

    private String remark;

}
