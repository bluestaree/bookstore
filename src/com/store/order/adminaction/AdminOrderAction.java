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
 * ��̨��������action
 * @author dhw
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order>{
	//ģ�������������
	private Order order = new Order();
	public Order getModel() {
		return order;
	}
	
	//ע��orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	//����ҳ��page
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//-----------------------------
	
	//��ѯ����
	public String findAll() {
		PageBean<Order> pageBean = orderService.findAll(page);
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
	
	//��ѯ������
	public String findOrderItem() {
		List<OrderItem> list = orderService.findOrderItem(order.getOid());
		//�����ݴ���ֵջ
		ActionContext.getContext().getValueStack().set("list", list);
		return "findOrderItem";
	}
	
	//�޸Ķ���״̬
	public String updateState() {
		//��ѯ����
		Order _order = orderService.findByOid(order.getOid());
		//�޸Ķ���״̬
		_order.setState(3);
		orderService.update(_order);
		return "updateState";
	}
}
