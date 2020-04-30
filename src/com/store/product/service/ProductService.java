package com.store.product.service;

import java.util.List;

import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.utils.PageBean;

/**
 * 商品模块业务层接口规范
 * @author dhw
 *
 */
public interface ProductService {

	//查询热门商品
	public List<Product> findHot();

	//查询最新商品
	public List<Product> findNew();

	//根据id查询商品
	public Product findByPid(Integer pid);

	//根据一级分类查询商品带分页
	public PageBean<Product> findByPageCid(Integer cid, int page, int limit);

	//根据二级分类查询商品带分页
	public PageBean<Product> findByPageCsid(Integer csid, int page, int limit);

	//查询相关的商品
	public PageBean<Product> findRelate(Integer csid, Integer pid,int page, int limit);

	//查询所有商品
	public PageBean<Product> findAll(int page, int limit);

	//添加商品
	public void save(Product product);

	//删除商品
	public void delete(Product product);

	//编辑商品
	public void edit(Product product);

	//添加评论
	public void addReview(Review review);

	//根据关键字搜索商品
	public PageBean<Product> finBySearchKey(String searchkey, int page, int limit);

}
