package com.store.order.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.order.dao.OrderDao;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.order.service.OrderService;
import com.store.utils.PageBean;

/**
 * ����ģ��ҵ���
 * @author dhw
 *
 */
@Transactional
public class OrderServiceImpl implements OrderService {

	//ע��orderdao
	private OrderDao orderDao;
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	//���涩������
	public void save(Order order) {
		orderDao.save(order);
	}

	//��ѯ��ǰ�û�������Ϣ
	public PageBean<Order> findByPageUid(Integer uid, int page) {
		//����ÿҳ��ʾ��
		int limit = 4;
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = orderDao.findCountUid(uid);
		//����pagebeanʵ������
		PageBean<Order> pageBean = new PageBean<Order>(page, limit, totalCount);
		//��ѯ��������
		List<Order> list = orderDao.findByPageUid(uid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//���ݶ���id��ѯ����
	public Order findByOid(Integer oid) {
		return orderDao.findByOid(oid);
	}

	//�޸Ķ�����Ϣ
	public void update(Order order) {
		orderDao.update(order);
	}

	//��ѯ���ж���
	public PageBean<Order> findAll(int page) {
		//����ÿҳ��ʾ��
		int limit = 6;
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = orderDao.findCount();
		//����pagebeanʵ������
		PageBean<Order> pageBean = new PageBean<Order>(page, limit, totalCount);
		//��ѯ��������
		List<Order> list = orderDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//����id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid) {
		return orderDao.findOrderItem(oid);
	}
}
