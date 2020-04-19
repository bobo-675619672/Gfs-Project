package com.dw.gfs.usercenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sentinel
 * @author liaodewen
 */
@RestController
@RequestMapping("/s")
public class SentinelController extends BaseController {

    @GetMapping("/test1")
    public ResultData<String> test1() {
        return success("测试1");
    }

    @GetMapping("/test2")
    public ResultData<String> test2() {
        return success("测试2");
    }

}
