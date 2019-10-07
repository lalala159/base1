package com.hc.common.service;

import com.github.pagehelper.PageInfo;
import com.hc.common.pojo.Account;

import java.util.Map;

public interface AccountService {
    PageInfo queryList(Map<String, String> map);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
