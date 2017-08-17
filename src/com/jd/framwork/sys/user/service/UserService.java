package com.jd.framwork.sys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.framwork.sys.user.dao.UserDao;
import com.jd.framwork.sys.user.domain.User;
import com.jd.framwork.sys.user.utils.Page;



/**
 * 处理用户业务类
 * @author Administrator
 *
 */
@Service
public class UserService {

    @Autowired
    private  UserDao userDao;
    

    public User login(User user ) {
        // TODO Auto-generated method stub
        return this.userDao.login(user);
    }

    public void updateUser(User user ) {
        // TODO Auto-generated method stub
        this.userDao.updateUser(user);
    }
    public void addUser(User user ) {
        // TODO Auto-generated method stub
        this.userDao.addUser(user);
    }
    public void deleteUser(int id) {
        // TODO Auto-generated method stub
        this.userDao.deleteUser(id);
        System.out.println("service");
    }
    
    public List<User> queryUser() {
        // TODO Auto-generated method stub
        List<User> userList=this.userDao.queryUser();
        return userList;
    }
    public User queryUserById(int id) {
        // TODO Auto-generated method stub
        User user=this.userDao.queryUserById(id);
        return user;
    }
    public List<User> queryUserByPage(Page pages) {
        // TODO Auto-generated method stub
        List<User> user=this.userDao.queryUserPage(pages);
        return user;
    }
    //根据用户名查询用户
    public User queryUserByName(String name) {
        // TODO Auto-generated method stub
        User user=this.userDao.queryUserByName(name);
        return user;
    }
}


