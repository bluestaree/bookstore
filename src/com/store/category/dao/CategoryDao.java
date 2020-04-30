package com.store.category.dao;

import java.util.List;

import com.store.category.domain.Category;

/**
 * 一级分类的持久层接口规范
 * @author dhw
 *
 */
public interface CategoryDao {

	//查询所有
	public List<Category> findAll();

	//添加
	public void save(Category category);

	//查询
	public Category findByCid(Integer cid);

	//删除
	public void delete(Category category);

	//编辑
	public void edit(Category category);

}
