package com.store.product.adminaction;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.categorysecond.domain.CategorySecond;
import com.store.categorysecond.service.CategorySecondService;
import com.store.product.domain.Product;
import com.store.product.service.ProductService;
import com.store.utils.PageBean;

/**
 * ��̨��Ʒ����action
 * @author dhw
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	//ģ�������������
	private Product product = new Product();
	public Product getModel() {
		return product;
	}
	
	//ע��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//ע��categorySecondService
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//����ҳ��page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//�ļ��ϴ��������
	private File upload;	//�ϴ����ļ�
	private String uploadFileName;	//�ϴ����ļ���
	private String uploadContextType;	//�ϴ��ļ���MIME����
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	
	//-----------------------------
	
	//��ѯ����
	public String findAll() {
		PageBean<Product> pageBean = productService.findAll(page, 6);
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��ת�����ҳ��
	public String addPage() {
		//��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	
	//�����Ʒ
	public String save(){
		//���Ʋ���
		product.setPdate(new Date());
		//�ļ��ϴ�����
		if(upload != null){
			//����ƷͼƬ�ϴ�����������.
			//����ϴ�ͼƬ�ķ�������·��.
			String path = ServletActionContext.getServletContext().getRealPath("/products/1");
			//�����ļ����Ͷ���:
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();	
			}
			//�ļ��ϴ�:
			upload.renameTo(new File(file, uploadFileName));
			product.setImage("products/1/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//ɾ����Ʒ
	public String delete() {
		product = productService.findByPid(product.getPid());
		//ɾ���ϴ���ͼƬ
		String path = product.getImage();
		if(path != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/" + path);
			File file = new File(realPath);
			file.delete();
		}
		productService.delete(product);
		return "deleteSuccess";
	}
	
	//��ת���༭ҳ��
	public String editPage() {
		//��ѯ��Ʒ
		product = productService.findByPid(product.getPid());
		//��ѯ���ж�������
		List<CategorySecond> csList = categorySecondService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editPage";
	}
	
	//�༭��Ʒ
	public String edit() {
		//�ж��Ƿ���Ҫ�޸�ͼƬ
		if(upload != null){
			//ɾ����ǰ��ͼƬ
			File _file = new File(ServletActionContext.getServletContext().getRealPath("/" + product.getImage()));
			_file.delete();
			//�ϴ��µ�ͼƬ
			String path = ServletActionContext.getServletContext().getRealPath("/products/1");
			File file = new File(path);
			upload.renameTo(new File(file, uploadFileName));
			product.setImage("products/1/" + uploadFileName);
		}
		//����Ϣ�������ݿ�
		productService.edit(product);
		return "editSuccess";
	}
}
