package com.jd.framwork.sys.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.framwork.sys.user.dao.Sys_UserDao;
import com.jd.framwork.sys.user.domain.Sys_User;



/**
 * 处理用户业务类
 * @author Administrator
 *
 */
@Service
public class Sys_UserService {
    
    @Autowired
    private  Sys_UserDao userDao;
    public Sys_User login(Sys_User user ) {
        // TODO Auto-generated method stub
        return this.userDao.login(user);
    }
    
}


