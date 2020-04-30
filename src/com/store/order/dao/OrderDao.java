package com.store.order.dao;

import java.util.List;

import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;

/**
 * 订单模块持久层接口规范
 * @author dhw
 *
 */
public interface OrderDao {

	//保存订单数据
	public void save(Order order);

	//根据uid统计订单数
	public int findCountUid(Integer uid);

	//根据uid查询订单信息
	public List<Order> findByPageUid(Integer uid, int startIndex, int limit);

	//根据订单id查询订单
	public Order findByOid(Integer oid);

	//修改订单信息
	public void update(Order order);

	//统计所有订单个数
	public int findCount();

	//查询所有订单带分页
	public List<Order> findAll(int startIndex, int limit);

	//根据id查询订单项
	public List<OrderItem> findOrderItem(Integer oid);

}
