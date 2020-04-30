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
 * ��̨ģ��action
 * @author dhw
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	//ģ�������������
	private AdminUser adminUser = new AdminUser();
	public AdminUser getModel() {
		return adminUser;
	}

	//ע��adminUserService
	private AdminUserService adminUserService;
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}
	
	//����������
	private String newpassword;
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	//����ʱ��δ���
	private int scop;
	public int getScop() {
		return scop;
	}
	public void setScop(int scop) {
		this.scop = scop;
	}
	
	//------------------------------


	//��̨����Ա��¼
	public String login() {
		//��ѯ
		AdminUser _adminUser = adminUserService.login(adminUser);
		//�ж�
		if(_adminUser == null) {
			//�û����������
			this.addActionError("�û������������");
			return "login";
		}else {
			//���û����ݴ���session
			ActionContext.getContext().getSession().put("adminUser", _adminUser);
			return "loginSuccess";
		}
	}
	
	//��ѯ����
	public String findAll() {
		List<AdminUser> list =  adminUserService.findAll();
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("list", list);
		return "findAll";
	}
	
	//ע����¼
	public String quit() {
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	
	//��ת���༭ҳ��
	public String editPage() {
		adminUser = adminUserService.findByUid(adminUser.getUid());
		return "editPage";
	}
	
	//�޸�����
	public String edit() {
		//����id�������ѯ
		AdminUser _adminUser = adminUserService.findByUidAndPass(adminUser);
		if(_adminUser == null) {
			//ԭ�����������
			this.addActionError("ԭ������������޷����������޸Ĳ���");
			return "editFail";
		} else {
			//�޸�����
			_adminUser.setPassword(newpassword);
			adminUserService.edit(_adminUser);
			this.addActionMessage("�����޸ĳɹ�");
		}
		return "editSuccess";
	}
	
	//ajax�첽����У���û���
	public String findByName() throws IOException {
		//����ҵ��㷽��
		AdminUser _adminUser = adminUserService.findByUsername(adminUser.getUsername());
		//���response���󣬶�ҳ��������
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");	//�����ַ���
		//�ж��û��Ƿ����
		if(_adminUser != null) {
			//�û����Ѵ���
			response.getWriter().println("<font color='red'>�û����Ѵ���</font>");
		} else {
			//�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return null;
	}
	
	//��ӹ���Ա
	public String save() {
		adminUserService.save(adminUser);
		return "saveSuccess";
	}
	
	//ɾ������Ա�û�
	public String delete() {
		adminUserService.delete(adminUser);
		return "deleteSuccess";
	}
	
	//ͳ������
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
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("list",slist);
		return "statistics";
	}
	
}
