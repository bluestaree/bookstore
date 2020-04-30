package com.store.product.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.product.dao.ProductDao;
import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.product.service.ProductService;
import com.store.utils.PageBean;

/**
 * ��Ʒģ��ҵ���
 * @author dhw
 *
 */
@Transactional
public class ProductServiceImpl implements ProductService {
	
	//ע��productDao
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//��ѯ������Ʒ
	public List<Product> findHot() {
		return productDao.findHot();
	}

	//��ѯ������Ʒ
	public List<Product> findNew() {
		return productDao.findNew();
	}

	//����id��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	//����һ�������ѯ����ҳ
	public PageBean<Product> findByPageCid(Integer cid, int page ,int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.findCountCid(cid);
		//����pagebeanʵ������
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Product> list = productDao.findByPageCid(cid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//���ݶ��������ѯ��Ʒ����ҳ
	public PageBean<Product> findByPageCsid(Integer csid, int page ,int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.findCountCsid(csid);
		//����pagebeanʵ������
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Product> list = productDao.findByPageCsid(csid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//��ѯ��ص���Ʒ
	public PageBean<Product> findRelate(Integer csid, Integer pid,int page, int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.findCountCsid(csid) - 1;
		//����pagebeanʵ������
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Product> list = productDao.findRelate(csid,pid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//��ѯ������Ʒ
	public PageBean<Product> findAll(int page, int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.totalCount();
		//����pagebeanʵ������
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Product> list = productDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//�����Ʒ
	public void save(Product product) {
		productDao.save(product);
	}

	//ɾ����Ʒ
	public void delete(Product product) {
		productDao.delete(product);
	}

	//�༭��Ʒ
	public void edit(Product product) {
		productDao.edit(product);
	}

	//�������
	public void addReview(Review review) {
		productDao.addReview(review);
	}

	//���ݹؼ���������Ʒ
	public PageBean<Product> finBySearchKey(String searchkey, int page,
			int limit) {
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = productDao.findCountByKey(searchkey);
		//����pagebeanʵ������
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<Product> list = productDao.findBySearchKey(searchkey,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

}
