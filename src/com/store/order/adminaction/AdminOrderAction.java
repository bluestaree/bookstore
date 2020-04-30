package com.store.order.adminaction;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.order.service.OrderService;
import com.store.utils.PageBean;

/**
 * 后台订单管理action
 * @author dhw
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型驱动所需对象
	private Order order = new Order();
	public Order getModel() {
		return order;
	}
	
	//注入orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	//接收页数page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//-----------------------------
	
	//查询所有
	public String findAll() {
		PageBean<Order> pageBean = orderService.findAll(page);
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//查询订单项
	public String findOrderItem() {
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//将数据存入值栈
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	//修改订单状态
	public String updateState() {
		//查询订单
		Order _order = orderService.findByOid(order.getOid());
		//修改订单状态
		_order.setState(3);
		orderService.update(_order);
		return "updateState";
	}
}
