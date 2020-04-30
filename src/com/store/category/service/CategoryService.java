package com.store.category.service;

import java.util.List;

import com.store.category.domain.Category;

/**
 * һ������ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface CategoryService {

	//��ѯ����һ������
	public List<Category> findAll();

	//���һ������
	public void save(Category category);

	//����id��ѯ
	public Category findByCid(Integer cid);
	
	//ɾ��һ������
	public void delete(Category category);

	//�༭һ������
	public void edit(Category category);

}
