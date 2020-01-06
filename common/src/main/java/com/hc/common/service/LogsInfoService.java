package com.hc.common.service;

import com.hc.common.pojo.LogsInfo;

public interface LogsInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(LogsInfo record);

    int insertSelective(LogsInfo record);

    LogsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogsInfo record);

    int updateByPrimaryKey(LogsInfo record);

    int queryByKey(String ddate);
}
