package com.store.utils;

import java.util.List;

/**
 * 分页功能的实体类
 * @author Administrator
 *
 */
public class PageBean<T> {
	
	//1.基本项
	private int page;		//当前页
	private int limit;		//每页显示信息条数
	private int totalCount;		//总记录数
	
	//2.计算项
	private int startIndex;		//分页查询的开始索引
	private int totalPage;		//总页数
	
	//3.数据
	private List<T> list;		//封装每页数据的集合
	
	//4.动态显示条
	private int start;
	private int end;
	
	//对于一些基本数据,通过构造函数传递,并计算出需要计算的数据项
	public PageBean(int page, int limit, int totalCount) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
		//计算开始索引
		this.startIndex = (this.page - 1) * this.limit;
		//计算总分页数(最大半页思想)原理:java除法,自动向下取整
		this.totalPage = (this.totalCount + this.limit - 1)/this.limit;
		
		//4.1初始化数据(显示10个页面按钮)
		this.start = 1;
		this.end = 10;
		//4.2判断.根据分页数确定要显示的页码范围
		if(this.totalPage < 10) {
			this.end = this.totalPage;
		} else {	//分页数大于10
			//显示的数字范围(当前页面显示的数字上,在前多显示5个数字，在后多显示4数字,共10个数)
			this.start = this.page - 5; 
			this.end = this.page + 4;
			//判断极端情况下的数字显示范围
			if(this.start < 1) {
				this.start = 1;
				this.end = 10;
			} 
			if(this.end > this.totalPage) {
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
