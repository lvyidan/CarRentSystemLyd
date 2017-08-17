package com.jd.framwork.sys.user.domain;
/**
 * 车辆类封装
 * @author Administrator
 *
 */

public class Car {
    
    private int id;
    private String name;  //车辆名称
    private String type;  //车辆类型
    private String number;  //车牌号
    private float price;  //租赁单价
    private String safetype;  //保险类型
    private String obligate;  //预留

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getSafetype() {
        return this.safetype;
    }
    public void setSafetype(String safetype) {
        this.safetype = safetype;
    }
    public String getObligate() {
        return this.obligate;
    }
    public void setObligate(String obligate) {
        this.obligate = obligate;
    }


}
