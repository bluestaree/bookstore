package com.store.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵ����
 * @author dhw
 *
 */
public class Cart implements Serializable{
	
	//��ס������ļ���
	//ʹ��map������ɾ ��keyΪ��Ʒ��id��valueΪ������ʵ���� 
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	// �ṩһ��map������value��get����������ȡֵ����
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	// ���ﳵ�е��ܽ��
	private double total;

	public double getTotal() {
		return total;
	}
	//----------------------------------------
	// ���ﳵ�Ĺ���:
	// 1.�����Ʒ(������)
	public void addCart(CartItem cartItem) {
		// �жϹ��ﳵ���Ƿ��Ѿ����ڸù�����:
		// �����Ʒid.
		Integer pid = cartItem.getProduct().getPid();
		// �жϹ��ﳵ���Ƿ��Ѿ����ڸù�����:
		if(map.containsKey(pid)){
			// ����
			CartItem oldCartItem = map.get(pid);// ��ù��ﳵ��ԭ���Ĺ�����
			oldCartItem.setCount(oldCartItem.getCount()+cartItem.getCount());	//�޸�����
		}else{
			// �����ڣ�ֱ�����
			map.put(pid, cartItem);
		}
		// �����ܽ��
		total += cartItem.getSubtotal();
	}

	// 2.�޸���Ʒ����
	public void updateCart(Integer pid , int num) {
		// ��ȡ
		CartItem cartItem = map.get(pid);
		// �ȼ�ȥԭ�ȵ�С��
		total -=  cartItem.getSubtotal();
		// �޸�����
		cartItem.setCount(num);
		// �����ܽ��
		total += cartItem.getSubtotal();
	}
	
	// 3.�ӹ��ﳵ�Ƴ�������
	public void removeCart(Integer pid) {
		// ���������Ƴ����ﳵ:
		CartItem cartItem = map.remove(pid);
		// �����ܽ��
		total -= cartItem.getSubtotal();
	}

	// 4.��չ��ﳵ
	public void clearCart() {
		// �����й��������
		map.clear();
		// ���ܼ�����Ϊ0
		total = 0;
	}
}
