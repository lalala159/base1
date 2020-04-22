package com.hc.common.dao;

import com.hc.common.pojo.LogsInfo;
import com.hc.common.pojo.Notice;
import com.hc.common.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogsInfo record);

    int insertSelective(LogsInfo record);

    LogsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogsInfo record);

    int updateByPrimaryKey(LogsInfo record);

    int queryByKey(@Param("ddate") String ddate);

    int queryUsers();

    List<Notice> getNotice();

    List<User> getUsers();
}