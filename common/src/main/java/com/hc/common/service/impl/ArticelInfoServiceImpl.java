package com.hc.common.service.impl;

import com.hc.common.dao.ArticelInfoMapper;
import com.hc.common.pojo.ArticelInfo;
import com.hc.common.pojo.ArticelInfoWithBLOBs;
import com.hc.common.service.ArticelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author HC
 * @Date 2020/5/11 15:20
 * @Version 1.0
 */
@Service
public class ArticelInfoServiceImpl implements ArticelInfoService {

    @Autowired
    private ArticelInfoMapper articelInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articelInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ArticelInfoWithBLOBs record) {
        return articelInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ArticelInfoWithBLOBs record) {
        return articelInfoMapper.insertSelective(record);
    }

    @Override
    public ArticelInfoWithBLOBs selectByPrimaryKey(Integer id) {
        return articelInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ArticelInfoWithBLOBs record) {
        return articelInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(ArticelInfoWithBLOBs record) {
        return articelInfoMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(ArticelInfo record) {
        return articelInfoMapper.updateByPrimaryKey(record);
    }
}
