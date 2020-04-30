package com.store.categorysecond.dao;

import java.util.List;

import com.store.categorysecond.domain.CategorySecond;

/**
 * 二级分类持久层接口规范
 * @author dhw
 *
 */
public interface CategorySecondDao {

	//统计个数
	public int findCount();

	//查询所有带分页
	public List<CategorySecond> findAll(int startIndex, int limit);

	//添加
	public void save(CategorySecond categorySecond);

	//查询
	public CategorySecond findByCsid(Integer csid);

	//删除
	public void delete(CategorySecond categorySecond);

	//编辑
	public void edit(CategorySecond categorySecond);

	//查询所有
	public List<CategorySecond> findAll();

}
