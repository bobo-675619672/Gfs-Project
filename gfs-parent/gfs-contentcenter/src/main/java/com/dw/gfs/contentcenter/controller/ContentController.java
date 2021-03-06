package com.dw.gfs.contentcenter.controller;

import com.dw.gfs.common.base.BaseController;
import com.dw.gfs.common.entity.ResultData;
import com.dw.gfs.contentcenter.entity.dto.ContentDto;
import com.dw.gfs.contentcenter.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController extends BaseController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/query/{userId}")
    public List<ContentDto> queryByUserId(@PathVariable("userId") Long userId) {
        return contentService.queryByUserId(userId);
    }

}
