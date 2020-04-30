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
 * ��̨�����������action
 * @author dhw
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond> {
	//ģ�������������
	private CategorySecond categorySecond = new CategorySecond();
	public CategorySecond getModel() {
		return categorySecond;
	}

	//ע��CategorySecondService
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//ע��һ������service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//����ҳ��page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//--------------------------
	
	//��ѯ����
	public String findAll() {
		PageBean<CategorySecond> pageBean = categorySecondService.findAll(page);
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��ת�����ҳ��
	public String addPage() {
		//��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "addPage";
	}
	
	//��Ӷ�������
	public String save() {
		categorySecondService.save(categorySecond);
		return "saveSuccess";
	}
	
	//ɾ����������
	public String delete() {
		//����ɾ�� �Ȳ��ɾ ������cascade='delete'
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	//��ת���༭ҳ��
	public String editPage() {
		//��ѯ��������
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		//��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("cList", cList);
		return "editPage";
	}
	
	//�༭��������
	public String edit() {
		categorySecondService.edit(categorySecond);
		return "editSuccess";
	}
}
