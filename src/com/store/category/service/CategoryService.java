package com.store.category.service;

import java.util.List;

import com.store.category.domain.Category;

/**
 * 一级分类业务层接口规范
 * @author dhw
 *
 */
public interface CategoryService {

	//查询所有一级分类
	public List<Category> findAll();

	//添加一级分类
	public void save(Category category);

	//根据id查询
	public Category findByCid(Integer cid);
	
	//删除一级分类
	public void delete(Category category);

	//编辑一级分类
	public void edit(Category category);

}
