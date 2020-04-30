package com.store.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.product.domain.Product;
import com.store.user.dao.UserDao;
import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.utils.PageHibernateCallback;


/**
 * 用户层模块持久层
 * @author dhw
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	//根据用户名查询用户信息
	public User findByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql,username);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	//添加用户信息
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	//根据激活码查询用户
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql,code);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//修改用户信息
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	//根据用户名密码查询用户
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//收藏商品
	public void addWishlist(Wishlist wishlist) {
		this.getHibernateTemplate().save(wishlist);
	}
	
	//根据商品id和用户id查询收藏对象
	public Wishlist findWishlist(Integer uid, Integer pid) {
		String hql = "from Wishlist where uid = ? and pid = ?";
		List<Wishlist> list = this.getHibernateTemplate().find(hql,uid,pid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//根据用户id统计收藏商品数
	public int findCountLikeByUid(Integer uid) {
		String hql = "select count(*) from Wishlist w where w.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据用户id查询收藏
	public List<Wishlist> findLikeByUid(Integer uid, int startIndex, int limit) {
		String hql = "select w from Wishlist w where w.user.uid= ?";
		List<Wishlist> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Wishlist>(hql, new Object[]{uid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//取消收藏
	public void cancelLike(Wishlist wishlist) {
		this.getHibernateTemplate().delete(wishlist);
	}

	//统计用户数量
	public int totalCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//查询所有
	public List<User> findAll(int startIndex, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//查询
	public User findByUid(Integer uid) {
		String hql = "from User where uid = ?";
		List<User> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//删除
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}
	
}
