package com.store.categorysecond.service.impl;

import java.util.List;

import com.store.categorysecond.dao.CategorySecondDao;
import com.store.categorysecond.domain.CategorySecond;
import com.store.categorysecond.service.CategorySecondService;
import com.store.product.domain.Product;
import com.store.utils.PageBean;

/**
 * ��������ҵ���
 * @author dhw
 *
 */
public class CategorySecondServiceImpl implements CategorySecondService {

	//ע��CategorySecondDao
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	//��ѯ���д���ҳ
	public PageBean<CategorySecond> findAll(int page) {
		//����ÿҳ��ʾ��¼��
		int limit = 8;
		//�����ܼ�¼��
		int totalCount = 0 ;
		totalCount = categorySecondDao.findCount();
		//����pagebeanʵ������
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>(page, limit, totalCount);
		//��ѯ��Ʒ����
		List<CategorySecond> list = categorySecondDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//��Ӷ�������
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	//��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	//ɾ����������
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//�༭��������
	public void edit(CategorySecond categorySecond) {
		categorySecondDao.edit(categorySecond);
	}

	//��ѯ����
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
