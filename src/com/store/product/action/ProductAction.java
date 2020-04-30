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
 * ��Ʒģ��action
 * @author dhw
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	//ģ�������������
	Product product = new Product();
	public Product getModel() {
		return product;
	}

	//ע��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//ע��categoryService
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
	
	//����һ������cid
	private Integer cid;
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getCid() {
		return cid;
	}

	//���ն�������csid
	private Integer csid;
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public Integer getCsid() {
		return csid;
	}
	
	//����pageҳ��
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//����limit��ҳ��Ϣ
	private int limit;
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	//����searchkey�����ؼ���
	private String searchkey;
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getSearchkey() {
		return searchkey;
	}	
	
	//�����������
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
	
	//����id��ѯ��Ʒ��Ϣ
	public String findByPid() {
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	
	//����һ�������ѯ
	public String findByCid() {
		Category category = categoryService.findByCid(cid);
		PageBean<Product> pageBean = productService.findByPageCid(cid,page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("cg", category);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogGrid";
	}
	
	//��Ʒ�б�ҳ����л�(�б���ͼ)
	public String findByCidList () {
		Category category = categoryService.findByCid(cid);
		PageBean<Product> pageBean = productService.findByPageCid(cid,page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("cg", category);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogList";
	}
	
	//���ݶ��������ѯ
	public String findByCsid() {
		CategorySecond categorySecond = categorySecondService.findByCsid(csid);
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("cgs", categorySecond);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogGrid";
	}
	
	//��Ʒ�б�ҳ����л�(�б���ͼ)
	public String findByCsidList() {
		CategorySecond categorySecond = categorySecondService.findByCsid(csid);
		PageBean<Product> pageBean = productService.findByPageCsid(csid,page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("cgs", categorySecond);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "catalogList";
	}
	
	//��ѯ�����Ʒ(���ݶ�������id��ѯ)
	public String related() {
		//����id��ѯ��Ʒ
		product = productService.findByPid(product.getPid());
		PageBean<Product> pageBean = productService.findRelate(csid,product.getPid(),page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "related";
	}
	
	//��ѯ������Ʒ
	public String findAll() {
		PageBean<Product> pageBean = productService.findAll(page,limit);	//��ҳ��ѯ
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//�����Ʒ����
	public String addReview() {
		Review review = new Review();
		//���ò���
		review.setProduct(product);
		review.setQuality(quality);
		review.setRname(rname);
		review.setRtext(rtext);
		review.setReviewtime(new Date());
		//�������
		productService.addReview(review);
		this.addActionMessage("������۳ɹ�!");
		return "msg";
	}
	
	//���ݹؼ���������Ʒ
	public String search() {
		PageBean<Product> pageBean = productService.finBySearchKey(searchkey,page,limit);
		//��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "search";
	}
}
