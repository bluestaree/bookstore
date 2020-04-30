package com.store.category.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.category.dao.CategoryDao;
import com.store.category.domain.Category;

/**
 * 一级分类的持久层
 * @author dhw
 *
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	//查询所有
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list =  this.getHibernateTemplate().find(hql);
		return list;
	}

	//添加
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//查询
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//删除
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//编辑
	public void edit(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
