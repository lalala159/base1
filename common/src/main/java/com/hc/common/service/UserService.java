package com.hc.common.service;

import com.hc.common.config.ResposeEntity;
import com.hc.common.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public List<User> getList();
    public User selectbyname(String username);

    ResposeEntity queryList(Integer pageNum,Integer pageSize,
                            String orderBy, String key);


}
