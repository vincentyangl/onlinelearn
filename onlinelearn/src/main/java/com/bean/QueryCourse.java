package com.bean;

import java.util.Date;

public class QueryCourse {

	private int subjectId; // 专业班型
	private int teacherId; // 教师
	private String pageViewCount; //关注度浏览量
	private String addTime; //添加时间
	private String currentPrice; //价格
	private String courseName;
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getPageViewCount() {
		return pageViewCount;
	}
	public void setPageViewCount(String pageViewCount) {
		this.pageViewCount = pageViewCount;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	

	
	
}
