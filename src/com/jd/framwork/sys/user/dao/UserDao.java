package com.jd.framwork.sys.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.utils.Page;

@Repository
public class UserDao  {

    private SqlSessionFactory sessionFactory;

    public SqlSession getSqlSession() {
        return this.sessionFactory.openSession();
    }
    
    @Autowired
    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;}
    
    public User login(User user) {
        // TODO Auto-generated method stub
        return getSqlSession().selectOne(user.getClass().getName()+".login",user);

    }
    public void deleteUser(int id){
        getSqlSession().delete(User.class.getName()+".deleteUser",id);
    }
    public List<User> queryUser(){
        List<User> userList=getSqlSession().selectList(User.class.getName()+".queryUser");
        return userList;
    }
    
    public void updateUser(User user ) {
        getSqlSession().update(user.getClass().getName() + ".updateUser" , user);
    }
    
    public void addUser(User user ) {
        // TODO Auto-generated method stub
        getSqlSession().insert(user.getClass().getName()+".addUser",user);
        
    }
    
    public User queryUserById(int id){
        User user=getSqlSession().selectOne(User.class.getName()+".queryUserById",id);
        return user;
    }
    //分页查询
    public List<User> queryUserPage(Page pages){
        List<User> user=getSqlSession().selectList(User.class.getName()+".queryUserByPage",pages);
        return user;
    }

    public User  queryUserByName(String name){
        User user=getSqlSession().selectOne(User.class.getName()+".queryUserByName",name);
        return user;
    }
    
}
