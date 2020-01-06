package com.hc.common.dao;

import com.hc.common.pojo.LogsInfo;
import org.apache.ibatis.annotations.Param;

public interface LogsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogsInfo record);

    int insertSelective(LogsInfo record);

    LogsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogsInfo record);

    int updateByPrimaryKey(LogsInfo record);

    int queryByKey(@Param("ddate") String ddate);
}