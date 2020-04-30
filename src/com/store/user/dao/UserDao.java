package com.store.user.dao;

import java.util.List;

import com.store.user.domain.User;
import com.store.user.domain.Wishlist;

/**
 * 用户模块持久层接口规范
 * @author dhw
 *
 */
public interface UserDao {

	//根据用户名查询用户信息
	public User findByUsername(String username);
	
	//添加用户信息
	public void save(User user);

	//根据激活码查询用户
	public User findByCode(String code);

	//修改用户信息
	public void update(User user);

	//根据用户名密码查询用户
	public User login(User user);

	//收藏商品
	public void addWishlist(Wishlist wishlist);

	//根据商品id和用户id查询收藏对象
	public Wishlist findWishlist(Integer uid, Integer pid);

	//根据用户id统计收藏商品数
	public int findCountLikeByUid(Integer uid);

	//根据用户id查询收藏
	public List<Wishlist> findLikeByUid(Integer uid, int startIndex, int limit);

	//取消收藏
	public void cancelLike(Wishlist wishlist);

	//统计用户数量
	public int totalCount();

	//查询所有
	public List<User> findAll(int startIndex, int limit);

	//查询
	public User findByUid(Integer uid);

	//删除
	public void delete(User user);
}
