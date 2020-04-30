package com.store.adminuser.dao;

import java.util.List;

import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;

/**
 * ��̨ģ��־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface AdminUserDao {

	//��̨��¼
	public AdminUser login(AdminUser adminUser);

	//��ѯ����
	public List<AdminUser> findAll();

	//��ѯ
	public AdminUser findByUid(Integer uid);

	//����id�������ѯ(У��ԭ�����Ƿ�������ȷ)
	public AdminUser findByUidAndPass(AdminUser adminUser);

	//�༭
	public void edit(AdminUser adminUser);

	//�����û�����ѯ
	public AdminUser findByUsername(String username);

	//���
	public void save(AdminUser adminUser);

	//ɾ��
	public void delete(AdminUser adminUser);

	//����ͳ�ƣ�ÿ�գ�
	public List salesByDay();

	//����ͳ�ƣ�ÿ�£�
	public List salesByMonth();

	//����ͳ�ƣ�ÿ�꣩
	public List salesByYear();

}
