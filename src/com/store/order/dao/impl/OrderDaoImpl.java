package com.store.order.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.order.dao.OrderDao;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.product.domain.Product;
import com.store.utils.PageHibernateCallback;

/**
 * 订单模块持久层
 * @author dhw
 *
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	//保存订单数据
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	//根据uid统计订单数
	public int findCountUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid=?";
		List<Long> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据uid查询订单信息
	public List<Order> findByPageUid(Integer uid, int startIndex, int limit) {
		String hql = "from Order o where o.user.uid = ? order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{uid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//根据订单id查询订单
	public Order findByOid(Integer oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	//修改订单信息
	public void update(Order order) {
		this.getHibernateTemplate().update(order);
	}

	//统计所有订单个数
	public int findCount() {
		String hql = "select count(*) from Order";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//查询所有订单带分页
	public List<Order> findAll(int startIndex, int limit) {
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//根据id查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		String hql = "from OrderItem oi where oi.order.oid = ?";
		List<OrderItem> list = this.getHibernateTemplate().find(hql,oid);
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
