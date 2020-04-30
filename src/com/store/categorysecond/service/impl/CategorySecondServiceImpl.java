package com.store.categorysecond.service.impl;

import java.util.List;

import com.store.categorysecond.dao.CategorySecondDao;
import com.store.categorysecond.domain.CategorySecond;
import com.store.categorysecond.service.CategorySecondService;
import com.store.product.domain.Product;
import com.store.utils.PageBean;

/**
 * 二级分类业务层
 * @author dhw
 *
 */
public class CategorySecondServiceImpl implements CategorySecondService {

	//注入CategorySecondDao
	private CategorySecondDao categorySecondDao;
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}
	
	//查询所有带分页
	public PageBean<CategorySecond> findAll(int page) {
		//设置每页显示记录数
		int limit = 8;
		//设置总记录数
		int totalCount = 0 ;
		totalCount = categorySecondDao.findCount();
		//创建pagebean实例对象
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>(page, limit, totalCount);
		//查询商品集合
		List<CategorySecond> list = categorySecondDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//添加二级分类
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	//查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	//删除二级分类
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	//编辑二级分类
	public void edit(CategorySecond categorySecond) {
		categorySecondDao.edit(categorySecond);
	}

	//查询所有
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}
}
