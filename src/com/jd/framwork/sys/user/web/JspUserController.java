package com.jd.framwork.sys.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspUserController {

    @RequestMapping(path="/leftUser",method=RequestMethod.GET)
    public String login2(){
        return "jsp/leftUser";
    }
    @RequestMapping(path="/register",method=RequestMethod.GET)
    public String login11(){
        return "orderjsp/adduser";
    }
}
