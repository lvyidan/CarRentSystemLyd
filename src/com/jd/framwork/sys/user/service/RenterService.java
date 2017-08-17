package com.jd.framwork.sys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.framwork.sys.user.dao.RenterDao;
import com.jd.framwork.sys.user.domain.Renter;
import com.jd.framwork.sys.user.utils.Page;



/**
 * 处理用户业务类
 * @author Administrator
 *
 */
@Service
public class RenterService {
    
    @Autowired
    private  RenterDao renterDao;

    
    public void updateRenter(Renter renter ) {
        // TODO Auto-generated method stub
        this.renterDao.updateRenter(renter);
    }
    public void addRenter(Renter renter) {
        // TODO Auto-generated method stub
        this.renterDao.addRenter(renter);
    }
    public void deleteRenter(int id) {
        // TODO Auto-generated method stub
        this.renterDao.deleteRenter(id);
    }

    public List<Renter> queryRenter() {
        // TODO Auto-generated method stub
        List<Renter> renterList=this.renterDao.queryRenter();
        return renterList;
    }
    public Renter queryRenterById(int id) {
        // TODO Auto-generated method stub
        Renter renter=this.renterDao.queryRenterById(id);
        return renter;
    }
    public List<Renter> queryRenterByPage(Page pages) {
        // TODO Auto-generated method stub
        List<Renter> renter=this.renterDao.queryRenterPage(pages);
        return renter;
    }
}


