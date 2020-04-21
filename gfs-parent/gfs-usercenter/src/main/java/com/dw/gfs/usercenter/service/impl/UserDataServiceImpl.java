package com.dw.gfs.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dw.gfs.usercenter.dao.UserDataDao;
import com.dw.gfs.usercenter.entity.UserData;
import com.dw.gfs.usercenter.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDataServiceImpl extends ServiceImpl<UserDataDao, UserData> implements UserDataService {

    @Autowired
    private UserDataDao userDataDao;

    @Override
    public UserData selectByAccount(String account) {
        return userDataDao.selectOne(new QueryWrapper<UserData>().lambda().eq(UserData::getAccount, account));
    }
}
