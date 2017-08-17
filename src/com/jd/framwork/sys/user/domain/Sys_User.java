package com.jd.framwork.sys.user.domain;
/**
 * 用户类封装
 * @author Administrator
 *
 */

public class Sys_User {

    private int id;
    private String account;  //用户名称
    private String user_name;  //电话
    private String password;  //预留
    public int getId() {
        return this.id;}
    public void setId(int id) {
        this.id = id;}
    public String getAccount() {
        return this.account;}
    public void setAccount(String account) {
        this.account = account;}
    public String getUser_name() {
        return this.user_name;}
    public void setUser_name(String user_name) {
        this.user_name = user_name;}
    public String getPassword() {
        return this.password;}
    public void setPassword(String password) {
        this.password = password;}
    

    
}
