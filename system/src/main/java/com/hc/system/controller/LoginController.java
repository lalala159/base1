package com.hc.system.controller;

import com.hc.common.config.ResposeEntity;
import com.hc.common.pojo.LogsInfo;
import com.hc.common.pojo.User;
import com.hc.common.service.LogsInfoService;
import com.hc.common.service.UserService;
import com.hc.system.util.CusAccessObjectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("sys")
public class LoginController {
    @Autowired
    private UserService service;

    @Autowired
    private LogsInfoService logsInfoService;


    @RequestMapping(value = "login")
    public ModelAndView toLogin(HttpServletRequest request, @RequestParam(value = "username", required = true, defaultValue = "") String username,
                                @RequestParam(value = "password", required = true, defaultValue = "") String password,
                                @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe) {
        ModelAndView model = new ModelAndView();
        if (username.isEmpty()) {
            model.setViewName("login");

            return model;
        }
        try {
            Subject subject = SecurityUtils.getSubject();
            String md5Pwd = new Md5Hash(password, username, 2).toString();
            UsernamePasswordToken token = new UsernamePasswordToken(username, md5Pwd);
            token.setRememberMe(rememberMe);
            subject.login(token);
        } catch (DisabledAccountException e) {
            model.setViewName("login");
            model.addObject("error", e.getMessage());
            return model;
        } catch (AuthenticationException e) {
            model.addObject("error", "用户或密码错误");
            model.setViewName("login");
            return model;
        } catch (NullPointerException n) {
            model.setViewName("login");
            model.addObject("error", "空指针");
            return model;
        }
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("user");
        String ip = CusAccessObjectUtil.getIpAddress(request);
        String nickname = user.getNickname();
        LogsInfo logsInfo = new LogsInfo();
        logsInfo.setDdate(new Date());
        logsInfo.setIp(ip);
        logsInfo.setModule("登录");
        logsInfo.setOp("登录");
        logsInfo.setUsername(user.getNickname());
        logsInfoService.insertSelective(logsInfo);
        model.addObject("nickname", nickname);
        model.setViewName("publicHtml/main");
        return model;
    }

    @RequestMapping("goUser")
    public String getUSer() {
        return "publicHtml/main";
    }

    @RequestMapping(value = "queryList")
    @ResponseBody
    public ResposeEntity queryList(Integer pageNum, Integer pageSize,
                                   String orderBy, String key) {
        return service.queryList(pageNum, pageSize, orderBy, key);
    }


}
