package com.hc.common.dao;

import com.hc.common.pojo.Account;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> queryList(Map<String, String> map);

    double queryTotal(Map<String, String> map);
}