package com.bean;

import java.util.List;

public class SysSubject {

	private int subjectId;//����
	private String subjectName;//רҵ����
	private int status;//״̬ 0:Ĭ�� 1:ɾ��
	private String createTime;//����ʱ��
	private int parent_id;//��ID
	private int sort;//�����ֶ�
	private List<SysSubject> sysSubjects;
	
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
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public List<SysSubject> getSysSubjects() {
		return sysSubjects;
	}
	public void setSysSubjects(List<SysSubject> sysSubjects) {
		this.sysSubjects = sysSubjects;
	}
	
	
}
