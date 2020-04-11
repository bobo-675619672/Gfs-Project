package com.dw.gfs.contentcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 内容中心Application类
 * @author liaodewen
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.dw.gfs.common.feign")
public class ContencenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContencenterApplication.class, args);
    }

}
