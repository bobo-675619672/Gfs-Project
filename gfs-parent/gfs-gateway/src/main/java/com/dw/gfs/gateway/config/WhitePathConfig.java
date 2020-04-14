package com.dw.gfs.gateway.config;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Component
@Configuration
@ConfigurationProperties(prefix = "gfs.path.white")
public class WhitePathConfig {

    List<String> usercenter = Lists.newArrayList();

    List<String> contentcenter = Lists.newArrayList();

    List<String> taskcenter = Lists.newArrayList();

    public List<String> getWhiteList() {
        List<String> reuslt = Lists.newArrayList();
        reuslt.addAll(usercenter.stream().map(i -> i = "/usercenter" + i).collect(Collectors.toList()));
        reuslt.addAll(contentcenter.stream().map(i -> i = "/contentcenter" + i).collect(Collectors.toList()));
        reuslt.addAll(taskcenter.stream().map(i -> i = "/taskcenter" + i).collect(Collectors.toList()));
        return reuslt;
    }

}
