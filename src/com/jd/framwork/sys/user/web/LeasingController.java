package com.jd.framwork.sys.user.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.framwork.sys.user.domain.Leasing;
import com.jd.framwork.sys.user.service.LeasingService;
import com.jd.framwork.sys.user.utils.AddLeasingTool;
import com.jd.framwork.sys.user.utils.LeasTool;
import com.jd.framwork.sys.user.utils.Page;
import com.jd.framwork.sys.user.utils.PageBean;

@Controller
public class LeasingController {
    @Autowired
    private LeasingService leasingService;
    //显示所有用户信息
    @RequestMapping("/mainleasing")
    public String mainleasing(HttpServletRequest request,Map<String,Object> model){
        //String username=request.getParameter("username");
        String method=request.getParameter("method");
        if(null==method){
            return queryLeasing(request);
        }else if("add".equals(method)){
            return addLeasing(request);
        }else if("mod".equals(method)){
            return updateLeasing(request);
        }else if("del".equals(method)){
            return deleteLeasing(request);
        }else if("query".equals(method)){
            return queryLeasingById(request);
        }else if("querys".equals(method)){
            return querysLeasingById(request);
        }else if("mods".equals(method)){
            return modsLeasingById(request);
        }else if("queryt".equals(method)){
            return querytLeasingById(request);
        }else if("queryf".equals(method)){
            return queryfLeasingById(request);
        }else if("modf".equals(method)){
            return modfLeasingById(request);
        }else if("queryg".equals(method)){
            return querygLeasingById(request);
        }else if("backs".equals(method)){
            return backLeasingById(request);
        }
        return null;
    }
    //查询用户信息
    @RequestMapping("/queryLeasing")
    public String queryLeasing(HttpServletRequest request){
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
        List<Leasing> list=this.leasingService.queryLeasingByPage(pages);
        List<Leasing> listAll=this.leasingService.queryLeasing();
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
        System.err.println("queryLeasing");
        request.setAttribute("pageBean", pageBean);
        return "leasingjsp/mainleasing";
    }

    //更新用户信息
    @RequestMapping("/updateLeasing")
    public String updateLeasing(HttpServletRequest request){
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
        leasing.setId(Integer.parseInt(request.getParameter("id")));
        this.leasingService.updateLeasing(leasing);
        return "leasingjsp/mainleasing";
    }
    //删除用户信息
    @RequestMapping("/deleteLeasing")
    public String deleteLeasing(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //user.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(id);
        this.leasingService.deleteLeasing(id);
        System.out.println("hhhhh");
        return "leasingjsp/mainleasing";
    }
    //根据id查询用户信息
    @RequestMapping("/queryLeasingById")
    public String queryLeasingById(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("queryLeasingById");
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Leasing leasing=this.leasingService.queryLeasingById(id);
        System.out.println(leasing);
        request.setAttribute("leasing", leasing);
        //model.put("user", user);
        return "leasingjsp/modleasing";
    }
    //根据id显示合同详细信息
    @RequestMapping("/querytLeasingById")
    public String querytLeasingById(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println("hahahah");
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Leasing leasing=this.leasingService.queryLeasingById(id);
        System.out.println("querytLeasingById");
        //System.out.println(leasing.getNumber());
        System.out.println(leasing.getRenewal());
        request.setAttribute("leasing", leasing);
        //model.put("user", user);
        return "leasingjsp/showleasing";
    }
    /**
     * 根据id查询要修改的续约信息
     */
    @RequestMapping("/queryfLeasingById")
    public String queryfLeasingById(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println("hahahah");
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Leasing leasing=this.leasingService.queryLeasingById(id);
        System.out.println(leasing);
        request.setAttribute("leasing", leasing);
        //model.put("user", user);
        return "leasingjsp/modfleasing";
    }
    /**
     * 根据id查询要解除合同的信息
     */
    @RequestMapping("/querygLeasingById")
    public String querygLeasingById(HttpServletRequest request){
        //User user=new User();
        int id=Integer.parseInt(request.getParameter("id"));
        //System.out.println("hahahah");
        //user.setId(Integer.parseInt(request.getParameter("id")));
        Leasing leasing=this.leasingService.queryLeasingById(id);
        System.out.println(leasing);
        request.setAttribute("leasing", leasing);
        //model.put("user", user);
        return "leasingjsp/backleasing";
    }
    /**
     * 根据id查询要续约的合同信息
     */
    @RequestMapping("/querysLeasingById")
    private String querysLeasingById(HttpServletRequest request){
        String id=request.getParameter("id");
        Leasing leasing=new Leasing();
        leasing=this.leasingService.queryLeasingById(Integer.parseInt(id));
        request.setAttribute("leasing", leasing);
        return "leasingjsp/modsleasing";
    }
    /**
     * 续约合同
     */
    @RequestMapping("/modsLeasingById")
    private String modsLeasingById(HttpServletRequest request){
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
        return "leasingjsp/mainleasing";
    }
    /**
     * 修改续约合同信息
     */
    @RequestMapping("/modfLeasingById")
    private String modfLeasingById(HttpServletRequest request){
        Leasing leasing=new Leasing();
        String rtime=request.getParameter("rtime");
        String rtransactor=request.getParameter("rtransactor");
        String total=request.getParameter("total");
        //LeasingService leasingService=new LeasingService();
        leasing.setRtime(rtime);
        leasing.setRtransactor(rtransactor);
        leasing.setTotal(Float.parseFloat(total));
        this.leasingService.updatefLeasing(leasing);
        return "leasingjsp/mainleasing";
    }
    //添加用户
    @RequestMapping("/addLeasing")
    public String addLeasing(HttpServletRequest request){
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
        return "leasingjsp/mainleasing";
    }
    /**
     * 返还车辆，清除车辆垃圾信息，把合同状态标注为完成
     */
    private String backLeasingById(HttpServletRequest request){
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
        return "leasingjsp/mainleasing";
    }
    
}
