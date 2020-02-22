package com.hc.common.service;

import com.hc.common.pojo.LogsInfo;
import com.hc.common.pojo.Notice;
import com.hc.common.pojo.User;

import java.util.List;

public interface LogsInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(LogsInfo record);

    int insertSelective(LogsInfo record);

    LogsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogsInfo record);

    int updateByPrimaryKey(LogsInfo record);

    int queryByKey(String ddate);

    int queryUsers();

    List<Notice> getNotice();

    List<User> getUsers();
}
