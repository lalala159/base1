package com.hc.common.dao;

import com.hc.common.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("SELECT * FROM f_user")
    List<User> getList();

    User selectbyname(String usernmame);

    List<User> queryList(String key);

    int queryTotal(String key);
}