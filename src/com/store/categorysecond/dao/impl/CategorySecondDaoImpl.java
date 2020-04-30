package com.store.categorysecond.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.categorysecond.dao.CategorySecondDao;
import com.store.categorysecond.domain.CategorySecond;
import com.store.utils.PageHibernateCallback;

/**
 * ��������־ò�
 * @author dhw
 *
 */
public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {

	//ͳ�Ƹ���
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ѯ���д���ҳ
	public List<CategorySecond> findAll(int startIndex, int limit) {
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//���
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);
	}

	//��ѯ
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	//ɾ��
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);
	}

	//�༭
	public void edit(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);
	}

	//��ѯ����
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		List<CategorySecond> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
