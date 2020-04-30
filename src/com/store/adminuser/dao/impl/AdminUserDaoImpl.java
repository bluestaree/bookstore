package com.store.adminuser.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.adminuser.dao.AdminUserDao;
import com.store.adminuser.domain.AdminUser;
import com.store.adminuser.domain.Statistics;
import com.store.category.domain.Category;
/**
 * 后台模块持久层
 * @author dhw
 *
 */
public class AdminUserDaoImpl extends HibernateDaoSupport implements AdminUserDao {

	//后台登录
	public AdminUser login(AdminUser adminUser) {
		String hql = "from AdminUser where username = ? and password = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,adminUser.getUsername(),adminUser.getPassword());
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//查询所有
	public List<AdminUser> findAll() {
		String hql = "from AdminUser";
		List<AdminUser> list =  this.getHibernateTemplate().find(hql);
		return list;
	}

	//查询
	public AdminUser findByUid(Integer uid) {
		String hql = "from AdminUser where uid = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//根据id和密码查询(校验原密码是否输入正确)
	public AdminUser findByUidAndPass(AdminUser adminUser) {
		String hql = "from AdminUser where uid = ? and password = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,adminUser.getUid(),adminUser.getPassword());
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//编辑
	public void edit(AdminUser adminUser) {
		this.getHibernateTemplate().update(adminUser);
	}

	//根据用户名查询
	public AdminUser findByUsername(String username) {
		String hql = "from AdminUser where username = ?";
		List<AdminUser> list = this.getHibernateTemplate().find(hql,username);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//添加
	public void save(AdminUser adminUser) {
		this.getHibernateTemplate().save(adminUser);
	}

	//删除
	public void delete(AdminUser adminUser) {
		this.getHibernateTemplate().delete(adminUser);
	}

	//销售统计（每日）
	public List salesByDay() {
		String hql = "SELECT o.ordertime AS SCHEDULE,SUM(o.total) AS totel,COUNT(*) AS num,SUM(CASE WHEN  o.state=4  THEN 1 ELSE 0 END) AS deal,SUM(CASE WHEN  o.state=4  THEN o.total ELSE 0 END) AS dealtotal FROM Order o GROUP BY SUBSTRING(ordertime,1,10)";
		return this.getHibernateTemplate().find(hql);
	}

	//销售统计（每月）
	public List salesByMonth() {
		String sql = "SELECT DATE_FORMAT(o.ordertime,'%Y-%m') AS SCHEDULE,SUM(o.total) AS total,COUNT(*) AS num,SUM(CASE WHEN  o.state=4  THEN 1 ELSE 0 END) AS deal,SUM(CASE WHEN  o.state=4  THEN o.total ELSE 0 END) AS dealtotal FROM orders o GROUP BY SCHEDULE";
		return this.getSession().createSQLQuery(sql).list();
	}

	//销售统计（每年）
	public List salesByYear() {
		String sql = "SELECT DATE_FORMAT(o.ordertime,'%Y') AS SCHEDULE,SUM(o.total) AS total,COUNT(*) AS num,SUM(CASE WHEN  o.state=4  THEN 1 ELSE 0 END) AS deal,SUM(CASE WHEN  o.state=4  THEN o.total ELSE 0 END) AS dealtotal FROM orders o GROUP BY SCHEDULE";
		return this.getSession().createSQLQuery(sql).list();
	}

}
