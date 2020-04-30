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
 * ��ҳ����action
 * @author dhw
 *
 */
public class IndexAction extends ActionSupport{
	
	//ע��һ������service
	private CategoryService categoryService;
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	//ע����Ʒservice
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//������ҳ�ķ���
	public String execute() {
		//��ֹ�ظ���ѯ
		List<Category> _cList = (List<Category>) ActionContext.getContext().getSession().get("cList");
		if(_cList == null) {
			//��ѯ����һ������ļ���
			List<Category> cList = categoryService.findAll();
			//��һ�����༯�ϴ���session
			ActionContext.getContext().getSession().put("cList", cList);
		}
			//��ѯ������Ʒ
			List<Product> hList = productService.findHot();
			//�����ݴ���ֵջ��
			ActionContext.getContext().getValueStack().set("hList", hList);
			//��ѯ����ϼ���Ʒ
			List<Product> nList = productService.findNew();
			//�����ݴ���ֵջ��
			ActionContext.getContext().getValueStack().set("nList", nList);
		return "index";
	}
}
