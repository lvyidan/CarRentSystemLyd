package com.jd.framwork.sys.user.utils;


/**
 * 封装分页查询的结果
 *
 * @author Administrator
 *
 */

public class Page {
    private int start;// 开始
    private int end;// 结束
    //private int total;// 总页数
    //@SuppressWarnings("unchecked")
    //private List list;// 查询的结果集
    public int getStart() {
        return this.start;}
    public void setStart(int start) {
        this.start = start;}
    public int getEnd() {
        return this.end;}
    public void setEnd(int end) {
        this.end = end;}
    public Page(int start , int end){
        super();
        this.start = start;
        this.end = end;
    }
    
    
}
