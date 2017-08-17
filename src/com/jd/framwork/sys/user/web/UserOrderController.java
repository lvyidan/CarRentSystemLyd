package com.jd.framwork.sys.user.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.Leasing;
import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.service.LeasingService;
import com.jd.framwork.sys.user.utils.LeasTool;

@Controller
public class UserOrderController {
    @Autowired
    private LeasingService leasingService;
    //显示所有用户信息
    @RequestMapping("/mainorder")
    public String mainorder(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        //String method=request.getParameter("method");
        if(null==method){
            return queryLeasingByUserId(request);
        }else if("cancel".equals(method)){
            return cancelorder(request);
        }else if("querys".equals(method)){
            return querysLeasingByIdUser(request);
        }else if("mods".equals(method)){
            return modsLeasingByIdUser(request);}
        else if("backs".equals(method)){
            return backLeasingByIdUser(request);
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
    @RequestMapping("/queryLeasingByUserId")
    public String queryLeasingByUserId(HttpServletRequest request){
        //User user=this.getParam(request);
        User userGet=(User)(request.getSession().getAttribute("session_user"));
        String name=userGet.getUsername();
        System.out.println(userGet);
        User user=new User();
        user.setUsername(name);
        System.out.println(user.getUsername());
        //user.setUsername(null);
        Leasing list=this.leasingService.queryLeasingByUserId(user);
        request.setAttribute("leasing", list);
        return "orderjsp/mainorder";
    }
    @RequestMapping("/cancelorder")
    public String cancelorder(HttpServletRequest request){
        //User user=this.getParam(request);
        int id=Integer.parseInt(request.getParameter("id"));//获取订单的id
        User userGet=(User)(request.getSession().getAttribute("session_user"));
        String name=userGet.getUsername();
        System.out.println(userGet);
        User user=new User();
        user.setUsername(name);
        Leasing list=this.leasingService.queryLeasingByUserId(user);//查询订单得到车牌号
        String number=list.getNumber();//得到车牌号
        String obligateCar="空闲";
        LeasTool leasTool=new LeasTool();
        leasTool.setObligateCar(obligateCar);
        leasTool.setNumber(number);
        //user.setUsername(null);
        //取消订单
        this.leasingService.cancelOrder(leasTool,id);
        //request.setAttribute("leasing", list);
        return "orderjsp/mainorder";
    }
    /**
     * 根据id查询要续约的合同信息
     */
    @RequestMapping("/querysLeasingByIdUser")
    private String querysLeasingByIdUser(HttpServletRequest request){
        String id=request.getParameter("id");
        Leasing leasing=new Leasing();
        leasing=this.leasingService.queryLeasingById(Integer.parseInt(id));
        request.setAttribute("leasing", leasing);
        return "orderjsp/modsleasing";
    }
    /**
     * 续约合同
     */
    @RequestMapping("/modsLeasingByIdUser")
    private String modsLeasingByIdUser(HttpServletRequest request){
        Leasing leasing=new Leasing();
        String rtime=request.getParameter("rtime");
        String rtransactor=request.getParameter("rtransactor");
        String total=request.getParameter("total");
        //LeasingService leasingService=new LeasingService();
        leasing.setRtime(rtime);
        leasing.setRtransactor(rtransactor);
        leasing.setTotal(Float.parseFloat(total));
        leasing.setId(Integer.parseInt(request.getParameter("id")));
        this.leasingService.updatesLeasing(leasing);
        return "orderjsp/mainorder";
    }
    /**
     * 返还车辆，清除车辆垃圾信息，把合同状态标注为完成
     */
    private String backLeasingByIdUser(HttpServletRequest request){
        String id=request.getParameter("id");
        String obligate="完成";
        String obligateCar="空闲";
        String number=request.getParameter("number");
        Leasing leasing=new Leasing();
        //LeasingService leasingService=new LeasingService();
        leasing.setObligate(obligate);
        leasing.setId(Integer.parseInt(id));

        LeasTool leasTool=new LeasTool();
        leasTool.setObligateCar(obligateCar);
        leasTool.setNumber(number);

        System.out.println(number);
        System.out.println("车牌号"+leasTool.getNumber());
        this.leasingService.updateLeasingCom(leasTool,leasing);
        return "orderjsp/mainorder";
    }

}
