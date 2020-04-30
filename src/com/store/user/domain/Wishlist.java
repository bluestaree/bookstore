package com.store.user.domain;

import java.util.Date;

import com.store.product.domain.Product;
import com.store.user.domain.User;

/**
 * 收藏功能实体类
 * @author dhw
 *
 */
public class Wishlist {
	private Integer wid;
	//所属用户
	private User user;
	//所包含的商品
	private Product product;
	private Date wdate;
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	
	
}
