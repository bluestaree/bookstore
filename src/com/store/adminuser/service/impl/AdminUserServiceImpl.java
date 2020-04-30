package com.store.adminuser.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.adminuser.dao.AdminUserDao;
import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;
import com.store.adminuser.service.AdminUserService;

/**
 * 后台模块业务层
 * @author dhw
 *
 */
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	//注入adminUserDao
	private AdminUserDao adminUserDao ;
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}
	
	//后台登录
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}

	//查询所有
	public List<AdminUser> findAll() {
		return adminUserDao.findAll();
	}

	//根据id查询
	public AdminUser findByUid(Integer uid) {
		return adminUserDao.findByUid(uid);
	}

	//根据id和密码查询
	public AdminUser findByUidAndPass(AdminUser adminUser) {
		return adminUserDao.findByUidAndPass(adminUser);
	}

	//修改密码
	public void edit(AdminUser adminUser) {
		adminUserDao.edit(adminUser);
	}

	//根据用户名查询
	public AdminUser findByUsername(String username) {
		return adminUserDao.findByUsername(username);
	}

	//添加管理员用户
	public void save(AdminUser adminUser) {
		adminUserDao.save(adminUser);
	}

	//删除管理员用户
	public void delete(AdminUser adminUser) {
		adminUserDao.delete(adminUser);;
	}

	//销售统计（每日）
	public List salesByDay() {
		return adminUserDao.salesByDay();
	}

	//销售统计（每月）
	public List salesByMonth() {
		return adminUserDao.salesByMonth();
	}

	//销售统计（每年）
	public List salesByYear() {
		return adminUserDao.salesByYear();
	}
}
