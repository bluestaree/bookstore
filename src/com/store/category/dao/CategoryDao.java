package com.store.category.dao;

import java.util.List;

import com.store.category.domain.Category;

/**
 * һ������ĳ־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface CategoryDao {

	//��ѯ����
	public List<Category> findAll();

	//���
	public void save(Category category);

	//��ѯ
	public Category findByCid(Integer cid);

	//ɾ��
	public void delete(Category category);

	//�༭
	public void edit(Category category);

}
