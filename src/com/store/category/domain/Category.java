package com.store.category.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.store.categorysecond.domain.CategorySecond;


/**
 * һ������ʵ�����
 * @author dhw
 *
 */
public class Category implements Serializable{
	private Integer cid;
	private String cname;
	//һ�������Ŷ�������ļ���
	private  Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
}
