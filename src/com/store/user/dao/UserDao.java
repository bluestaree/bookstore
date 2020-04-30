package com.store.user.dao;

import java.util.List;

import com.store.user.domain.User;
import com.store.user.domain.Wishlist;

/**
 * �û�ģ��־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface UserDao {

	//�����û�����ѯ�û���Ϣ
	public User findByUsername(String username);
	
	//����û���Ϣ
	public void save(User user);

	//���ݼ������ѯ�û�
	public User findByCode(String code);

	//�޸��û���Ϣ
	public void update(User user);

	//�����û��������ѯ�û�
	public User login(User user);

	//�ղ���Ʒ
	public void addWishlist(Wishlist wishlist);

	//������Ʒid���û�id��ѯ�ղض���
	public Wishlist findWishlist(Integer uid, Integer pid);

	//�����û�idͳ���ղ���Ʒ��
	public int findCountLikeByUid(Integer uid);

	//�����û�id��ѯ�ղ�
	public List<Wishlist> findLikeByUid(Integer uid, int startIndex, int limit);

	//ȡ���ղ�
	public void cancelLike(Wishlist wishlist);

	//ͳ���û�����
	public int totalCount();

	//��ѯ����
	public List<User> findAll(int startIndex, int limit);

	//��ѯ
	public User findByUid(Integer uid);

	//ɾ��
	public void delete(User user);
}
