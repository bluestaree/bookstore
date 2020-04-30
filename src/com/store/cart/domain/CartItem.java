package com.store.cart.domain;

import com.store.product.domain.Product;


/**
 * ���������
 * @author dhw
 *
 */
public class CartItem {
	private Product product;	// ����������Ʒ����Ϣ
	private int count;			// ��¼����������Ʒ������
	private double subtotal;	// ��¼�ù������С��
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// С�ƣ�ֱ�Ӽ�����
	public double getSubtotal() {
		return count * product.getShop_price();
	}
}
