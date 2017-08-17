package com.jd.framwork.sys.user.domain;
/**
 * 租赁人类封装
 * @author Administrator
 *
 */

public class Renter {

    private int id;
    private String rentername;  //租赁人名称
    private String idnum;  //身份证号
    private String phone;  //电话
    private String drivenum;  //驾驶证号
    private String address;  //住址
    private String workunit;  //工作单位
    private String note;  //备注
    private String obligate;  //预留
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRentername() {
        return this.rentername;
    }
    public void setRentername(String rentername) {
        this.rentername = rentername;
    }
    public String getIdnum() {
        return this.idnum;
    }
    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDrivenum() {
        return this.drivenum;
    }
    public void setDrivenum(String drivenum) {
        this.drivenum = drivenum;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getWorkunit() {
        return this.workunit;
    }
    public void setWorkunit(String workunit) {
        this.workunit = workunit;
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
