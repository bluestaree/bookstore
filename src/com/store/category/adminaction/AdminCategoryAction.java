package com.store.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;

/**
 * 后台一级分类管理action
 * @author dhw
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	//模型驱动所需对象
	private Category category = new Category();
	public Category getModel() {
		return category;
	}

	//注入categoryservice
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//查询所有
	public String findAll() {
		List<Category> cList = categoryService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//添加一级分类
	public String save() {
		categoryService.save(category);
		return "saveSuccess";
	}
	
	//删除一级分类
	public String delete() {
		//删除一级分类的同时删除其所属的二级分类，需配置cascade='delete'
		//先查询，后删除，
		Category _category = categoryService.findByCid(category.getCid());
		categoryService.delete(_category);
		return "deleteSuccess";
	}
	
	//跳转至编辑页面
	public String editPage() {
		category = categoryService.findByCid(category.getCid());
		//页面跳转 回显数据
		return "editPage";
	}
	
	//编辑一级分类
	public String edit() {
		categoryService.edit(category);
		return "editSuccess";
	}
}
