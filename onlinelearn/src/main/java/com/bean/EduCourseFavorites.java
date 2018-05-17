package com.bean;

import java.util.Date;

public class EduCourseFavorites {

	private int id;//收藏ID
	private EduCourse eduCourse;//收藏的课程
	private Edu_User user;//收藏的学员
	private Date addTime;//收藏时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public EduCourse getEduCourse() {
		return eduCourse;
	}
	public void setEduCourse(EduCourse eduCourse) {
		this.eduCourse = eduCourse;
	}
	public Edu_User getUser() {
		return user;
	}
	public void setUser(Edu_User user) {
		this.user = user;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	
}
