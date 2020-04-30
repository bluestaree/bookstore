package com.store.index.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;
import com.store.product.domain.Product;
import com.store.product.service.ProductService;

/**
 * 首页访问action
 * @author dhw
 *
 */
public class IndexAction extends ActionSupport{
	
	//注入一级分类service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//注入商品service
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//访问首页的方法
	public String execute() {
		//防止重复查询
		List<Category> _cList = (List<Category>) ActionContext.getContext().getSession().get("cList");
		if(_cList == null) {
			//查询所有一级分类的集合
			List<Category> cList = categoryService.findAll();
			//将一级分类集合存入session
			ActionContext.getContext().getSession().put("cList", cList);
		}
			//查询热门商品
			List<Product> hList = productService.findHot();
			//将数据存入值栈中
			ActionContext.getContext().getValueStack().set("hList", hList);
			//查询最近上架商品
			List<Product> nList = productService.findNew();
			//将数据存入值栈中
			ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
