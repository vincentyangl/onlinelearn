package com.bean;

import java.util.List;

public class SysSubject {

	private int subjectId;//主键
	private String subjectName;//专业名称
	private int status;//状态 0:默认 1:删除
	private String createTime;//创建时间
	private int parentId;//父ID
	private int sort;//排序字段
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
