package com.jd.framwork.sys.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jd.framwork.sys.user.domain.Sys_User;
import com.jd.framwork.sys.user.service.Sys_UserService;

@Controller
public class Sys_UserController {
    @Autowired
    private Sys_UserService userService;
    
    
    //登陆

    @RequestMapping(path="/syslogin",method=RequestMethod.POST)
    public String syslogin(Model model,HttpServletRequest request){
        /*if("admin".equals(user.getUsername())&&"123".equals(user.getPassword())){
            HttpSession session=request.getSession();*/
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        Sys_User user=new Sys_User();
        user.setAccount(account);
        user.setPassword(password);
        Sys_User userGet= this.userService.login(user);
        // System.out.println(userGet.getAccount());
        // System.out.println(userGet.getPassword());
        if(userGet!=null){
            //session.setAttribute("session_user", userget);
            return "redirect:home";//重定向到另一个controller
        }else{
            model.addAttribute("message","用户名或者密码不正确，请重新输入");
            return "jsp/syslogin";
        }
    }

    @RequestMapping(path="/syslogin",method=RequestMethod.GET)
    public String login(){
        return "jsp/syslogin";
    }
}
