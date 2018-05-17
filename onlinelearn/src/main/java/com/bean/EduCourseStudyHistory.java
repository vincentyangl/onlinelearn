package com.bean;

import java.util.Date;

public class EduCourseStudyHistory { //学员课程播放记录

	private int id;
	private Edu_User user;
	private EduCourse eduCourse;
	private EduKpoint eduKpoint;
	private int playerCount;
	private String courseName;
	private String kpointName;
	private Date dateBack;
	private Date updateTime;
	private int num;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Edu_User getUser() {
		return user;
	}
	public void setUser(Edu_User user) {
		this.user = user;
	}
	public EduCourse getEduCourse() {
		return eduCourse;
	}
	public void setEduCourse(EduCourse eduCourse) {
		this.eduCourse = eduCourse;
	}
	public EduKpoint getEduKpoint() {
		return eduKpoint;
	}
	public void setEduKpoint(EduKpoint eduKpoint) {
		this.eduKpoint = eduKpoint;
	}
	public int getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(int playerCount) {
		this.playerCount = playerCount;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getKpointName() {
		return kpointName;
	}
	public void setKpointName(String kpointName) {
		this.kpointName = kpointName;
	}
	public Date getDateBack() {
		return dateBack;
	}
	public void setDateBack(Date dateBack) {
		this.dateBack = dateBack;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
