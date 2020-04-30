package com.store.cart.domain;

import com.store.product.domain.Product;


/**
 * 购物项对象
 * @author dhw
 *
 */
public class CartItem {
	private Product product;	// 购物项中商品的信息
	private int count;			// 记录购物项中商品的数量
	private double subtotal;	// 记录该购物项的小计
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
	// 小计：直接计算获得
	public double getSubtotal() {
		return count * product.getShop_price();
	}
}
