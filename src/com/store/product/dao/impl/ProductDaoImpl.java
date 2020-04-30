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
 * ��Ʒ��־ò�
 * @author dhw
 *
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	//��ѯ������Ʒ
	public List<Product> findHot() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//���ò�ѯ����
		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.addOrder(Order.desc("pdate"));
		//��ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	//��ѯ������Ʒ
	public List<Product> findNew() {
		//ʹ�����߲�ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//���ò�ѯ����
		criteria.addOrder(Order.desc("pdate"));
		//��ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	//����id��ѯ��Ʒ
	public Product findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}

	//����һ������id��ѯ��Ʒ����
	public int findCountCid(Integer cid) {
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//����һ������id��ѯ��Ʒ
	public List<Product> findByPageCid(Integer cid, int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid= ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//���ݶ�������id��ѯ��Ʒ����
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql,csid);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//���ݶ�������id��ѯ��Ʒ
	public List<Product> findByPageCsid(Integer csid, int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//��ѯ�����Ʒ
	public List<Product> findRelate(Integer csid, Integer pid,int startIndex, int limit) {
		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ? and p.pid != ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid,pid}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//ͳ��������Ʒ����
	public int totalCount() {
		String hql = "select count(*) from Product";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	//��ѯ������Ʒ
	public List<Product> findAll(int startIndex, int limit) {
		String hql = "from Product";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{}, startIndex, limit));
		if(list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	//���
	public void save(Product product) {
		this.getHibernateTemplate().save(product);
	}

	//ɾ��
	public void delete(Product product) {
		this.getHibernateTemplate().delete(product);
	}

	//�༭
	public void edit(Product product) {
		this.getHibernateTemplate().update(product);	
	}

	//�������
	public void addReview(Review review) {
		this.getHibernateTemplate().save(review);
	}

	//���ݹؼ���ͳ�Ʒ��ϵ���Ʒ��Ŀ
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

	//���ݹؼ��ֲ�ѯ��Ʒ
	public List<Product> findBySearchKey(String searchkey, int startIndex,
			int limit) {
		String hql = "from Product where 1=1";
		List<Product> list = null;
		//�жϹؼ����Ƿ�Ϊ��
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
