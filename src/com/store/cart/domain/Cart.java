package com.store.cart.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author dhw
 *
 */
public class Cart implements Serializable{
	
	//封住购物项的集合
	//使用map方便增删 ，key为商品的id，value为购物项实体类 
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();

	// 提供一个map集合中value的get方法：方便取值遍历
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	// 购物车中的总金额
	private double total;

	public double getTotal() {
		return total;
	}
	//----------------------------------------
	// 购物车的功能:
	// 1.添加商品(购物项)
	public void addCart(CartItem cartItem) {
		// 判断购物车中是否已经存在该购物项:
		// 获得商品id.
		Integer pid = cartItem.getProduct().getPid();
		// 判断购物车中是否已经存在该购物项:
		if(map.containsKey(pid)){
			// 存在
			CartItem oldCartItem = map.get(pid);// 获得购物车中原来的购物项
			oldCartItem.setCount(oldCartItem.getCount()+cartItem.getCount());	//修改数量
		}else{
			// 不存在，直接添加
			map.put(pid, cartItem);
		}
		// 计算总金额
		total += cartItem.getSubtotal();
	}

	// 2.修改商品数量
	public void updateCart(Integer pid , int num) {
		// 获取
		CartItem cartItem = map.get(pid);
		// 先减去原先的小计
		total -=  cartItem.getSubtotal();
		// 修改数量
		cartItem.setCount(num);
		// 计算总金额
		total += cartItem.getSubtotal();
	}
	
	// 3.从购物车移除购物项
	public void removeCart(Integer pid) {
		// 将购物项移除购物车:
		CartItem cartItem = map.remove(pid);
		// 计算总金额
		total -= cartItem.getSubtotal();
	}

	// 4.清空购物车
	public void clearCart() {
		// 将所有购物项清空
		map.clear();
		// 将总计设置为0
		total = 0;
	}
}
