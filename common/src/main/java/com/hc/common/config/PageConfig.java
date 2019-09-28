package com.hc.common.config;

import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class PageConfig{
    private Integer pageNum;
    private Integer pageSize;
    private List<Object> list;
    private Integer total;
    private String orderBy;

    public PageConfig(Integer pageNum, Integer pageSize, String orderBy) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
        if(StringUtils.isNotEmpty(orderBy)){
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }else{
            PageHelper.startPage(pageNum, pageSize);
        }
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
