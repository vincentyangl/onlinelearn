package com.bean;

import java.util.Date;

public class EduCourseFavorites {

	private int id;//�ղ�ID
	private EduCourse eduCourse;//�ղصĿγ�
	private Edu_User user;//�ղص�ѧԱ
	private Date addTime;//�ղ�ʱ��
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
