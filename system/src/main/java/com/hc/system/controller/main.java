package com.hc.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pc")
public class main {

    @RequestMapping("/main")
    public ModelAndView test(){
        return new ModelAndView("indexmain");
    }
}
