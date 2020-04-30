package com.store.order.service;

import java.util.List;

import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.utils.PageBean;

/**
 * ����ģ��ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface OrderService {

	//���涩������
	public void save(Order order);

	//��ѯ��ǰ�û�������Ϣ
	public PageBean<Order> findByPageUid(Integer uid, int page);

	//���ݶ���id��ѯ����
	public Order findByOid(Integer oid);

	//�޸Ķ�����Ϣ
	public void update(Order order);

	//��ѯ���ж���
	public PageBean<Order> findAll(int page);

	//����id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid);

}
