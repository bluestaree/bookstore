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
 * �û�ģ��ҵ���
 * @author dhw
 *
 */
@Transactional
public class UserServiceImpl implements UserService {
	//ע��userDao
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//�����û�����ѯ�û���Ϣ
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	//����û���Ϣ
	public void save(User user) {
		// ������Ϣ
		user.setState(0); // ����״̬��  δ���� 
		String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();	//���ü�����
		user.setCode(code);
		userDao.save(user);
		//���ͼ����ʼ�
		MailUitls.sendMail(user.getEmail(), code);
	}

	//���ݼ������ѯ�û�
	public User findByCode(String code) {
		return userDao.findByCode(code);
	}

	//�޸��û���Ϣ
	public void update(User user) {
		userDao.update(user);
	}

	//�û���¼
	public User login(User user) {
		return userDao.login(user);
	}

	//�ղ���Ʒ
	public void addWishlist(Wishlist wishlist) {
		userDao.addWishlist(wishlist);
	}

	//������Ʒid���û�id��ѯ�ղض���
	public Wishlist findWishlist(Integer uid, Integer pid) {
		return userDao.findWishlist(uid,pid);
	}

	//�����û�id��ѯ�ղ�
	public PageBean<Wishlist> findLikeByUid(Integer uid, int page,int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = userDao.findCountLikeByUid(uid);
		//����pagebeanʵ������
		PageBean<Wishlist> pageBean = new PageBean<Wishlist>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Wishlist> list = userDao.findLikeByUid(uid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//ȡ���ղ�
	public void cancelLike(Wishlist wishlist) {
		userDao.cancelLike(wishlist);
	}

	//��ѯ����
	public PageBean<User> findAll(int page) {
		//����ÿҳ��ʾ��¼��
		int limit = 6;
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = userDao.totalCount();
		//����pagebeanʵ������
		PageBean<User> pageBean = new PageBean<User>(page, limit, totalCount);
		//��ѯ��Ʒ����ji
		List<User> list = userDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//��̨����û�
	public void addUser(User user) {
		userDao.save(user);
	}

	//��ѯ
	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}

	//ɾ��
	public void delete(User user) {
		userDao.delete(user);
	}


}
