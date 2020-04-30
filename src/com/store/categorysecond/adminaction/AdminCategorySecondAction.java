package com.store.categorysecond.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;
import com.store.categorysecond.domain.CategorySecond;
import com.store.categorysecond.service.CategorySecondService;
import com.store.utils.PageBean;

/**
 * 后台二级分类管理action
 * @author dhw
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
	//模型驱动所需对象
	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {
		return categorySecond;
	}

	//注入CategorySecondService
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//注入一级分类service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//接收页数page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//--------------------------
	
	//查询所有
	public String findAll() {
		PageBean<CategorySecond> pageBean = categorySecondService.findAll(page);
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//跳转至添加页面
	public String addPage() {
		//查询所有一级分类
		List<Category> cList = categoryService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	//添加二级分类
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	
	//删除二级分类
	public String delete() {
		//级联删除 先查后删 需配置cascade='delete'
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//跳转到编辑页面
	public String editPage() {
		//查询二级分类
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//查询所有一级分类
		List<Category> cList = categoryService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editPage";
	}
	
	//编辑二级分类
	public String edit() {
		categorySecondService.edit(categorySecond);
		return "editSuccess";
	}
}
