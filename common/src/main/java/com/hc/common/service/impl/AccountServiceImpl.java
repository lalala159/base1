package com.hc.common.service.impl;

import com.github.pagehelper.PageInfo;
import com.hc.common.dao.AccountMapper;
import com.hc.common.pojo.Account;
import com.hc.common.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mapper;
    @Override
    public PageInfo queryList(Map<String, String> map) {
        List<Account> list = mapper.queryList(map);
        double money = mapper.queryTotal(map);
        Account account = new Account();
        account.setApplyer("合计");
        account.setMoney(money);
        list.add(account);
        PageInfo<Account> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Account record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Account record) {
        return 0;
    }

    @Override
    public Account selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Account record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Account record) {
        return 0;
    }
}
