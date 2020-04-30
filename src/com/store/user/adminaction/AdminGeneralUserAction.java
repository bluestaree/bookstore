package com.store.user.adminaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.product.domain.Product;
import com.store.user.domain.User;
import com.store.user.service.UserService;
import com.store.utils.PageBean;

/**
 * 后台用户管理action
 * @author dhw
 *
 */
public class AdminGeneralUserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动所需对象
	private User user = new User();
	public User getModel() {
		return user;
	}

	//注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//接收页数page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//---------------------------------------
	
	//查询所有
	public String findAll() {
		PageBean<User> pageBean = userService.findAll(page);
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//添加用户
	public String addUser() {
		userService.addUser(user);
		return "saveSuccess";
	}
	
	//跳转至编辑页面
	public String editPage() {
		//根据id查询用户
		user = userService.findByUid(user.getUid());
		return "editPage";
	}
	
	//编辑用户(状态)
	public String edit() {
		User _user = userService.findByUid(user.getUid());
		_user.setState(user.getState());
		userService.update(_user);
		return "editSuccess";
	}
	
	//删除用户
	public String delete() {
		user = userService.findByUid(user.getUid());
		userService.delete(user);
		return "deleteSuccess";
	}
}
