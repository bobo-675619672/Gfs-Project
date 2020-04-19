package com.dw.gfs.gateway.config;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "gfs.path.white")
public class WhitePathConfig {

    List<String> usercenter = Lists.newArrayList();

    List<String> contentcenter = Lists.newArrayList();

    List<String> taskcenter = Lists.newArrayList();

    public JSONObject getWhiteList() {
        JSONObject reuslt = new JSONObject();
        reuslt.put("usercenter", usercenter);
        reuslt.put("contentcenter", contentcenter);
        reuslt.put("taskcenter", taskcenter);
        return reuslt;
    }

}
