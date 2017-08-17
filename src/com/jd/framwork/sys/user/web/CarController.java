package com.jd.framwork.sys.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.Car;
import com.jd.framwork.sys.user.service.CarService;
import com.jd.framwork.sys.user.utils.AddCarTool;
import com.jd.framwork.sys.user.utils.Page;
import com.jd.framwork.sys.user.utils.PageBean;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    //显示所有用户信息
    @RequestMapping("/maincar")
    public String maincar(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        if(null==method){
            return queryCar(request);
        }else if("add".equals(method)){
            return addCar(request);
        }else if("mod".equals(method)){
            return updateCar(request);
        }else if("query".equals(method)){
            return queryCarById(request,model);
        }else if("del".equals(method)){
            return deleteCar(request);
        }
        return null;
    }
    //查询用户信息
    @RequestMapping("/queryCar")
    public String queryCar(HttpServletRequest request){
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
        return "carjsp/maincar";
    }
    
    //更新用户信息
    @RequestMapping("/updateCar")
    public String updateCar(HttpServletRequest request){
        Car car=new Car();
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String number=request.getParameter("number");
        String price=request.getParameter("price");
        String safetype=request.getParameter("safetype");

        car.setName(name);
        car.setType(type);
        car.setNumber(number);
        car.setPrice(Float.parseFloat(price));
        car.setSafetype(safetype);
        car.setId(Integer.parseInt(request.getParameter("id")));
        this.carService.updateCar(car);
        return "carjsp/maincar";
    }
    //删除用户信息
    @RequestMapping("/deleteCar")
    public String deleteCar(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //user.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(id);
        this.carService.deleteCar(id);
        System.out.println("hhhhh");
        return "carjsp/maincar";
    }
    //根据id查询用户信息
    @RequestMapping("/queryCarById")
    public String queryCarById(HttpServletRequest request,Map<String,Object> model){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        System.out.println(id);
        System.out.println(id);
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Car car=this.carService.queryCarById(id);
        System.out.println(car);
        request.setAttribute("car", car);
        //model.put("user", user);
        return "carjsp/modcar";
    }
    //添加用户
    @RequestMapping("/addCar")
    public String addCar(HttpServletRequest request){
        Car car=new Car();
        AddCarTool addCarTool=new AddCarTool();
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String number=request.getParameter("number");
        String price=request.getParameter("price");
        String safetype=request.getParameter("safetype");
        String obligate="空闲";
        car.setName(name);
        car.setType(type);
        car.setNumber(number);
        car.setPrice(Float.parseFloat(price));
        car.setSafetype(safetype);
        
        addCarTool.setCar(car);
        addCarTool.setObligate(obligate);
        this.carService.addCar(addCarTool);
        return "carjsp/maincar";
    }
    
    
    
}
