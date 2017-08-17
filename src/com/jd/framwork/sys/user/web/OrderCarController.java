package com.jd.framwork.sys.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.Car;
import com.jd.framwork.sys.user.domain.Leasing;
import com.jd.framwork.sys.user.service.CarService;
import com.jd.framwork.sys.user.service.LeasingService;
import com.jd.framwork.sys.user.utils.AddLeasingTool;
import com.jd.framwork.sys.user.utils.Page;
import com.jd.framwork.sys.user.utils.PageBean;

@Controller
public class OrderCarController {
    @Autowired
    private CarService carService;
    @Autowired
    private LeasingService leasingService;
    //显示所有用户信息
    @RequestMapping("/ordercar")
    public String ordercar(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        if(null==method){
            return queryCarUser(request);
        }else if("query".equals(method)){
            return queryCarByIdUser(request);
        }
        else if("order".equals(method)){
            return orderCar(request);
        }

        return null;
    }
    //查询用户信息
    @RequestMapping("/queryCarUser")
    public String queryCarUser(HttpServletRequest request){
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
        List<Car> list=this.carService.queryCarByPage(pages);
        List<Car> listAll=this.carService.queryCar();
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
        return "orderjsp/maincar";
    }
    @RequestMapping("/queryCarByIdUser")
    public String queryCarByIdUser(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println(id);
        //System.out.println(id);
        //System.out.println(id);
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Car car=this.carService.queryCarById(id);
        System.out.println("查询车辆");
        request.setAttribute("car", car);
        //model.put("user", user);
        return "orderjsp/addleasing";
    }
    //添加用户
    @RequestMapping("/orderCar")
    public String orderCar(HttpServletRequest request){
        Leasing leasing=new Leasing();
        String number=request.getParameter("number");
        String price=request.getParameter("price");
        String rentername=request.getParameter("rentername");
        String usetime=request.getParameter("usetime");
        String pledge=request.getParameter("pledge");
        String starttime=request.getParameter("starttime");
        String transactor=request.getParameter("transactor");
        String backtime=request.getParameter("backtime");
        String total=request.getParameter("total");
        String note=request.getParameter("note");
        String obligate="进行中";
        String obligateCar="出行";

        leasing.setNumber(number);
        leasing.setPrice(Float.parseFloat(price));
        leasing.setRentername(rentername);
        leasing.setUsetime(usetime);
        leasing.setPledge(Float.parseFloat(pledge));
        leasing.setStarttime(starttime);
        leasing.setTransactor(transactor);
        leasing.setBacktime(backtime);
        leasing.setTotal(Float.parseFloat(total));
        leasing.setNote(note);
        leasing.setObligate(obligate);
        
        AddLeasingTool addLeasingTool=new AddLeasingTool();
        addLeasingTool.setLeasing(leasing);
        addLeasingTool.setObligateCar(obligateCar);

        this.leasingService.addLeasing(leasing,addLeasingTool);
        return "orderjsp/mainorder";
    }
}
