package com.dw.gfs.usercenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("uc_data_user")
public class UserData {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String account;

    private String password;

    private String phone;

    private String idnoType;

    private String idno;

}
