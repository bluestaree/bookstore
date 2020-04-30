package com.store.order.service;

import java.util.List;

import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.utils.PageBean;

/**
 * 订单模块业务层接口规范
 * @author dhw
 *
 */
public interface OrderService {

	//保存订单数据
	public void save(Order order);

	//查询当前用户订单信息
	public PageBean<Order> findByPageUid(Integer uid, int page);

	//根据订单id查询订单
	public Order findByOid(Integer oid);

	//修改订单信息
	public void update(Order order);

	//查询所有订单
	public PageBean<Order> findAll(int page);

	//根据id查询订单项
	public List<OrderItem> findOrderItem(Integer oid);

}
