package com.store.user.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.product.domain.Product;
import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.user.service.UserService;
import com.store.utils.PageBean;

/**
 * �û�ģ��action
 * @author dhw
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//ģ�������������
	private User user = new User();
	public User getModel() {
		return user;
	}
	
	//ע��userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//������֤��
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//---�ղع����������---
	//������Ʒpid
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
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
	
	//��ȡwid
	private Integer wid;
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	//---------------------------------------
	
	//��ת��ע��ҳ��
	public String registPage() {
		return "registPage";
	}
	
	//ajax�첽����У���û���
	public String findByName() throws IOException {
		//����ҵ��㷽��
		User _user = userService.findByUsername(user.getUsername());
		//���response���󣬶�ҳ��������
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");	//�����ַ���
		//�ж��û��Ƿ����
		if(_user != null) {
			//�û����Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		} else {
			//�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return null;
	}

	//�û�ע��
	public String regist() {
		//�ж���֤���Ƿ���ȷ
		String coeckcode1 = (String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(coeckcode1)) {
			this.addActionError("��֤���������");
			return "checkcodeFail";
		}
		userService.save(user);
		//��ʾ��Ϣ
		this.addActionMessage("��ϲ����ע��ɹ��������ʼ��ѷ������������䣬�뼤����¼��");
		return "msg";
	}
	
	//���ݼ����뼤���û�
	public String active() {
		//���ݼ������ѯ�û�
		User _user = userService.findByCode(user.getCode());
		//�ж��Ƿ����
		if(_user != null) {
			//��������ȷ���޸��û���Ϣ
			_user.setState(1);
			_user.setCode(null);
			userService.update(_user);
			this.addActionMessage("����ɹ���");
		} else {
			//���������
			this.addActionMessage("����ʧ�ܣ���������Ч���ѹ��ڣ�");			
		}
		return "msg";
	}
	
	//��ת����¼ҳ��
	public String loginPage() {
		return "loginPage";
	}
	
	
	//�û���¼
	public String login() {
		User _user = userService.login(user);
		//�ж��Ƿ����
		if(_user != null) {
			//��¼�ɹ�
			//���û���Ϣ����session����
			ActionContext.getContext().getSession().put("user", _user);
			return "loginSuccess";
		} else {
			//��¼ʧ��
			this.addActionError("��¼ʧ�ܣ�ԭ���û��������벻��ȷ�����û�δ���");
			return LOGIN;
		}
	}
	
	//ע����¼
	public String quit() {
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//��ת����Ա����ҳ
	public String userCenterPage() {
		return "userCenterPage";
	}
	
	//�޸��û���Ϣ
	public String edit() {
		userService.update(user);
		this.addActionMessage("�޸���Ϣ�ɹ�,�����µ�¼!");
		ServletActionContext.getRequest().getSession().setAttribute("user", null);
		return "msg";
	}
	
	//����ղ�(ajax�첽�����������)
	public String like() {
		//�����ղ���Ϣ
		//�Ȳ�ѯ�Ƿ��Ѿ��ղ��и���Ʒ
		Wishlist _wishlist = userService.findWishlist(user.getUid(),pid);
		if(_wishlist == null) {	//û���ղع�����Ʒ
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			Product product = new Product();
			product.setPid(pid);
			wishlist.setProduct(product);
			wishlist.setWdate(new Date());
			//�����Ϣ�����ݿ���
			userService.addWishlist(wishlist);
		}
		return NONE;
	}
	
	//�ҵ��ղ�
	public String findLikeByUid() {
		//��ȡuid
		User _user = (User) ActionContext.getContext().getSession().get("user");
		//��ҳ��ѯ
		PageBean<Wishlist> pageBean = userService.findLikeByUid(_user.getUid(),page,limit);
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findLikeByUid";
	}
	
	//ȡ���ղ�
	public String cancelLike() {
		Wishlist wishlist = new Wishlist();
		wishlist.setWid(wid);
		userService.cancelLike(wishlist);
		return "cancelLike"; 
	}
}

