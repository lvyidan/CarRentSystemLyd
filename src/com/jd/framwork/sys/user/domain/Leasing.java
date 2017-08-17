package com.jd.framwork.sys.user.domain;
/**
 * 租赁合同类封装
 * @author Administrator
 *
 */

public class Leasing {
    
    private int id;
    private String number;  //车牌号
    private String rentername;  //租赁人
    private float price;  //租赁单价
    private String usetime;  //租赁期限
    private float pledge; //押金
    private String starttime;  //发车时间
    private String transactor;  //办理人
    private String renewal;  //是否续约
    private String rtime;  //续约时长
    private String rtransactor;  //续约办理人
    private String backtime;  //还车时间
    private float total;  //总金额
    private String note;  //备注
    private String obligate;  //预留


    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getRentername() {
        return this.rentername;
    }
    public void setRentername(String rentername) {
        this.rentername = rentername;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getUsetime() {
        return this.usetime;
    }
    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }
    
    public float getPledge() {
        return this.pledge;
    }
    public void setPledge(float pledge) {
        this.pledge = pledge;
    }
    public String getStarttime() {
        return this.starttime;
    }
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public String getTransactor() {
        return this.transactor;
    }
    public void setTransactor(String transactor) {
        this.transactor = transactor;
    }
    public String getRenewal() {
        return this.renewal;
    }
    public void setRenewal(String renewal) {
        this.renewal = renewal;
    }
    public String getRtime() {
        return this.rtime;
    }
    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
    public String getRtransactor() {
        return this.rtransactor;
    }
    public void setRtransactor(String rtransactor) {
        this.rtransactor = rtransactor;
    }
    public String getBacktime() {
        return this.backtime;
    }
    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }
    public float getTotal() {
        return this.total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public String getNote() {
        return this.note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getObligate() {
        return this.obligate;
    }
    public void setObligate(String obligate) {
        this.obligate = obligate;
    }


}
