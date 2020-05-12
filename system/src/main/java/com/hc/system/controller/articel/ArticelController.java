package com.hc.system.controller.articel;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.common.pojo.ArticelInfoWithBLOBs;
import com.hc.common.pojo.Notice;
import com.hc.common.pojo.User;
import com.hc.common.service.ArticelInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HC
 * @Date 2020/5/11 15:07
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "article")
public class ArticelController {
    @Autowired
    private ArticelInfoService articelInfoService;

    @RequestMapping(value = "queryList")
    @ResponseBody
    public PageInfo<ArticelInfoWithBLOBs> queryList(Integer pageNum, Integer pageSize,
                                      String orderBy, String key) {
        if (StringUtils.isNotEmpty(orderBy)) {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        } else {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<ArticelInfoWithBLOBs> list = articelInfoService.queryList(key);
        PageInfo<ArticelInfoWithBLOBs> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public String insert(ArticelInfoWithBLOBs articelInfoWithBLOBs) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        try {
            articelInfoWithBLOBs.setUserId(user.getAccount());
            articelInfoWithBLOBs.setDataDate(new Date());
            articelInfoService.insert(articelInfoWithBLOBs);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        articelInfoService.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping(value = "edit")
    @ResponseBody
    public String edit(ArticelInfoWithBLOBs notice) {
        articelInfoService.updateByPrimaryKeySelective(notice);
        return "success";
    }
}
