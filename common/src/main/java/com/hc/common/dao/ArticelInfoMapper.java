package com.hc.common.dao;

import com.hc.common.pojo.ArticelInfo;
import com.hc.common.pojo.ArticelInfoWithBLOBs;

public interface ArticelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticelInfoWithBLOBs record);

    int insertSelective(ArticelInfoWithBLOBs record);

    ArticelInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticelInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticelInfoWithBLOBs record);

    int updateByPrimaryKey(ArticelInfo record);
}