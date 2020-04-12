package com.dw.gfs.contentcenter.service.impl;

import com.dw.gfs.contentcenter.entity.dto.ContentDto;
import com.dw.gfs.contentcenter.service.ContentService;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容管理实现类
 *
 * @author liaodewen
 */
@Service
public class ContentserviceImpl implements ContentService {

    @Override
    public List<ContentDto> queryByUserId(Long userId) {
        return Lists.newArrayList(
                ContentDto.builder()
                        .id(1L)
                        .name("内容1")
                        .userId(userId)
                        .build(),
                ContentDto.builder()
                        .id(2L)
                        .name("内容2")
                        .userId(userId)
                        .build()
        );

    }

}
