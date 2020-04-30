package com.store.product.dao;

import java.util.List;

import com.store.product.domain.Product;
import com.store.product.domain.Review;

/**
 * ��Ʒģ��־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface ProductDao {

	//��ѯ������Ʒ
	public List<Product> findHot();

	//��ѯ������Ʒ
	public List<Product> findNew();

	//����id��ѯ��Ʒ
	public Product findByPid(Integer pid);

	//����һ������id��ѯ��Ʒ����
	public int findCountCid(Integer cid);

	//����һ������id��ѯ��Ʒ
	public List<Product> findByPageCid(Integer cid, int startIndex, int limit);

	//���ݶ�������id��ѯ��Ʒ����
	public int findCountCsid(Integer csid);

	//���ݶ�������id��ѯ��Ʒ
	public List<Product> findByPageCsid(Integer csid, int startIndex, int limit);

	//��ѯ�����Ʒ
	public List<Product> findRelate(Integer csid,Integer pid, int startIndex, int limit);

	//ͳ��������Ʒ��Ŀ
	public int totalCount();

	//��ѯ������Ʒ
	public List<Product> findAll(int startIndex, int limit);

	//���
	public void save(Product product);

	//ɾ��
	public void delete(Product product);

	//�༭
	public void edit(Product product);

	//�������
	public void addReview(Review review);

	//���ݹؼ���ͳ�Ʒ��ϵ���Ʒ��Ŀ
	public int findCountByKey(String searchkey);

	//���ݹؼ��ֲ�ѯ��Ʒ
	public List<Product> findBySearchKey(String searchkey, int startIndex,
			int limit);


}
