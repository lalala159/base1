package com.hc.system.controller.user;

import com.hc.common.pojo.User;
import com.hc.common.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "editStatus")
    @ResponseBody
    public String editSatus(Byte status, Integer id) {
        User user = new User();
        user.setStatus(status);
        user.setId(id);
        service.updateByPrimaryKey(user);
        return "success";
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(Integer id) {
        service.deleteByPrimaryKey(id);
        return "success";
    }

    @RequestMapping(value = "edit")
    @ResponseBody
    public String edit(User user, String oldpassword, Integer type) {
        User obj = service.selectbyname(user.getAccount());
        if(obj != null){
            if(type == 0){
                service.updateByPrimaryKeySelective(user);
            }else{
                String md5Pwd = new Md5Hash(oldpassword, user.getAccount(), 2).toString();
                if(md5Pwd.equals(obj.getPassword())){
                    user.setPassword(md5Pwd);
                    service.updateByPrimaryKeySelective(user);
                }else{
                    return "errorPWD";
                }
            }
        }
        return "success";
    }

    @RequestMapping(value = "insert")
    @ResponseBody
    public String insert(User user) {
        try {
            user.setUuid(UUID.randomUUID().toString());
            String md5Pwd = new Md5Hash(user.getPassword(), user.getAccount(), 2).toString();
            user.setPassword(md5Pwd);
            user.setStatus(Byte.parseByte("0"));
            user.setDeletestatus(Byte.parseByte("1"));
            int flag = service.insert(user);
            System.out.println(flag);
        }catch (RuntimeException e){
            return "unique";
        }
        return "success";
    }
    @RequestMapping(value = "editUser")
    @ResponseBody
    public String editUser(User user,String oldpassword) {
        try {
            if(StringUtils.isNotEmpty(user.getPassword())){
                String md5Pwd = new Md5Hash(user.getPassword(), user.getAccount(), 2).toString();
                user.setPassword(md5Pwd);
            }
            user.setStatus(Byte.parseByte("0"));
            user.setDeletestatus(Byte.parseByte("1"));
            service.updateByPrimaryKey(user);
        }catch (RuntimeException e){
            return "unique";
        }
        return "success";
    }

}
