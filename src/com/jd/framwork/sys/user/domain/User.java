package com.jd.framwork.sys.user.domain;
/**
 * 用户类封装
 * @author Administrator
 *
 */

public class User {
    
    private int id;
    private String username;  //用户名称
    private String phone;  //电话
    private String sex;  //性别
    private String age;  //年龄
    private String idnum;  //身份证号
    private String address;  //住址
    private String password;  //密码
    
    private String note;  //备注
    private String obligate;  //预留

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getAge() {
        return this.age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getIdnum() {
        return this.idnum;
    }
    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
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
