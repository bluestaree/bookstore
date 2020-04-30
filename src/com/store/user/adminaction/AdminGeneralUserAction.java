package com.store.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.product.domain.Product;
import com.store.user.domain.User;
import com.store.user.service.UserService;
import com.store.utils.PageBean;

/**
 * ��̨�û�����action
 * @author dhw
 *
 */
public class AdminGeneralUserAction extends ActionSupport implements ModelDriven<User>{
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
	
	//����ҳ��page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//---------------------------------------
	
	//��ѯ����
	public String findAll() {
		PageBean<User> pageBean = userService.findAll(page);
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//����û�
	public String addUser() {
		userService.addUser(user);
		return "saveSuccess";
	}
	
	//��ת���༭ҳ��
	public String editPage() {
		//����id��ѯ�û�
		user = userService.findByUid(user.getUid());
		return "editPage";
	}
	
	//�༭�û�(״̬)
	public String edit() {
		User _user = userService.findByUid(user.getUid());
		_user.setState(user.getState());
		userService.update(_user);
		return "editSuccess";
	}
	
	//ɾ���û�
	public String delete() {
		user = userService.findByUid(user.getUid());
		userService.delete(user);
		return "deleteSuccess";
	}
}
