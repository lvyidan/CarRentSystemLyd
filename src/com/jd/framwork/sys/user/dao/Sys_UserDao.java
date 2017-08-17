package com.jd.framwork.sys.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.framwork.sys.user.domain.Sys_User;

@Repository
public class Sys_UserDao  {

    private SqlSessionFactory sessionFactory;

    public SqlSession getSqlSession() {
        return this.sessionFactory.openSession();
    }
    
    @Autowired
    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;}
    
    public Sys_User login(Sys_User user) {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne(user.getClass().getName()+".syslogin",user);

    }

    
    
}
