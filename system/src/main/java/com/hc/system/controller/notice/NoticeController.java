package com.hc.system.controller.notice;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.common.pojo.Notice;
import com.hc.common.pojo.User;
import com.hc.common.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping(value = "notice")
@Controller
public class NoticeController {
    @Autowired
    private NoticeService service;

    @RequestMapping(value = "queryList")
    @ResponseBody
    public PageInfo<Notice> queryList(Integer pageNum, Integer pageSize,
                                      String orderBy, String key) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("key", key);
        if (StringUtils.isNotEmpty(orderBy)) {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        } else {
            PageHelper.startPage(pageNum, pageSize);
        }
        return service.queryList(map);
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public String insert(Notice notice) {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        try {
            notice.setId(UUID.randomUUID().toString());
            notice.setUserId(user.getAccount());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            notice.setSendDate(sdf.format(new Date()));
            service.insert(notice);
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(String id) {
        service.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping(value = "edit")
    @ResponseBody
    public String edit(Notice notice) {
        service.updateByPrimaryKeySelective(notice);
        return "success";
    }
}
