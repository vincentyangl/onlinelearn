package com.bean;

import java.util.Date;

public class EduTeacher {

	private int id;//教师ID
	private String name;//教师名称
//	private String thName;//老师账号
//	private String thPw;//老师密码
	private String education;//教师资历
	private String career;//教师简介
	private int isStar;//头衔,1高级讲师,0首席讲师
	private String picPath;//图片路径
//	private String status;//状态
	private Date createTime;//创建时间
	private Date updateTime;//更新时间
	private SysSubject sysSubject;//专业ID
	private int sort;//排序
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	public SysSubject getSysSubject() {
		return sysSubject;
	}
	public void setSysSubject(SysSubject sysSubject) {
		this.sysSubject = sysSubject;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
//	public String getThName() {
//		return thName;
//	}
//	public void setThName(String thName) {
//		this.thName = thName;
//	}
//	public String getThPw() {
//		return thPw;
//	}
//	public void setThPw(String thPw) {
//		this.thPw = thPw;
//	}
	public int getIsStar() {
		return isStar;
	}
	public void setIsStar(int isStar) {
		this.isStar = isStar;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
