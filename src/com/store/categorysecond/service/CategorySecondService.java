package com.store.categorysecond.service;

import java.util.List;

import com.store.categorysecond.domain.CategorySecond;
import com.store.utils.PageBean;

/**
 * 二级分类业务层接口规范
 * @author dhw
 *
 */
public interface CategorySecondService {
	
	//查询所有带分页
	public PageBean<CategorySecond> findAll(int page);

	//添加二级分类
	public void save(CategorySecond categorySecond);

	//查询二级分类
	public CategorySecond findByCsid(Integer csid);

	//删除二级分类
	public void delete(CategorySecond categorySecond);

	//编辑二级分类
	public void edit(CategorySecond categorySecond);

	//查询所有
	public List<CategorySecond> findAll();

}
