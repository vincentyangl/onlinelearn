package com.bean;

import java.util.Date;

public class EduTeacher {

	private int id;//��ʦID
	private String name;//��ʦ����
//	private String thName;//��ʦ�˺�
//	private String thPw;//��ʦ����
	private String education;//��ʦ����
	private String career;//��ʦ���
	private int isStar;//ͷ��,1�߼���ʦ,0��ϯ��ʦ
	private String picPath;//ͼƬ·��
//	private String status;//״̬
	private Date createTime;//����ʱ��
	private Date updateTime;//����ʱ��
	private SysSubject sysSubject;//רҵID
	private int sort;//����
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
