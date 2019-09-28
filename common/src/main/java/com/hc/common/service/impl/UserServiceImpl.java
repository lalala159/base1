package com.hc.common.service.impl;

import com.github.pagehelper.PageHelper;
import com.hc.common.config.ResposeEntity;
import com.hc.common.dao.UserMapper;
import com.hc.common.pojo.User;
import com.hc.common.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
/*@CacheConfig(cacheNames = "users")*/
public class UserServiceImpl implements UserService {
    //这里的单引号不能少，否则会报错，被识别是一个对象
    public static final String THING_ALL_KEY = "\"user\"";
    private static final String DEMO_CACHE_NAME = "users";


    @Autowired
    private UserMapper dao;

    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return dao.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = "#id")
    public User selectByPrimaryKey(Integer id) {
        User user = dao.selectByPrimaryKey(id);
        System.out.println("为id、key为:" + user.getId() + "数据做了缓存");
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public List<User> getList() {
        return dao.getList();
    }

    @Cacheable(value = DEMO_CACHE_NAME, key = "'user_'+#username")
    public User selectbyname(String username) {
        return dao.selectbyname(username);
    }

    public ResposeEntity queryList(Integer pageNum,Integer pageSize,
                                   String orderBy, String key) {
        Integer total = dao.queryTotal(key);
        if(StringUtils.isNotEmpty(orderBy)){
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }else{
            PageHelper.startPage(pageNum, pageSize);
        }
        List<User> list = dao.queryList(key);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", total);
        return ResposeEntity.success(map);
    }
}
