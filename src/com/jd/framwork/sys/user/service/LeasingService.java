package com.jd.framwork.sys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.framwork.sys.user.dao.LeasingDao;
import com.jd.framwork.sys.user.domain.Leasing;
import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.utils.AddLeasingTool;
import com.jd.framwork.sys.user.utils.LeasTool;
import com.jd.framwork.sys.user.utils.Page;



/**
 * 处理用户业务类
 * @author Administrator
 *
 */
@Service
public class LeasingService {
    
    @Autowired
    private  LeasingDao leasingDao;

    
    public void updateLeasing(Leasing leasing ) {
        // TODO Auto-generated method stub
        this.leasingDao.updateLeasing(leasing);
    }
    public void addLeasing(Leasing leasing,AddLeasingTool addLeasingTool) {
        // TODO Auto-generated method stub
        this.leasingDao.addLeasing(leasing,addLeasingTool);
    }
    public void deleteLeasing(int id) {
        // TODO Auto-generated method stub
        this.leasingDao.deleteLeasing(id);
    }

    public List<Leasing> queryLeasing() {
        // TODO Auto-generated method stub
        List<Leasing> leasingList=this.leasingDao.queryLeasing();
        return leasingList;
    }
    public Leasing queryLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=this.leasingDao.queryLeasingById(id);
        return leasing;
    }
    public List<Leasing> queryLeasingByPage(Page pages) {
        // TODO Auto-generated method stub
        List<Leasing> leasing=this.leasingDao.queryLeasingPage(pages);
        return leasing;
    }
    /**
     * 根据id查询要解除合同的信息
     */
    public Leasing querygLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=this.leasingDao.querygLeasingById(id);
        return leasing;
    }
    /**
     * 根据id查询要修改的续约信息
     */
    public Leasing queryftLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=this.leasingDao.queryfLeasingById(id);
        return leasing;
    }
    /**
     * 根据id查询要续约的合同信息
     */
    public Leasing querystLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=this.leasingDao.querysLeasingById(id);
        return leasing;
    }
    public void updatesLeasing(Leasing leasing ) {
        // TODO Auto-generated method stub
        this.leasingDao.updatesLeasing(leasing);
    }
    public void updatefLeasing(Leasing leasing ) {
        // TODO Auto-generated method stub
        this.leasingDao.updatefLeasing(leasing);
    }
    //完成租赁
    public void updateLeasingCom(LeasTool leasTool,Leasing leasing ) {
        // TODO Auto-generated method stub
        this.leasingDao.updateLeasingCom(leasTool,leasing);
    }
    ////根据用户姓名查询订单信息
    public Leasing queryLeasingByUserId(User user) {
        // TODO Auto-generated method stub
        Leasing leasingList=this.leasingDao.queryLeasingByUserId(user);
        return leasingList;
    }
    //客户取消订单
    public void cancelOrder(LeasTool leasTool,int id) {
        // TODO Auto-generated method stub
        this.leasingDao.cancelOrder(leasTool,id);
        System.out.println("service");
    }
}


