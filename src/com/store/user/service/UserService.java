package com.store.user.service;

import com.store.user.domain.User;
import com.store.user.domain.Wishlist;
import com.store.utils.PageBean;

/**
 * �û�ģ��ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface UserService {
	
	//�����û�����ѯ�û���Ϣ
	public User findByUsername(String username);
	
	//����û���Ϣ
	public void save(User user);

	//���ݼ������ѯ�û�
	public User findByCode(String code);

	//�޸��û���Ϣ
	public void update(User user);

	//�û���¼
	public User login(User user);

	//�ղ���Ʒ
	public void addWishlist(Wishlist wishlist);

	//������Ʒid���û�id��ѯ�ղض���
	public Wishlist findWishlist(Integer uid, Integer pid);

	//�����û�id��ѯ�ղ�
	public PageBean<Wishlist> findLikeByUid(Integer uid, int page,int limit);

	//ȡ���ղ�
	public void cancelLike(Wishlist wishlist);

	//��ѯ����
	public PageBean<User> findAll(int page);

	//���
	public void addUser(User user);

	//��ѯ
	public User findByUid(Integer uid);

	//ɾ��
	public void delete(User user);
}
