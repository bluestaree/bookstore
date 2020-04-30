package com.store.product.action;

import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;
import com.store.categorysecond.domain.CategorySecond;
import com.store.categorysecond.service.CategorySecondService;
import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.product.service.ProductService;
import com.store.utils.PageBean;

/**
 * 商品模块action
 * @author dhw
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动所需对象
	Product product = new Product();
	public Product getModel() {
		return product;
	}

	//注入productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入categoryService
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//categorySecondService
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//接收一级分类cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCid() {
		return cid;
	}

	//接收二级分类csid
	private Integer csid;
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Integer getCsid() {
		return csid;
	}
	
	//接收page页数
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//接收limit分页信息
	private int limit;
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	//接收searchkey搜索关键字
	private String searchkey;
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getSearchkey() {
		return searchkey;
	}	
	
	//评论所需参数
	private String rname;
	private int quality;
	private String rtext;
	public void setRname(String rname) {
		this.rname = rname;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	
	//-----------------------------------------------------------------
	
	//根据id查询商品信息
	public String findByPid() {
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	//根据一级分类查询
	public String findByCid() {
		Category category = categoryService.findByCid(cid);
		PageBean<Product> pageBean = productService.findByPageCid(cid,page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("cg", category);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogGrid";
	}
	
	//商品列表页面的切换(列表视图)
	public String findByCidList () {
		Category category = categoryService.findByCid(cid);
		PageBean<Product> pageBean = productService.findByPageCid(cid,page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("cg", category);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogList";
	}
	
	//根据二级分类查询
	public String findByCsid() {
		CategorySecond categorySecond = categorySecondService.findByCsid(csid);
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("cgs", categorySecond);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogGrid";
	}
	
	//商品列表页面的切换(列表视图)
	public String findByCsidList() {
		CategorySecond categorySecond = categorySecondService.findByCsid(csid);
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("cgs", categorySecond);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogList";
	}
	
	//查询相关商品(根据二级分类id查询)
	public String related() {
		//根据id查询商品
		product = productService.findByPid(product.getPid());
		PageBean<Product> pageBean = productService.findRelate(csid,product.getPid(),page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "related";
	}
	
	//查询所有商品
	public String findAll() {
		PageBean<Product> pageBean = productService.findAll(page,limit);	//分页查询
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//添加商品评论
	public String addReview() {
		Review review = new Review();
		//设置参数
		review.setProduct(product);
		review.setQuality(quality);
		review.setRname(rname);
		review.setRtext(rtext);
		review.setReviewtime(new Date());
		//添加评论
		productService.addReview(review);
		this.addActionMessage("添加评论成功!");
		return "msg";
	}
	
	//根据关键字搜索商品
	public String search() {
		PageBean<Product> pageBean = productService.finBySearchKey(searchkey,page,limit);
		//将pageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "search";
	}
}
