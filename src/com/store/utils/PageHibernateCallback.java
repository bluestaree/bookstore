package com.store.utils;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
/**
 * 带分页的自定义查询
 * @author Administrator
 *	返回值类型
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

	private String hql;
	private Object[] params;
	private int startIndex;
	private int pageSize;
	
	//构照注入参数
	public PageHibernateCallback(String hql, Object[] params, int startIndex,
			int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1.通过hql语句获得query对象
		Query query = session.createQuery(hql);
		//2.条件设置
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		//3.分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
