package com.store.categorysecond.dao;

import java.util.List;

import com.store.categorysecond.domain.CategorySecond;

/**
 * ��������־ò�ӿڹ淶
 * @author dhw
 *
 */
public interface CategorySecondDao {

	//ͳ�Ƹ���
	public int findCount();

	//��ѯ���д���ҳ
	public List<CategorySecond> findAll(int startIndex, int limit);

	//���
	public void save(CategorySecond categorySecond);

	//��ѯ
	public CategorySecond findByCsid(Integer csid);

	//ɾ��
	public void delete(CategorySecond categorySecond);

	//�༭
	public void edit(CategorySecond categorySecond);

	//��ѯ����
	public List<CategorySecond> findAll();

}
