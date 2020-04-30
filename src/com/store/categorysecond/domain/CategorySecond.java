package com.store.categorysecond.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.store.category.domain.Category;
import com.store.product.domain.Product;

/**
 * 二级分类实体类
 * @author dhw
 *
 */
public class CategorySecond implements Serializable{
	private Integer csid;
	private String csname;
	// 与一级分类关系为多对一 (一个一级分类对应多个二级分类)
	private Category category;
	// 与商品关系为一对多 (一个二级分类下有多个商品)
	private Set<Product> products = new HashSet<Product>();
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
