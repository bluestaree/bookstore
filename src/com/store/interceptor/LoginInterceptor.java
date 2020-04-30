package com.store.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.store.adminuser.domain.AdminUser;
/**
 * 后台登录拦截器
 * @author dhw
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		//1.获取session
		AdminUser adminUser = (AdminUser) ActionContext.getContext().getSession().get("adminUser");
		//2.判断是否存在有用户信息
		if(adminUser == null) {
			//3.没有登录,返回登录页面并提示信息
			//获取当前Action
			Object action = invocation.getAction();
			if(action instanceof ActionSupport) {
				ActionSupport actionSupport = (ActionSupport)action;
				actionSupport.addActionError("请先进行登录");
			}
			return "adminLogin";
		}
		//4.已经登录,放行
		return invocation.invoke();
	}

}
