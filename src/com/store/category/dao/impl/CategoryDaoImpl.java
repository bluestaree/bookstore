package com.store.category.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.category.dao.CategoryDao;
import com.store.category.domain.Category;

/**
 * һ������ĳ־ò�
 * @author dhw
 *
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	//��ѯ����
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list =  this.getHibernateTemplate().find(hql);
		return list;
	}

	//���
	public void save(Category category) {
		this.getHibernateTemplate().save(category);
	}

	//��ѯ
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	//ɾ��
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);
	}

	//�༭
	public void edit(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
