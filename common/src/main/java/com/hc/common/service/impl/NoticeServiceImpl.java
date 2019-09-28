package com.hc.common.service.impl;

import com.github.pagehelper.PageInfo;
import com.hc.common.dao.NoticeMapper;
import com.hc.common.pojo.Notice;
import com.hc.common.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper mapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Notice record) {
        return 0;
    }

    @Override
    public Notice selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return 0;
    }

    public PageInfo<Notice> queryList(Map<String, Object> map) {
        List<Notice> list = mapper.queryList(map);
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
