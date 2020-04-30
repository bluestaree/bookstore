package com.store.category.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.category.dao.CategoryDao;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;

/**
 * һ������ҵ���
 * @author dhw
 *
 */
@Transactional
public class CategoryServiceImpl implements CategoryService {
	//ע��categorayDao
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//��ѯ����һ������
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	//���һ������
	public void save(Category category) {
		categoryDao.save(category);
	}

	//����id��ѯ
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	//ɾ��һ������
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	//�༭һ������
	public void edit(Category category) {
		categoryDao.edit(category);
	}

}
