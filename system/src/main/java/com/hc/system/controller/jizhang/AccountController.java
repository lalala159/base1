package com.hc.system.controller.jizhang;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hc.common.pojo.Account;
import com.hc.common.pojo.User;
import com.hc.common.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "jizhang")
@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping(value = "queryList")
    @ResponseBody
    public PageInfo<Account> queryList(Integer pageNum, Integer pageSize,
                                       String orderBy, String key, String status) {
        Map<String, String> map = new HashMap<>(16);
        map.put("key", key);
        map.put("status", status);
        if (StringUtils.isNotEmpty(orderBy)) {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        } else {
            PageHelper.startPage(pageNum, pageSize);
        }
        return service.queryList(map);
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public String insert(Account account) {
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        try {
            account.setApplyer(user.getId().toString());
            account.setStatus("1");
            int flag = service.insert(account);
            System.out.println(flag);
        }catch (Exception e){
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "edit")
    @ResponseBody
    public String edit(Account account) {
        User user= (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        account.setShman(user.getId().toString());
        service.updateByPrimaryKeySelective(account);
        return "success";
    }
}
