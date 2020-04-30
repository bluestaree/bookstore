package com.store.product.domain;

import java.util.Date;

/**
 * 商品评论表实体类
 * @author dhw
 *
 */

public class Review {
	private Integer rid;
	private String rname;
	private Integer quality;
	private String rtext;
	private Date reviewtime;
	//与商品关系
	private Product product;
	
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public Integer getQuality() {
		return quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public Date getReviewtime() {
		return reviewtime;
	}
	public void setReviewtime(Date reviewtime) {
		this.reviewtime = reviewtime;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
