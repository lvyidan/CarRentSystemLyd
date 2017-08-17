package com.jd.framwork.sys.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.Renter;
import com.jd.framwork.sys.user.service.RenterService;
import com.jd.framwork.sys.user.utils.Page;
import com.jd.framwork.sys.user.utils.PageBean;

@Controller
public class RenterController {
    @Autowired
    private RenterService renterService;
    //显示所有用户信息
    @RequestMapping("/mainrenter")
    public String mainrenter(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        if(null==method){
            return queryRenter(request);
        }else if("add".equals(method)){
            return addRenter(request);
        }else if("mod".equals(method)){
            return updateRenter(request);
        }else if("query".equals(method)){
            return queryRenterById(request,model);
        }else if("del".equals(method)){
            return deleteRenter(request);
        }
        return null;
    }
    //查询用户信息
    @RequestMapping("/queryRenter")
    public String queryRenter(HttpServletRequest request){
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
        System.err.println(start);
        System.err.println(end);
        Page pages = new Page(start,end);
        //pages.setStart(start);
        //pages.setEnd(end);
        //Map<String,Page> map = new HashMap<String, Page>();
        //map.put("pages", pages);
        System.out.println(pages.getEnd());
        List<Renter> list=this.renterService.queryRenterByPage(pages);
        List<Renter> listAll=this.renterService.queryRenter();
        PageBean pageBean = new PageBean();
        pageBean.setList(list);
        int count =listAll.size();
        int total = count % pageSize == 0 ? (count / pageSize): (count / pageSize + 1);
        if (total <= 0){
            total = 0;
        }
        System.out.println(total);
        pageBean.setTotal(total);
        pageBean.setPageSize(pageSize);
        pageBean.setPage(page);
        
        System.out.println(pageSize);
        System.out.println(page);
        //model.put("list", list);
        //model.put("pageBean", pageBean);
        request.setAttribute("pageBean", pageBean);
        return "renterjsp/mainrenter";
    }

    //更新用户信息
    @RequestMapping("/updateRenter")
    public String updateRenter(HttpServletRequest request){
        Renter renter=new Renter();
        String rentername=request.getParameter("rentername");
        String idnum=request.getParameter("idnum");
        String phone=request.getParameter("phone");
        String drivenum=request.getParameter("drivenum");
        String address=request.getParameter("address");
        String workunit=request.getParameter("workunit");
        String note=request.getParameter("note");
        
        renter.setRentername(rentername);
        renter.setIdnum(idnum);
        renter.setPhone(phone);
        renter.setDrivenum(drivenum);
        renter.setAddress(address);
        renter.setWorkunit(workunit);
        renter.setNote(note);
        renter.setId(Integer.parseInt(request.getParameter("id")));
        this.renterService.updateRenter(renter);
        return "renterjsp/mainrenter";
    }
    //删除用户信息
    @RequestMapping("/deleteRenter")
    public String deleteRenter(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //user.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(id);
        this.renterService.deleteRenter(id);
        System.out.println("hhhhh");
        return "renterjsp/mainrenter";
    }
    //根据id查询用户信息
    @RequestMapping("/queryRenterById")
    public String queryRenterById(HttpServletRequest request,Map<String,Object> model){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println(id);
        System.out.println(id);
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Renter renter=this.renterService.queryRenterById(id);

        request.setAttribute("renter", renter);
        //model.put("user", user);
        return "renterjsp/modrenter";
    }
    //添加用户
    @RequestMapping("/addRenter")
    public String addRenter(HttpServletRequest request){
        Renter renter=new Renter();
        String rentername=request.getParameter("rentername");
        String idnum=request.getParameter("idnum");
        String phone=request.getParameter("phone");
        String drivenum=request.getParameter("drivenum");
        String address=request.getParameter("address");
        String workunit=request.getParameter("workunit");
        String note=request.getParameter("note");
        renter.setRentername(rentername);
        renter.setIdnum(idnum);
        renter.setPhone(phone);
        renter.setDrivenum(drivenum);
        renter.setAddress(address);
        renter.setWorkunit(workunit);
        renter.setNote(note);

        this.renterService.addRenter(renter);
        return "renterjsp/mainrenter";
    }



}
