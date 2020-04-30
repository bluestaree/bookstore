package com.store.category.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.category.dao.CategoryDao;
import com.store.category.domain.Category;
import com.store.category.service.CategoryService;

/**
 * 一级分类业务层
 * @author dhw
 *
 */
@Transactional
public class CategoryServiceImpl implements CategoryService {
	//注入categorayDao
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	//查询所有一级分类
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	//添加一级分类
	public void save(Category category) {
		categoryDao.save(category);
	}

	//根据id查询
	public Category findByCid(Integer cid) {
		return categoryDao.findByCid(cid);
	}

	//删除一级分类
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	//编辑一级分类
	public void edit(Category category) {
		categoryDao.edit(category);
	}

}
