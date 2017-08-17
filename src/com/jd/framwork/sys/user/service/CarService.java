package com.jd.framwork.sys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.framwork.sys.user.dao.CarDao;
import com.jd.framwork.sys.user.domain.Car;
import com.jd.framwork.sys.user.utils.AddCarTool;
import com.jd.framwork.sys.user.utils.Page;



/**
 * 处理用户业务类
 * @author Administrator
 *
 */
@Service
public class CarService {

    @Autowired
    private  CarDao carDao;
    

    public void updateCar(Car car ) {
        // TODO Auto-generated method stub
        this.carDao.updateCar(car);
    }
    public void addCar(AddCarTool addCarTool ) {
        // TODO Auto-generated method stub
        this.carDao.addCar(addCarTool);
    }
    public void deleteCar(int id) {
        // TODO Auto-generated method stub
        this.carDao.deleteCar(id);
    }
    
    public List<Car> queryCar() {
        // TODO Auto-generated method stub
        List<Car> carList=this.carDao.queryCar();
        return carList;
    }
    public Car queryCarById(int id) {
        // TODO Auto-generated method stub
        Car car=this.carDao.queryCarById(id);
        return car;
    }
    public List<Car> queryCarByPage(Page pages) {
        // TODO Auto-generated method stub
        List<Car> car=this.carDao.queryCarPage(pages);
        return car;
    }
}


