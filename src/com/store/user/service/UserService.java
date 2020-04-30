package com.store.user.service;

import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.utils.PageBean;

/**
 * 用户模块业务层接口规范
 * @author dhw
 *
 */
public interface UserService {
	
	//根据用户名查询用户信息
	public User findByUsername(String username);
	
	//添加用户信息
	public void save(User user);

	//根据激活吗查询用户
	public User findByCode(String code);

	//修改用户信息
	public void update(User user);

	//用户登录
	public User login(User user);

	//收藏商品
	public void addWishlist(Wishlist wishlist);

	//根据商品id和用户id查询收藏对象
	public Wishlist findWishlist(Integer uid, Integer pid);

	//根据用户id查询收藏
	public PageBean<Wishlist> findLikeByUid(Integer uid, int page,int limit);

	//取消收藏
	public void cancelLike(Wishlist wishlist);

	//查询所有
	public PageBean<User> findAll(int page);

	//添加
	public void addUser(User user);

	//查询
	public User findByUid(Integer uid);

	//删除
	public void delete(User user);
}
