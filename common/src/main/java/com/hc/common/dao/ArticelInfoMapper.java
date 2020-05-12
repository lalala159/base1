package com.hc.common.dao;

import com.hc.common.pojo.ArticelInfo;
import com.hc.common.pojo.ArticelInfoWithBLOBs;

import java.util.List;

public interface ArticelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticelInfoWithBLOBs record);

    int insertSelective(ArticelInfoWithBLOBs record);

    ArticelInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticelInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticelInfoWithBLOBs record);

    int updateByPrimaryKey(ArticelInfo record);

    List<ArticelInfoWithBLOBs> queryList(String present);
}