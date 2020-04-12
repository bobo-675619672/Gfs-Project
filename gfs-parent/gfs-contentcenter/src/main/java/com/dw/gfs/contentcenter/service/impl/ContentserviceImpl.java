package com.dw.gfs.contentcenter.service.impl;

import com.dw.gfs.common.entity.dto.ContentDto;
import com.dw.gfs.contentcenter.service.ContentService;
import org.springframework.stereotype.Service;

/**
 * 内容管理实现类
 * @author liaodewen
 */
@Service
public class ContentserviceImpl implements ContentService {

    @Override
    public ContentDto queryContentDtoById(Long id) {
//        UserDto userDto = usercenterFeign.queryById(id).getData();
        return ContentDto.builder()
                .id(id)
                .name("测试用户")
//                .userId(userDto.getId())
//                .userName(userDto.getName())
                .build();
    }

}
