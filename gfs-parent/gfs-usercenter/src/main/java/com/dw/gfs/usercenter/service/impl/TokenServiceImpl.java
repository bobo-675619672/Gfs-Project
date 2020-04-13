package com.dw.gfs.usercenter.service.impl;

import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.common.utils.DateUtil;
import com.dw.gfs.common.utils.TokenUtil;
import com.dw.gfs.usercenter.entity.vo.LoginReponseVo;
import com.dw.gfs.usercenter.entity.vo.LoginRequestVo;
import com.dw.gfs.usercenter.service.TokenService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Administrator
 */
@Slf4j
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public LoginReponseVo login(LoginRequestVo vo) {
        // 1.检查vo
        log.info("Account:{}, Password:{}", vo.getAccount(), vo.getPassword());
        // 2.构造tokenbean
        TokenBean tokenBean = TokenBean.builder()
                .userId(1L)
                .name("测试用户")
                .remark("自动生成Token")
                .build();
        Map<String, Object> claim = Maps.newHashMap();
        claim.put(TokenUtil.TOKEN_BEAN_NAME, tokenBean);
        // 3.生成token(有效期10天)
        String token = TokenUtil.getToken(claim, DateUtil.getNowIntervalDate(DateUtil.TIME_DAY, 10));
        log.info("Token:{}", token);
        return LoginReponseVo.builder()
                .token(token)
                .remark("测试用")
                .build();
    }

}
