package com.dw.gfs.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dw.gfs.usercenter.entity.UserData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理接口类
 *
 * @author liaodewen
 */
public interface UserDataService extends IService<UserData> {

    UserData selectByAccount(String account);

}
