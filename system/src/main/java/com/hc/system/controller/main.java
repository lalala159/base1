package com.hc.system.controller;

import com.hc.common.service.LogsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("pc")
@Api(tags = "全景展示")
public class main {
    @Autowired
    private LogsInfoService logsInfoService;


    @GetMapping("/main")
    public ModelAndView test(){
        return new ModelAndView("indexmain");
    }


    @GetMapping("/qjzs")
    @ResponseBody
    @ApiOperation(value="日志浏览")
    public Map<String, Object> qjzs(){
       Map<String, Object> map = new HashMap<>(4);
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String ddate = sdf.format(new Date());
       int lls = logsInfoService.queryByKey(ddate);
       int zls = logsInfoService.queryByKey(null);
       map.put("lls", lls);
       map.put("zls", zls);
       return map;
    }
}
