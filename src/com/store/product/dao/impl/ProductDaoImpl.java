package com.store.product.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.store.product.dao.ProductDao;
import com.store.product.domain.Product;
import com.store.product.domain.Review;
import com.store.utils.PageHibernateCallback;

/**
 * 商品类持久层
 * @author dhw
 *
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	//查询热门商品
	public List<Product> findHot() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//设置查询条件
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		//查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	//查询最新商品
	public List<Product> findNew() {
		//使用离线查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//设置查询条件
		criteria.addOrder(Order.desc("pdate"));
		//查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	//根据id查询商品
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//根据一级分类id查询商品个数
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据一级分类id查询商品
	public List<Product> findByPageCid(Integer cid, int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid= ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//根据二级分类id查询商品个数
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据二级分类id查询商品
	public List<Product> findByPageCsid(Integer csid, int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//查询相关商品
	public List<Product> findRelate(Integer csid, Integer pid,int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ? and p.pid != ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid,pid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//统计所有商品数量
	public int totalCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//查询所有商品
	public List<Product> findAll(int startIndex, int limit) {
		String hql = "from Product";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//添加
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	//删除
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	//编辑
	public void edit(Product product) {
		this.getHibernateTemplate().update(product);	
	}

	//添加评论
	public void addReview(Review review) {
		this.getHibernateTemplate().save(review);
	}

	//根据关键字统计符合的商品数目
	public int findCountByKey(String searchkey) {
		String hql = "select count(*) from Product where 1=1";
		List<Long> list = null;
		if(!"".equals(searchkey.trim())) {
			hql += " and pname like ?";
			list = this.getHibernateTemplate().find(hql,"%"+searchkey.trim()+"%");
		} else {
			list = this.getHibernateTemplate().find(hql);
		}
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//根据关键字查询商品
	public List<Product> findBySearchKey(String searchkey, int startIndex,
			int limit) {
		String hql = "from Product where 1=1";
		List<Product> list = null;
		//判断关键字是否为空
		if(!"".equals(searchkey.trim())) {
			hql += " and pname like ?";
			String s = "%"+searchkey.trim()+"%";
			list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{s}, startIndex, limit));
		} else {
			list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{}, startIndex, limit));	
		}	
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

}
