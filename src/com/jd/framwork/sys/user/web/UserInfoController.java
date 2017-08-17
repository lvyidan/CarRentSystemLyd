package com.jd.framwork.sys.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.service.UserService;

@Controller
public class UserInfoController {
    @Autowired
    private UserService userService;
    //显示所有用户信息
    @RequestMapping("/userinfo")
    public String userinfo(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        //String method=request.getParameter("method");
        if(null==method){
            return queryUserBase(request);
        }else if("query".equals(method)){
            return queryUserByName(request);
        }
        else if("mod".equals(method)){
            return modUser(request);
        }
        return null;
    }
    /*//得到参数
    @RequestMapping("/getParam")
    public User getParam(HttpServletRequest request){
        //System.err.println("queryLeasing");
        String username=request.getParameter("username");
        User user=new User();
        user.setUsername(username);
        System.out.println("getparam");
        return user;
    }*/
    //查询用户信息
    @RequestMapping("/queryUserBase")
    public String queryUserBase(HttpServletRequest request){
        //User user=this.getParam(request);
        User userGet=(User)(request.getSession().getAttribute("session_user"));
        String name=userGet.getUsername();
        //System.out.println(userGet);
        //User user=new User();
        //user.setUsername(name);
        //System.out.println(name);
        //String username=request.getParameter("username");
        //user.setUsername(null);
        User user=this.userService.queryUserByName(name);
        System.out.println("yonhu查到了"+user.getUsername());
        request.setAttribute("user", user);
        return "orderjsp/orderUserInfo";
    }
    
    //查询用户信息
    @RequestMapping("/queryUserByName")
    public String queryUserByName(HttpServletRequest request){
        //User user=this.getParam(request);
        //User userGet=(User)(request.getSession().getAttribute("session_user"));
        //String name=userGet.getUsername();
        //System.out.println(userGet);
        //User user=new User();
        //user.setUsername(name);
        //System.out.println(name);
        String username=request.getParameter("name");
        //user.setUsername(null);
        User user=this.userService.queryUserByName(username);
        System.out.println("查到了,要修改的"+user.getUsername());
        request.setAttribute("user", user);
        return "orderjsp/moduser";
    }
    
    @RequestMapping("/modUser")
    public String modUser(HttpServletRequest request){
        User user=new User();
        String username=request.getParameter("username");
        String phone=request.getParameter("phone");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String idnum=request.getParameter("idnum");
        String address=request.getParameter("address");
        String password=request.getParameter("password");
        String note=request.getParameter("note");

        user.setUsername(username);
        user.setPhone(phone);
        user.setSex(sex);
        user.setAge(age);
        user.setIdnum(idnum);
        user.setAddress(address);
        user.setPassword(password);
        user.setNote(note);
        user.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(user.getId());
        //userService.modUser(user);
        this.userService.updateUser(user);
        return "orderjsp/orderUserInfo";
    }
}
