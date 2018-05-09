package com.bean;

import java.io.Serializable;

public class PageCourseBean implements Serializable{

	 private static final long serialVersionUID = 1L;
	 //��ǰҳ
	 private int currentPage;
	 //��ǰҳ����
	 private int pageSize = 12;
	 //�����ܸ���
	 private long totalResultSize;
	 //��ҳ��
	 private int totalPageSize;
	 private boolean first = false;
	 private boolean last = false;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalResultSize() {
		return totalResultSize;
	}
	public void setTotalResultSize(long totalResultSize) {
		this.totalResultSize = totalResultSize;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public boolean isFirst() {
		return first;
	}
	public void setFirst(boolean first) {
		this.first = first;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	
	
	
}
