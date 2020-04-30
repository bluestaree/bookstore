package com.store.order.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.order.dao.OrderDao;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.order.service.OrderService;
import com.store.utils.PageBean;

/**
 * 订单模块业务层
 * @author dhw
 *
 */
@Transactional
public class OrderServiceImpl implements OrderService {

	//注入orderdao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//保存订单数据
	public void save(Order order) {
		orderDao.save(order);
	}

	//查询当前用户订单信息
	public PageBean<Order> findByPageUid(Integer uid, int page) {
		//设置每页显示数
		int limit = 4;
		//设置总记录数
		int totalCount = 0 ;
		totalCount = orderDao.findCountUid(uid);
		//创建pagebean实例对象
		PageBean<Order> pageBean = new PageBean<Order>(page, limit, totalCount);
		//查询订单集合
		List<Order> list = orderDao.findByPageUid(uid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//根据订单id查询订单
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	//修改订单信息
	public void update(Order order) {
		orderDao.update(order);
	}

	//查询所有订单
	public PageBean<Order> findAll(int page) {
		//设置每页显示数
		int limit = 6;
		//设置总记录数
		int totalCount = 0 ;
		totalCount = orderDao.findCount();
		//创建pagebean实例对象
		PageBean<Order> pageBean = new PageBean<Order>(page, limit, totalCount);
		//查询订单集合
		List<Order> list = orderDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//根据id查询订单项
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
}
