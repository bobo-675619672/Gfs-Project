package com.dw.gfs.contentcenter.service;

import com.dw.gfs.common.entity.dto.ContentDto;

/**
 * 内容管理接口类
 * @author liaodewen
 */
public interface ContentService {

    ContentDto queryContentDtoById(Long id);

}
