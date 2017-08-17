package com.jd.framwork.sys.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspController {
    @RequestMapping(path="/homepage",method=RequestMethod.GET)
    public String login1(){
        return "jsp/homepage";
    }
    @RequestMapping(path="/left",method=RequestMethod.GET)
    public String login2(){
        return "jsp/left";
    }
    @RequestMapping(path="/headpage",method=RequestMethod.GET)
    public String login3(){
        return "jsp/headpage";
    }
}
