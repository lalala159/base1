package com.hc.common.service;

import com.github.pagehelper.PageInfo;
import com.hc.common.pojo.Notice;

import java.util.Map;

public interface NoticeService {
    int deleteByPrimaryKey(String id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    PageInfo queryList(Map<String, Object> map);
}
