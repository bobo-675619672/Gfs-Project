package com.dw.gfs.contentcenter.service;

import com.dw.gfs.contentcenter.entity.dto.ContentDto;

import java.util.List;

/**
 * 内容管理接口类
 *
 * @author liaodewen
 */
public interface ContentService {

    List<ContentDto> queryByUserId(Long userId);

}
