package com.store.adminuser.dao;

import java.util.List;

import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;

/**
 * 后台模块持久层接口规范
 * @author dhw
 *
 */
public interface AdminUserDao {

	//后台登录
	public AdminUser login(AdminUser adminUser);

	//查询所有
	public List<AdminUser> findAll();

	//查询
	public AdminUser findByUid(Integer uid);

	//根据id和密码查询(校验原密码是否输入正确)
	public AdminUser findByUidAndPass(AdminUser adminUser);

	//编辑
	public void edit(AdminUser adminUser);

	//根据用户名查询
	public AdminUser findByUsername(String username);

	//添加
	public void save(AdminUser adminUser);

	//删除
	public void delete(AdminUser adminUser);

	//销售统计（每日）
	public List salesByDay();

	//销售统计（每月）
	public List salesByMonth();

	//销售统计（每年）
	public List salesByYear();

}
