package com.store.adminuser.service;

import java.util.List;

import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;

/**
 * ��̨ģ��ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface AdminUserService {

	//��̨��¼
	public AdminUser login(AdminUser adminUser);

	//��ѯ����
	public List<AdminUser> findAll();

	//����id��ѯ
	public AdminUser findByUid(Integer uid);

	//����id�������ѯ
	public AdminUser findByUidAndPass(AdminUser adminUser);

	//�޸�����
	public void edit(AdminUser adminUser);

	//�����û�����ѯ
	public AdminUser findByUsername(String username);

	//��ӹ���Ա�û�
	public void save(AdminUser adminUser);

	//ɾ������Ա�û�
	public void delete(AdminUser adminUser);

	//����ͳ�ƣ�ÿ�գ�
	public List salesByDay();

	//����ͳ�ƣ�ÿ�£�
	public List salesByMonth();

	//����ͳ�ƣ�ÿ�꣩
	public List salesByYear();

}
