package com.bean;

import java.util.List;

public class SysSubject {

	private int subjectId;//����
	private String subjectName;//רҵ����
	private int status;//״̬ 0:Ĭ�� 1:ɾ��
	private String createTime;//����ʱ��
	private int parentId;//��ID
	private int sort;//�����ֶ�
	private List<SysSubject> sysSubjects;
	
	public List<SysSubject> getSysSubjects() {
		return sysSubjects;
	}
	public void setSysSubjects(List<SysSubject> sysSubjects) {
		this.sysSubjects = sysSubjects;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "SysSubject [subjectId=" + subjectId + ", subjectName=" + subjectName + ", status=" + status
				+ ", createTime=" + createTime + ", parent_id=" + parentId + ", sort=" + sort + "]";
	}
	
}
