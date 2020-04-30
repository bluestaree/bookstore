package com.store.utils;

import java.util.List;

/**
 * ��ҳ���ܵ�ʵ����
 * @author Administrator
 *
 */
public class PageBean<T> {
	
	//1.������
	private int page;		//��ǰҳ
	private int limit;		//ÿҳ��ʾ��Ϣ����
	private int totalCount;		//�ܼ�¼��
	
	//2.������
	private int startIndex;		//��ҳ��ѯ�Ŀ�ʼ����
	private int totalPage;		//��ҳ��
	
	//3.����
	private List<T> list;		//��װÿҳ���ݵļ���
	
	//4.��̬��ʾ��
	private int start;
	private int end;
	
	//����һЩ��������,ͨ�����캯������,���������Ҫ�����������
	public PageBean(int page, int limit, int totalCount) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalCount = totalCount;
		//���㿪ʼ����
		this.startIndex = (this.page - 1) * this.limit;
		//�����ܷ�ҳ��(����ҳ˼��)ԭ��:java����,�Զ�����ȡ��
		this.totalPage = (this.totalCount + this.limit - 1)/this.limit;
		
		//4.1��ʼ������(��ʾ10��ҳ�水ť)
		this.start = 1;
		this.end = 10;
		//4.2�ж�.���ݷ�ҳ��ȷ��Ҫ��ʾ��ҳ�뷶Χ
		if(this.totalPage < 10) {
			this.end = this.totalPage;
		} else {	//��ҳ������10
			//��ʾ�����ַ�Χ(��ǰҳ����ʾ��������,��ǰ����ʾ5�����֣��ں����ʾ4����,��10����)
			this.start = this.page - 5; 
			this.end = this.page + 4;
			//�жϼ�������µ�������ʾ��Χ
			if(this.start < 1) {
				this.start = 1;
				this.end = 10;
			} 
			if(this.end > this.totalPage) {
				this.end = this.totalPage;
				this.start = this.totalPage - 9;
			}
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
}
