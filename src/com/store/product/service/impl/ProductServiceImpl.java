package com.store.product.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.store.product.dao.ProductDao;
import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.product.service.ProductService;
import com.store.utils.PageBean;

/**
 * 商品模块业务层
 * @author dhw
 *
 */
@Transactional
public class ProductServiceImpl implements ProductService {
	
	//注入productDao
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//查询热门商品
	public List<Product> findHot() {
		return productDao.findHot();
	}

	//查询最新商品
	public List<Product> findNew() {
		return productDao.findNew();
	}

	//根据id查询商品
	public Product findByPid(Integer pid) {
		return productDao.findByPid(pid);
	}

	//根据一级分类查询带分页
	public PageBean<Product> findByPageCid(Integer cid, int page ,int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = productDao.findCountCid(cid);
		//创建pagebean实例对象
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//查询商品集合
		List<Product> list = productDao.findByPageCid(cid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	//根据二级分类查询商品带分页
	public PageBean<Product> findByPageCsid(Integer csid, int page ,int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = productDao.findCountCsid(csid);
		//创建pagebean实例对象
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//查询商品集合
		List<Product> list = productDao.findByPageCsid(csid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//查询相关的商品
	public PageBean<Product> findRelate(Integer csid, Integer pid,int page, int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = productDao.findCountCsid(csid) - 1;
		//创建pagebean实例对象
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//查询商品集合
		List<Product> list = productDao.findRelate(csid,pid,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//查询所有商品
	public PageBean<Product> findAll(int page, int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = productDao.totalCount();
		//创建pagebean实例对象
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//查询商品集合
		List<Product> list = productDao.findAll(pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

	//添加商品
	public void save(Product product) {
		productDao.save(product);
	}

	//删除商品
	public void delete(Product product) {
		productDao.delete(product);
	}

	//编辑商品
	public void edit(Product product) {
		productDao.edit(product);
	}

	//添加评论
	public void addReview(Review review) {
		productDao.addReview(review);
	}

	//根据关键字搜索商品
	public PageBean<Product> finBySearchKey(String searchkey, int page,
			int limit) {
		//设置总记录数
		int totalCount = 0 ;
		totalCount = productDao.findCountByKey(searchkey);
		//创建pagebean实例对象
		PageBean<Product> pageBean = new PageBean<Product>(page, limit, totalCount);
		//查询商品集合
		List<Product> list = productDao.findBySearchKey(searchkey,pageBean.getStartIndex(),limit);
		pageBean.setList(list);
		return pageBean;
	}

}
