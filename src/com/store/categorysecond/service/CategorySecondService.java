package com.store.categorysecond.service;

import java.util.List;

import com.store.categorysecond.domain.CategorySecond;
import com.store.utils.PageBean;

/**
 * ��������ҵ���ӿڹ淶
 * @author dhw
 *
 */
public interface CategorySecondService {
	
	//��ѯ���д���ҳ
	public PageBean<CategorySecond> findAll(int page);

	//��Ӷ�������
	public void save(CategorySecond categorySecond);

	//��ѯ��������
	public CategorySecond findByCsid(Integer csid);

	//ɾ����������
	public void delete(CategorySecond categorySecond);

	//�༭��������
	public void edit(CategorySecond categorySecond);

	//��ѯ����
	public List<CategorySecond> findAll();

}
