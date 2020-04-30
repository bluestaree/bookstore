package com.store.product.dao;

import java.util.List;

import com.store.product.domain.Product;
import com.store.product.domain.Review;

/**
 * 商品模块持久层接口规范
 * @author dhw
 *
 */
public interface ProductDao {

	//查询热门商品
	public List<Product> findHot();

	//查询最新商品
	public List<Product> findNew();

	//根据id查询商品
	public Product findByPid(Integer pid);

	//根据一级分类id查询商品个数
	public int findCountCid(Integer cid);

	//根据一级分类id查询商品
	public List<Product> findByPageCid(Integer cid, int startIndex, int limit);

	//根据二级分类id查询商品个数
	public int findCountCsid(Integer csid);

	//根据二级分类id查询商品
	public List<Product> findByPageCsid(Integer csid, int startIndex, int limit);

	//查询相关商品
	public List<Product> findRelate(Integer csid,Integer pid, int startIndex, int limit);

	//统计所有商品数目
	public int totalCount();

	//查询所有商品
	public List<Product> findAll(int startIndex, int limit);

	//添加
	public void save(Product product);

	//删除
	public void delete(Product product);

	//编辑
	public void edit(Product product);

	//添加评论
	public void addReview(Review review);

	//根据关键字统计符合的商品数目
	public int findCountByKey(String searchkey);

	//根据关键字查询商品
	public List<Product> findBySearchKey(String searchkey, int startIndex,
			int limit);


}
