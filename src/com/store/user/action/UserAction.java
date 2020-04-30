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
 * 用户模块action
 * @author dhw
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
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
	
	//接收验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	//---收藏功能所需参数---
	//接收商品pid
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	//接收page页数
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//接收limit分页信息
	private int limit;
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	//获取wid
	private Integer wid;
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	//---------------------------------------
	
	//跳转至注册页面
	public String registPage() {
		return "registPage";
	}
	
	//ajax异步请求校验用户名
	public String findByName() throws IOException {
		//调用业务层方法
		User _user = userService.findByUsername(user.getUsername());
		//获得response对象，对页面进行输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");	//设置字符集
		//判断用户是否存在
		if(_user != null) {
			//用户名已存在
			response.getWriter().println("<font color='red'>用户名已存在</font>");
		} else {
			//用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return null;
	}

	//用户注册
	public String regist() {
		//判断验证码是否正确
		String coeckcode1 = (String)ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode.equalsIgnoreCase(coeckcode1)) {
			this.addActionError("验证码输入错误");
			return "checkcodeFail";
		}
		userService.save(user);
		//提示信息
		this.addActionMessage("恭喜您！注册成功！激活邮件已发送至您的邮箱，请激活后登录！");
		return "msg";
	}
	
	//根据激活码激活用户
	public String active() {
		//根据激活码查询用户
		User _user = userService.findByCode(user.getCode());
		//判断是否存在
		if(_user != null) {
			//激活码正确，修改用户信息
			_user.setState(1);
			_user.setCode(null);
			userService.update(_user);
			this.addActionMessage("激活成功！");
		} else {
			//激活码错误
			this.addActionMessage("激活失败：激活码无效或已过期！");			
		}
		return "msg";
	}
	
	//跳转至登录页面
	public String loginPage() {
		return "loginPage";
	}
	
	
	//用户登录
	public String login() {
		User _user = userService.login(user);
		//判断是否存在
		if(_user != null) {
			//登录成功
			//将用户信息存入session域中
			ActionContext.getContext().getSession().put("user", _user);
			return "loginSuccess";
		} else {
			//登录失败
			this.addActionError("登录失败！原因：用户名或密码不正确或是用户未激活！");
			return LOGIN;
		}
	}
	
	//注销登录
	public String quit() {
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//跳转至会员中心页
	public String userCenterPage() {
		return "userCenterPage";
	}
	
	//修改用户信息
	public String edit() {
		userService.update(user);
		this.addActionMessage("修改信息成功,请重新登录!");
		ServletActionContext.getRequest().getSession().setAttribute("user", null);
		return "msg";
	}
	
	//添加收藏(ajax异步请求无需回显)
	public String like() {
		//设置收藏信息
		//先查询是否已经收藏有该商品
		Wishlist _wishlist = userService.findWishlist(user.getUid(),pid);
		if(_wishlist == null) {	//没有收藏过该商品
			Wishlist wishlist = new Wishlist();
			wishlist.setUser(user);
			Product product = new Product();
			product.setPid(pid);
			wishlist.setProduct(product);
			wishlist.setWdate(new Date());
			//添加信息至数据库中
			userService.addWishlist(wishlist);
		}
		return NONE;
	}
	
	//我的收藏
	public String findLikeByUid() {
		//获取uid
		User _user = (User) ActionContext.getContext().getSession().get("user");
		//分页查询
		PageBean<Wishlist> pageBean = userService.findLikeByUid(_user.getUid(),page,limit);
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findLikeByUid";
	}
	
	//取消收藏
	public String cancelLike() {
		Wishlist wishlist = new Wishlist();
		wishlist.setWid(wid);
		userService.cancelLike(wishlist);
		return "cancelLike"; 
	}
}

