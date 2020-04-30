package com.store.product.service;

import java.util.List;

import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.utils.PageBean;

/**
 * ��Ʒģ��ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface ProductService {

	//��ѯ������Ʒ
	public List<Product> findHot();

	//��ѯ������Ʒ
	public List<Product> findNew();

	//����id��ѯ��Ʒ
	public Product findByPid(Integer pid);

	//����һ�������ѯ��Ʒ����ҳ
	public PageBean<Product> findByPageCid(Integer cid, int page, int limit);

	//���ݶ��������ѯ��Ʒ����ҳ
	public PageBean<Product> findByPageCsid(Integer csid, int page, int limit);

	//��ѯ��ص���Ʒ
	public PageBean<Product> findRelate(Integer csid, Integer pid,int page, int limit);

	//��ѯ������Ʒ
	public PageBean<Product> findAll(int page, int limit);

	//�����Ʒ
	public void save(Product product);

	//ɾ����Ʒ
	public void delete(Product product);

	//�༭��Ʒ
	public void edit(Product product);

	//�������
	public void addReview(Review review);

	//���ݹؼ���������Ʒ
	public PageBean<Product> finBySearchKey(String searchkey, int page, int limit);

}
