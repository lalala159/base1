package com.hc.common.dao;

import com.hc.common.pojo.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> queryList(Map<String, Object> map);
}