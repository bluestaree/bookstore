package com.store.category.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;

/**
 * ��̨һ���������action
 * @author dhw
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	//ģ�������������
	private Category category = new Category();
	public Category getModel() {
		return category;
	}

	//ע��categoryservice
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//��ѯ����
	public String findAll() {
		List<Category> cList = categoryService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "findAll";
	}
	
	//���һ������
	public String save() {
		categoryService.save(category);
		return "saveSuccess";
	}
	
	//ɾ��һ������
	public String delete() {
		//ɾ��һ�������ͬʱɾ���������Ķ������࣬������cascade='delete'
		//�Ȳ�ѯ����ɾ����
		Category _category = categoryService.findByCid(category.getCid());
		categoryService.delete(_category);
		return "deleteSuccess";
	}
	
	//��ת���༭ҳ��
	public String editPage() {
		category = categoryService.findByCid(category.getCid());
		//ҳ����ת ��������
		return "editPage";
	}
	
	//�༭һ������
	public String edit() {
		categoryService.edit(category);
		return "editSuccess";
	}
}
