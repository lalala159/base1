package com.hc.common.service;

import com.hc.common.pojo.ArticelInfo;
import com.hc.common.pojo.ArticelInfoWithBLOBs;

/**
 * @Author HC
 * @Date 2020/5/11 15:19
 * @Version 1.0
 */
public interface ArticelInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticelInfoWithBLOBs record);

    int insertSelective(ArticelInfoWithBLOBs record);

    ArticelInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticelInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticelInfoWithBLOBs record);

    int updateByPrimaryKey(ArticelInfo record);
}
