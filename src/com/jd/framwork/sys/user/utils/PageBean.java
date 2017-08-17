package com.jd.framwork.sys.user.utils;

import java.util.List;

/**
 * 封装分页查询的结果
 * 
 * @author Administrator
 * 
 */

public class PageBean {
	private int page;// 当前第几页
	private int pageSize;// 当前一页显示多少条记录
	private int total;// 总页数
	@SuppressWarnings("unchecked")
	private List list;// 查询的结果集

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@SuppressWarnings("unchecked")
	public List getList() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public void setList(List list) {
		this.list = list;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

}
