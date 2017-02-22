/**
 * Company:	北京东方国信科技股份有限公司 (www.bonc.com.cn)
 * Project Name:bmonitor 
 * File Name:Pager.java 
 * Package Name:com.bonc.monitor.bean 
 * Date:2016年11月21日下午5:46:23 
 * Copyright (C) 2016,BONC. All rights reserved.
 * 
 */
package edu.hsxy.bysj.bean;

/**
 * ClassName: Pager <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年11月21日 下午5:46:23 <br/>
 * 
 * @author jacob
 * @version
 * @since JDK 1.8
 */
public class Pager {

	int page = 1;
	int size = 5;
	int totalPages;

	/**
	 * Creates a new instance of Pager.
	 * 
	 */
	public Pager() {
		// TODO Auto-generated constructor stub
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public Pager(int page, int size, int totalPages) {
		super();
		this.page = page;
		this.size = size;
		this.totalPages = totalPages;
	}

	@Override
	public String toString() {
		return "Pager [page=" + page + ", size=" + size + ", totalPages=" + totalPages + "]";
	}

}
