package com.hc.common.service.impl;

import com.hc.common.dao.LogsInfoMapper;
import com.hc.common.pojo.LogsInfo;
import com.hc.common.pojo.Notice;
import com.hc.common.pojo.User;
import com.hc.common.service.LogsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsInfoServiceImpl implements LogsInfoService {
    @Autowired
    private LogsInfoMapper logsInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return logsInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LogsInfo record) {
        return logsInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(LogsInfo record) {
        return logsInfoMapper.insertSelective(record);
    }

    @Override
    public LogsInfo selectByPrimaryKey(Integer id) {
        return logsInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LogsInfo record) {
        return logsInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LogsInfo record) {
        return logsInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int queryByKey(String ddate) {
        return logsInfoMapper.queryByKey(ddate);
    }

    @Override
    public int queryUsers() {
        return logsInfoMapper.queryUsers();
    }

    @Override
    public List<Notice> getNotice() {
        return logsInfoMapper.getNotice();
    }

    @Override
    public List<User> getUsers() {
        return logsInfoMapper.getUsers();
    }
}
