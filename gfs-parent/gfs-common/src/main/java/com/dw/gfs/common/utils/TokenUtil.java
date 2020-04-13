package com.dw.gfs.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.dw.gfs.common.entity.TokenBean;
import com.dw.gfs.common.enums.ResultEnum;
import com.dw.gfs.common.exception.GfsRuntimeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.Map;

/**
 * Token工具类
 * @author liaodewen
 */
public class TokenUtil {

    public static final String TOKEN_NAME = "token";
    public static final String TOKEN_BEAN_NAME = "TOKEN_BEAN";
    public static final String PRE_FIX = "Bearer ";
    public static final String SUBJECT = "GFS";
    public static final String TOKEN_KEY = "GFS_KEY";

    public static String getToken(Map<String, Object> claims, Date expireDate) {
        String token = "";
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        try {
            token = Jwts.builder()
                    .setSubject(SUBJECT)
                    .setClaims(claims)
                    .setIssuedAt(now)
                    .setExpiration(expireDate)
                    .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                    .compact();
            token = PRE_FIX + token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    public static Claims parseToken(String token) {
        if (StringUtil.isEmpty(token)) {
            throw new GfsRuntimeException(ResultEnum.TOKEN_EMPTY);
        }
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(TOKEN_KEY))
                    .parseClaimsJws(token.replaceFirst(PRE_FIX, ""))
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new GfsRuntimeException(ResultEnum.TOKEN_INVALID);
        } catch (Exception e) {
            throw new GfsRuntimeException(ResultEnum.TOKEN_ERROR);
        }
        return claims;
    }

    public static TokenBean getTokenBean(String token) {
        Claims claims = parseToken(token);
        JSONObject tokenObj = JSONObject.parseObject(JSONObject.toJSONString(claims.get(TOKEN_BEAN_NAME)));
        TokenBean bean = JSONObject.toJavaObject(tokenObj, TokenBean.class);
        return bean;
    }

}
