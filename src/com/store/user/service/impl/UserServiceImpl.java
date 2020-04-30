package com.store.user.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.product.domain.Product;
import com.store.user.dao.UserDao;
import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.user.service.UserService;
import com.store.utils.MailUitls;
import com.store.utils.PageBean;
import com.store.utils.UUIDUtils;

/**
 * 用户模块业务层
 * @author dhw
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	//注入userDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//根据用户名查询用户信息
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	//添加用户信息
	public void save(User user) {
		// 完善信息
		user.setState(0); // 设置状态码  未激活 
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();	//设置激活码
		user.setCode(code);
		userDao.save(user);
		//发送激活邮件
		MailUitls.sendMail(user.getEmail(), code);
	}

	//根据激活码查询用户
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	//修改用户信息
	public void update(User user) {
		userDao.update(user);
	}

	//用户登录
	public User login(User user) {
		return userDao.login(user);
	}

	//收藏商品
	public void addWishlist(Wishlist wishlist) {
		userDao.addWishlist(wishlist);
	}

	//根据商品id和用户id查询收藏对象
	public Wishlist findWishlist(Integer uid, Integer pid) {
		return userDao.findWishlist(uid,pid);
	}

	//根据用户id查询收藏
	public PageBean<Wishlist> findLikeByUid(Integer uid, int page,int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = userDao.findCountLikeByUid(uid);
		//创建pagebean实例对象
		PageBean<Wishlist> pageBean = new PageBean<Wishlist>(page, limit, totalCount);
		//查询商品集合
		List<Wishlist> list = userDao.findLikeByUid(uid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//取消收藏
	public void cancelLike(Wishlist wishlist) {
		userDao.cancelLike(wishlist);
	}

	//查询所有
	public PageBean<User> findAll(int page) {
		//设置每页显示记录数
		int limit = 6;
		//设置总记录数
		int totalCount = 0 ;
		totalCount = userDao.totalCount();
		//创建pagebean实例对象
		PageBean<User> pageBean = new PageBean<User>(page, limit, totalCount);
		//查询商品集合ji
		List<User> list = userDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//后台添加用户
	public void addUser(User user) {
		userDao.save(user);
	}

	//查询
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	//删除
	public void delete(User user) {
		userDao.delete(user);
	}


}
