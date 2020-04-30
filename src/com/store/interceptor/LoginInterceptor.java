package com.store.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.store.adminuser.domain.AdminUser;
/**
 * ��̨��¼������
 * @author dhw
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception {
		//1.��ȡsession
		AdminUser adminUser = (AdminUser) ActionContext.getContext().getSession().get("adminUser");
		//2.�ж��Ƿ�������û���Ϣ
		if(adminUser == null) {
			//3.û�е�¼,���ص�¼ҳ�沢��ʾ��Ϣ
			//��ȡ��ǰAction
			Object action = invocation.getAction();
			if(action instanceof ActionSupport) {
				ActionSupport actionSupport = (ActionSupport)action;
				actionSupport.addActionError("���Ƚ��е�¼");
			}
			return "adminLogin";
		}
		//4.�Ѿ���¼,����
		return invocation.invoke();
	}

}
