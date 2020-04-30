package com.store.order.dao;

import java.util.List;

import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;

/**
 * ����ģ��־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface OrderDao {

	//���涩������
	public void save(Order order);

	//����uidͳ�ƶ�����
	public int findCountUid(Integer uid);

	//����uid��ѯ������Ϣ
	public List<Order> findByPageUid(Integer uid, int startIndex, int limit);

	//���ݶ���id��ѯ����
	public Order findByOid(Integer oid);

	//�޸Ķ�����Ϣ
	public void update(Order order);

	//ͳ�����ж�������
	public int findCount();

	//��ѯ���ж�������ҳ
	public List<Order> findAll(int startIndex, int limit);

	//����id��ѯ������
	public List<OrderItem> findOrderItem(Integer oid);

}
