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
 * 后台商品管理action
 * @author dhw
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	//模型驱动所需对象
	private Product product = new Product();
	public Product getModel() {
		return product;
	}
	
	//注入productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//注入categorySecondService
	private CategorySecondService categorySecondService;
	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}
	
	//接收页数page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//文件上传所需参数
	private File upload;	//上传的文件
	private String uploadFileName;	//上传的文件名
	private String uploadContextType;	//上传文件的MIME类型
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
	
	//查询所有
	public String findAll() {
		PageBean<Product> pageBean = productService.findAll(page, 6);
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//跳转至添加页面
	public String addPage() {
		//查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "addPage";
	}
	
	//添加商品
	public String save(){
		//完善参数
		product.setPdate(new Date());
		//文件上传操作
		if(upload != null){
			//将商品图片上传到服务器上.
			//获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/products/1");
			//创建文件类型对象:
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();	
			}
			//文件上传:
			upload.renameTo(new File(file, uploadFileName));
			product.setImage("products/1/" + uploadFileName);
		}
		productService.save(product);
		return "saveSuccess";
	}
	
	//删除商品
	public String delete() {
		product = productService.findByPid(product.getPid());
		//删除上传的图片
		String path = product.getImage();
		if(path != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath("/" + path);
			File file = new File(realPath);
			file.delete();
		}
		productService.delete(product);
		return "deleteSuccess";
	}
	
	//跳转到编辑页面
	public String editPage() {
		//查询商品
		product = productService.findByPid(product.getPid());
		//查询所有二级分类
		List<CategorySecond> csList = categorySecondService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("csList", csList);
		return "editPage";
	}
	
	//编辑商品
	public String edit() {
		//判断是否需要修改图片
		if(upload != null){
			//删除以前的图片
			File _file = new File(ServletActionContext.getServletContext().getRealPath("/" + product.getImage()));
			_file.delete();
			//上传新的图片
			String path = ServletActionContext.getServletContext().getRealPath("/products/1");
			File file = new File(path);
			upload.renameTo(new File(file, uploadFileName));
			product.setImage("products/1/" + uploadFileName);
		}
		//将信息存入数据库
		productService.edit(product);
		return "editSuccess";
	}
}
