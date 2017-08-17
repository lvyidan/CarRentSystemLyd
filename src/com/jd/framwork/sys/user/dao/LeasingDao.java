package com.jd.framwork.sys.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.framwork.sys.user.domain.Leasing;
import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.utils.AddLeasingTool;
import com.jd.framwork.sys.user.utils.LeasTool;
import com.jd.framwork.sys.user.utils.Page;

@Repository
public class LeasingDao  {

    private SqlSessionFactory sessionFactory;

    public SqlSession getSqlSession() {
        return this.sessionFactory.openSession();
    }
    
    @Autowired
    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;}
    
    public void deleteLeasing(int id){
        getSqlSession().delete(Leasing.class.getName()+".deleteLeasing",id);
    }
    public List<Leasing> queryLeasing(){
        List<Leasing> leasingList=getSqlSession().selectList(Leasing.class.getName()+".queryLeasing");
        return leasingList;
    }
    
    public void updateLeasing(Leasing leasing){
        getSqlSession().update(leasing.getClass().getName()+".updateLeasing",leasing);
    }
    
    public void addLeasing(Leasing leasing,AddLeasingTool addLeasingTool ) {
        // TODO Auto-generated method stub
        getSqlSession().insert(leasing.getClass().getName()+".addLeasingA",leasing);
        getSqlSession().update(leasing.getClass().getName()+".addLeasingB",addLeasingTool);
    }
    public Leasing queryLeasingById(int id){
        Leasing leasing=getSqlSession().selectOne(Leasing.class.getName()+".queryLeasingById",id);
        return leasing;
    }
    
    public List<Leasing> queryLeasingPage(Page pages ) {
        // TODO Auto-generated method stub
        List<Leasing> leasing=getSqlSession().selectList(Leasing.class.getName()+".queryLeasingByPage",pages);
        return leasing;
    }
    /**
     * 根据id查询要解除合同的信息
     */
    public Leasing querygLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=getSqlSession().selectOne(Leasing.class.getName()+".queryLeasingById",id);
        return leasing;
    }
    /**
     * 根据id查询要修改的续约信息
     */
    public Leasing queryfLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=getSqlSession().selectOne(Leasing.class.getName()+".queryLeasingById",id);
        return leasing;
    }
    /**
     * 根据id查询要续约的合同信息
     */
    public Leasing querysLeasingById(int id) {
        // TODO Auto-generated method stub
        Leasing leasing=getSqlSession().selectOne(Leasing.class.getName()+".queryLeasingById",id);
        return leasing;
    }
    /**
     * 续约合同信息
     */
    public void updatesLeasing(Leasing leasing ) {
        // TODO Auto-generated method stub
        getSqlSession().update(leasing.getClass().getName()+".updatesLeasing",leasing);
    }
    
    public void updatefLeasing(Leasing leasing ) {
        // TODO Auto-generated method stub
        getSqlSession().update(leasing.getClass().getName()+".updatefLeasing",leasing);
    }
    //完成租赁
    public void updateLeasingCom(LeasTool leasTool,Leasing leasing ) {
        // TODO Auto-generated method stubLeasTool leasTool,Leasing leasing
        getSqlSession().update(Leasing.class.getName()+".updateLeasingComA",leasing);
        System.out.println("车辆更新");
        getSqlSession().update(Leasing.class.getName()+".updateLeasingComB",leasTool);
        System.out.println("第二次更新");
    }
    //根据用户姓名查询订单信息
    public Leasing queryLeasingByUserId(User user) {
        // TODO Auto-generated method stub
        Leasing leasing=getSqlSession().selectOne(Leasing.class.getName()+".queryLeasingByUserId",user);
        return leasing;
    }
    //完成租赁
    public void cancelOrder(LeasTool leasTool,int id) {
        // TODO Auto-generated method stubLeasTool leasTool,Leasing leasing
        getSqlSession().delete(Leasing.class.getName()+".cancelOrder",id);
        System.out.println("删除leasing");
        getSqlSession().update(Leasing.class.getName()+".cancelOrderCar",leasTool);
        System.out.println("更新车辆状态");
    }
}
