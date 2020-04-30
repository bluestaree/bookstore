package com.store.product.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.store.categorysecond.domain.CategorySecond;


/**
 * 商品表实体类
 * @author dhw
 *
 */

public class Product {
	private Integer pid;
	private String pname;
	private String author;
	private String press;
	private Double market_price;
	private Double shop_price;
	private String image;
	private String spoint;
	private String pdesc;
	private String adesc;
	private Integer is_hot;
	private Date pdate;
	//与二级分类的关系
	private CategorySecond categorySecond;
	//与评论表关系
	private Set<Review> reviews = new HashSet<Review>();
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getMarket_price() {
		return market_price;
	}
	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}
	public Double getShop_price() {
		return shop_price;
	}
	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Integer getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getSpoint() {
		return spoint;
	}
	public void setSpoint(String spoint) {
		this.spoint = spoint;
	}
	public String getAdesc() {
		return adesc;
	}
	public void setAdesc(String adesc) {
		this.adesc = adesc;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public Set<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}
	
}
