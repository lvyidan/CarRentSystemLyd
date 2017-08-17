package com.jd.framwork.sys.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jd.framwork.sys.user.domain.Car;
import com.jd.framwork.sys.user.utils.AddCarTool;
import com.jd.framwork.sys.user.utils.Page;

@Repository
public class CarDao  {

    private SqlSessionFactory sessionFactory;

    public SqlSession getSqlSession() {
        return this.sessionFactory.openSession();
    }
    
    @Autowired
    public void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;}
    
    public void deleteCar(int id){
        getSqlSession().delete(Car.class.getName()+".deleteCar",id);
    }
    public List<Car> queryCar(){
        List<Car> carList=getSqlSession().selectList(Car.class.getName()+".queryCar");
        return carList;
    }
    
    public void updateCar(Car car){
        getSqlSession().update(car.getClass().getName()+".updateCar",car);
    }
    
    public void addCar(AddCarTool addCarTool) {
        // TODO Auto-generated method stub
        getSqlSession().insert(Car.class.getName()+".addCar",addCarTool);
        
    }
    public Car queryCarById(int id){
        Car car=getSqlSession().selectOne(Car.class.getName()+".queryCarById",id);
        return car;
    }
    
    public List<Car> queryCarPage(Page pages ) {
        // TODO Auto-generated method stub
        List<Car> car=getSqlSession().selectList(Car.class.getName()+".queryCarByPage",pages);
        return car;
    }
    
    
}
