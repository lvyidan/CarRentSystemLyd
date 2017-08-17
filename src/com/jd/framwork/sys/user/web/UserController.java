package com.jd.framwork.sys.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.service.UserService;
import com.jd.framwork.sys.user.utils.Page;
import com.jd.framwork.sys.user.utils.PageBean;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    //显示所有用户信息
    @RequestMapping("/mainuser")
    public String mainuser(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        if(null==method){
            return queryUser(request);
        }else if("add".equals(method)){
            return addUser(request);
        }else if("mod".equals(method)){
            return updateUser(request);
        }else if("query".equals(method)){
            return queryUserById(request,model);
        }else if("del".equals(method)){
            return deleteUser(request);
        }
        return null;
    }
    //查询用户信息
    @RequestMapping("/queryUser")
    public String queryUser(HttpServletRequest request){
        //PageBean pageBean=new PageBean();
        int page = 1;// 默认显示第几页
        int pageSize = 4;// 默认一页记录显示的记录数
        if (null != request.getParameter("pg")) {
            page = Integer.parseInt(request.getParameter("pg"));
        }
        if (null != request.getParameter("pgno")) {
            pageSize = Integer.parseInt(request.getParameter("pgno"));
        }

        int start=(page-1)*pageSize;
        int end=page*pageSize;
        //System.err.println(start);
        //System.err.println(end);
        Page pages = new Page(start,end);
        //pages.setStart(start);
        //pages.setEnd(end);
        //Map<String,Page> map = new HashMap<String, Page>();
        //map.put("pages", pages);
        //System.out.println(pages.getEnd());
        List<User> list=this.userService.queryUserByPage(pages);
        List<User> listAll=this.userService.queryUser();
        PageBean pageBean = new PageBean();
        pageBean.setList(list);
        int count =listAll.size();
        System.err.println(count);
        int total = count % pageSize == 0 ? (count / pageSize): (count / pageSize + 1);
        if (total <= 0){
            total = 0;
        }
        System.out.println(total);
        pageBean.setTotal(total);
        pageBean.setPageSize(pageSize);
        pageBean.setPage(page);

        // System.out.println(pageSize);
        // System.out.println(page);
        //model.put("list", list);
        //model.put("pageBean", pageBean);
        request.setAttribute("pageBean", pageBean);
        return "userjsp/mainuser";
    }
    //登陆
    @RequestMapping(path="/login",method=RequestMethod.POST)
    public String login(Model model,HttpServletRequest request){
        /*if("admin".equals(user.getUsername())&&"123".equals(user.getPassword())){
         */
        HttpSession session=request.getSession();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        User userGet= this.userService.login(user);
        if(userGet!=null){
            session.setAttribute("session_user", userGet);
            // request.setAttribute("user", userGet);
            return "jsp/indexUser";//重定向到另一个controller
        }else{
            model.addAttribute("message","用户名或者密码不正确，请重新输入,"
                    + "如果您没有账号，请注册后登陆");
            return "jsp/login";
        }
    }

    @RequestMapping(path="/login",method=RequestMethod.GET)
    public String login(){
        return "jsp/login";
    }
    //注册
    @RequestMapping("/register")
    public String register(){
        return "adduser";
    }
    //用户注册
    @RequestMapping("/registerUser")
    public String registerUser(HttpServletRequest request){
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
        this.userService.addUser(user);
        return "orderjsp/registeruser";
    }

    //更新用户信息
    @RequestMapping("/updateUser")
    public String updateUser(HttpServletRequest request){
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
        return "userjsp/mainuser";
    }
    //删除用户信息
    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //user.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(id);
        this.userService.deleteUser(id);
        System.out.println("hhhhh");
        return "userjsp/mainuser";
    }
    //根据id查询用户信息
    @RequestMapping("/queryUserById")
    public String queryUserById(HttpServletRequest request,Map<String,Object> model){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println(id);
        System.out.println(id);
        //user.setId(Integer.parseInt(request.getParameter("id")));
        User user=this.userService.queryUserById(id);
        System.out.println(user);
        request.setAttribute("user", user);
        //model.put("user", user);
        return "userjsp/moduser";
    }
    //添加用户
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request){
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
        this.userService.addUser(user);
        return "userjsp/mainuser";
    }



}
