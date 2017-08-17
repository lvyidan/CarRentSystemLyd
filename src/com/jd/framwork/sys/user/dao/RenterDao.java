package com.jd.framwork.sys.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.framwork.sys.user.domain.Renter;
import com.jd.framwork.sys.user.utils.Page;

@Repository
public class RenterDao  {
    
    private SqlSessionFactory sessionFactory;
    
    public SqlSession getSqlSession() {
        return this.sessionFactory.openSession();
    }

    @Autowired
    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;}

    public void deleteRenter(int id){
        getSqlSession().delete(Renter.class.getName()+".deleteRenter",id);
    }
    public List<Renter> queryRenter(){
        List<Renter> renterList=getSqlSession().selectList(Renter.class.getName()+".queryRenter");
        return renterList;
    }

    public void updateRenter(Renter renter){
        getSqlSession().update(renter.getClass().getName()+".updateRenter",renter);
    }

    public void addRenter(Renter renter ) {
        // TODO Auto-generated method stub
        getSqlSession().insert(renter.getClass().getName()+".addRenter",renter);

    }
    public Renter queryRenterById(int id){
        Renter renter=getSqlSession().selectOne(Renter.class.getName()+".queryRenterById",id);
        return renter;
    }

    public List<Renter> queryRenterPage(Page pages) {
        // TODO Auto-generated method stub
        List<Renter> renter=getSqlSession().selectList(Renter.class.getName()+".queryRenterByPage",pages);
        return renter;
    }


}
