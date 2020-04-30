package com.store.user.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.product.domain.Product;
import com.store.user.dao.UserDao;
import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.utils.PageHibernateCallback;


/**
 * �û���ģ��־ò�
 * @author dhw
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	//�����û�����ѯ�û���Ϣ
	public User findByUsername(String username) {
		String hql = "from User where username = ?";
		List<User> list = this.getHibernateTemplate().find(hql,username);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	//����û���Ϣ
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	//���ݼ������ѯ�û�
	public User findByCode(String code) {
		String hql = "from User where code = ?";
		List<User> list = this.getHibernateTemplate().find(hql,code);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//�޸��û���Ϣ
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	//�����û��������ѯ�û�
	public User login(User user) {
		String hql = "from User where username = ? and password = ? and state = ?";
		List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//�ղ���Ʒ
	public void addWishlist(Wishlist wishlist) {
		this.getHibernateTemplate().save(wishlist);
	}
	
	//������Ʒid���û�id��ѯ�ղض���
	public Wishlist findWishlist(Integer uid, Integer pid) {
		String hql = "from Wishlist where uid = ? and pid = ?";
		List<Wishlist> list = this.getHibernateTemplate().find(hql,uid,pid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//�����û�idͳ���ղ���Ʒ��
	public int findCountLikeByUid(Integer uid) {
		String hql = "select count(*) from Wishlist w where w.user.uid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//�����û�id��ѯ�ղ�
	public List<Wishlist> findLikeByUid(Integer uid, int startIndex, int limit) {
		String hql = "select w from Wishlist w where w.user.uid= ?";
		List<Wishlist> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Wishlist>(hql, new Object[]{uid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//ȡ���ղ�
	public void cancelLike(Wishlist wishlist) {
		this.getHibernateTemplate().delete(wishlist);
	}

	//ͳ���û�����
	public int totalCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ѯ����
	public List<User> findAll(int startIndex, int limit) {
		String hql = "from User";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//��ѯ
	public User findByUid(Integer uid) {
		String hql = "from User where uid = ?";
		List<User> list = this.getHibernateTemplate().find(hql,uid);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	//ɾ��
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}
	
}
