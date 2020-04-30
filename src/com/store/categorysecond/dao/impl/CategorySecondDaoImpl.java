package com.store.categorysecond.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.categorysecond.dao.CategorySecondDao;
import com.store.categorysecond.domain.CategorySecond;
import com.store.utils.PageHibernateCallback;

/**
 * 二级分类持久层
 * @author dhw
 *
 */
public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {

	//统计个数
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//查询所有带分页
	public List<CategorySecond> findAll(int startIndex, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//添加
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	//查询
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	//删除
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	//编辑
	public void edit(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	//查询所有
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		List<CategorySecond> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
