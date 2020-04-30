package com.store.adminuser.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.adminuser.dao.AdminUserDao;
import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;
import com.store.adminuser.service.AdminUserService;

/**
 * ��̨ģ��ҵ���
 * @author dhw
 *
 */
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	//ע��adminUserDao
	private AdminUserDao adminUserDao ;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//��̨��¼
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

	//��ѯ����
	public List<AdminUser> findAll() {
		return adminUserDao.findAll();
	}

	//����id��ѯ
	public AdminUser findByUid(Integer uid) {
		return adminUserDao.findByUid(uid);
	}

	//����id�������ѯ
	public AdminUser findByUidAndPass(AdminUser adminUser) {
		return adminUserDao.findByUidAndPass(adminUser);
	}

	//�޸�����
	public void edit(AdminUser adminUser) {
		adminUserDao.edit(adminUser);
	}

	//�����û�����ѯ
	public AdminUser findByUsername(String username) {
		return adminUserDao.findByUsername(username);
	}

	//��ӹ���Ա�û�
	public void save(AdminUser adminUser) {
		adminUserDao.save(adminUser);
	}

	//ɾ������Ա�û�
	public void delete(AdminUser adminUser) {
		adminUserDao.delete(adminUser);;
	}

	//����ͳ�ƣ�ÿ�գ�
	public List salesByDay() {
		return adminUserDao.salesByDay();
	}

	//����ͳ�ƣ�ÿ�£�
	public List salesByMonth() {
		return adminUserDao.salesByMonth();
	}

	//����ͳ�ƣ�ÿ�꣩
	public List salesByYear() {
		return adminUserDao.salesByYear();
	}
}
