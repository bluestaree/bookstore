package com.store.adminuser.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;
import com.store.adminuser.service.AdminUserService;

/**
 * 后台模块action
 * @author dhw
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	//模型驱动所需对象
	private AdminUser adminUser = new AdminUser();
	public AdminUser getModel() {
		return adminUser;
	}

	//注入adminUserService
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	//接收新密码
	private String newpassword;
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	//接受时间段代码
	private int scop;
	public int getScop() {
		return scop;
	}
	public void setScop(int scop) {
		this.scop = scop;
	}
	
	//------------------------------


	//后台管理员登录
	public String login() {
		//查询
		AdminUser _adminUser = adminUserService.login(adminUser);
		//判断
		if(_adminUser == null) {
			//用户名密码错误
			this.addActionError("用户名或密码错误！");
			return "login";
		}else {
			//将用户数据存入session
			ActionContext.getContext().getSession().put("adminUser", _adminUser);
			return "loginSuccess";
		}
	}
	
	//查询所有
	public String findAll() {
		List<AdminUser> list =  adminUserService.findAll();
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}
	
	//注销登录
	public String quit() {
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//跳转至编辑页面
	public String editPage() {
		adminUser = adminUserService.findByUid(adminUser.getUid());
		return "editPage";
	}
	
	//修改密码
	public String edit() {
		//根据id和密码查询
		AdminUser _adminUser = adminUserService.findByUidAndPass(adminUser);
		if(_adminUser == null) {
			//原密码输入错误
			this.addActionError("原密码输入错误，无法进行密码修改操作");
			return "editFail";
		} else {
			//修改密码
			_adminUser.setPassword(newpassword);
			adminUserService.edit(_adminUser);
			this.addActionMessage("密码修改成功");
		}
		return "editSuccess";
	}
	
	//ajax异步请求校验用户名
	public String findByName() throws IOException {
		//调用业务层方法
		AdminUser _adminUser = adminUserService.findByUsername(adminUser.getUsername());
		//获得response对象，对页面进行输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");	//设置字符集
		//判断用户是否存在
		if(_adminUser != null) {
			//用户名已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		} else {
			//用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return null;
	}
	
	//添加管理员
	public String save() {
		adminUserService.save(adminUser);
		return "saveSuccess";
	}
	
	//删除管理员用户
	public String delete() {
		adminUserService.delete(adminUser);
		return "deleteSuccess";
	}
	
	//统计销售
	public String statistics() {
		List list = null;
		if(scop == 1) {
			list =  adminUserService.salesByDay();
		}else if(scop == 2) {
			list =  adminUserService.salesByMonth();
		}else if(scop == 3) {
			list =  adminUserService.salesByYear();
		}
		List<Statistics> slist = new ArrayList<Statistics>();
		for(int i = 0 ; i < list.size() ; i++) {
			Object ob[] = (Object[]) list.get(i);
			Statistics s = new Statistics();
			s.setSchedule(ob[0]);
			s.setTotal(ob[1]);
			s.setCount(ob[2]);
			s.setDeal(ob[3]);
			s.setDealtotal(ob[4]);
			slist.add(s);
		}
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("list",slist);
		return "statistics";
	}
	
}
