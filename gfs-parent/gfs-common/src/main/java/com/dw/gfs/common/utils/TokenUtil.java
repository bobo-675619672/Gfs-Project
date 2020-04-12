//package com.dw.gfs.common.utils;
//
//import com.dw.gfs.common.enums.HttpEnum;
//import com.dw.gfs.common.enums.ResultEnum;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.xml.bind.DatatypeConverter;
//import java.util.Date;
//import java.util.Map;
//
//@Slf4j
//public class TokenUtil {
//
//    public static final String TOKEN_NAME = "token";
//    public static final String TOKEN_BEAN_NAME = "TOKEN_BEAN";
//    public static final String PRE_FIX = "Bearer ";
//    public static final String SUBJECT = "GZYY";
//    public static final String TOKEN_KEY = "GZYY_KEY";
//
//    public static String getToken(Map<String, Object> claims, Date expireDate) {
//        String token = "";
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//        try {
//            token = Jwts.builder()
//                    .setSubject(SUBJECT)
//                    .setClaims(claims)
//                    .setIssuedAt(now)
//                    .setExpiration(expireDate)
//                    .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
//                    .compact();
//            token = PRE_FIX + token;
//        } catch (Exception e) {
//            log.error("生成token失败!", e);
//        }
//        return token;
//    }
//
//    public static Claims parseToken(String token) {
//        if (StringUtils.isEmpty(token)) {
//            throw new DrugRuntimeException(ResultEnum.TOKEN_EMPTY);
//        }
//        Claims claims = null;
//        try {
//            claims = Jwts.parser()
//                    .setSigningKey(DatatypeConverter.parseBase64Binary(TOKEN_KEY))
//                    .parseClaimsJws(token.replaceFirst(PRE_FIX, ""))
//                    .getBody();
//        } catch (ExpiredJwtException e) {
//            throw new DrugRuntimeException(ResultEnum.TOKEN_INVALID);
//        } catch (Exception e) {
//            log.error("Token解析异常! Token:{}", token);
//            throw new DrugRuntimeException(ResultEnum.TOKEN_ERROR);
//        }
//        return claims;
//    }
//
//    public static TokenBean getTokenBean(String token) {
//        Claims claims = parseToken(token);
//        JSONObject tokenObj = JSONObject.parseObject(String.valueOf(claims.get(TOKEN_BEAN_NAME)));
//        TokenBean bean = (TokenBean) JSONObject.toJavaObject(tokenObj, TokenBean.class);
//        return bean;
//    }
//
//
//}
