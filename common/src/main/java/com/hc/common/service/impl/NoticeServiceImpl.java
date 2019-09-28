package com.hc.common.service.impl;

import com.hc.common.dao.NoticeMapper;
import com.hc.common.pojo.Notice;
import com.hc.common.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper mapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Notice record) {
        return 0;
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
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return 0;
    }
}
