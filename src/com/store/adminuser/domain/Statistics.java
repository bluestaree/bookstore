package com.store.adminuser.domain;

import java.util.Date;

/**
 * 销售统计实体类
 * @author dhw
 *
 */
public class Statistics {

	private Object schedule;
	private Object total;
	private Object count;
	private Object deal;
	private Object dealtotal;
	public Object getSchedule() {
		return schedule;
	}
	public void setSchedule(Object schedule) {
		this.schedule = schedule;
	}
	public Object getTotal() {
		return total;
	}
	public void setTotal(Object total) {
		this.total = total;
	}
	public Object getCount() {
		return count;
	}
	public void setCount(Object count) {
		this.count = count;
	}
	public Object getDeal() {
		return deal;
	}
	public void setDeal(Object deal) {
		this.deal = deal;
	}
	public Object getDealtotal() {
		return dealtotal;
	}
	public void setDealtotal(Object dealtotal) {
		this.dealtotal = dealtotal;
	}

	
}
