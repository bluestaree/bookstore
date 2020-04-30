package com.store.adminuser.service;

import java.util.List;

import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;

/**
 * 后台模块业务层接口规范
 * @author dhw
 *
 */
public interface AdminUserService {

	//后台登录
	public AdminUser login(AdminUser adminUser);

	//查询所有
	public List<AdminUser> findAll();

	//根据id查询
	public AdminUser findByUid(Integer uid);

	//根据id和密码查询
	public AdminUser findByUidAndPass(AdminUser adminUser);

	//修改密码
	public void edit(AdminUser adminUser);

	//根据用户名查询
	public AdminUser findByUsername(String username);

	//添加管理员用户
	public void save(AdminUser adminUser);

	//删除管理员用户
	public void delete(AdminUser adminUser);

	//销售统计（每日）
	public List salesByDay();

	//销售统计（每月）
	public List salesByMonth();

	//销售统计（每年）
	public List salesByYear();

}
