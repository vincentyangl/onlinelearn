package com.bean;

public class Edu_User {
private int userId;    //ѧԱID
private String mobile;   //�ֻ���
private String email;    //�����
private int classId;     //�༶���
private String password;    //����
private String userName;   //�û���
private String showName;   //��ʾ�� ���ǳƣ�
private int sex;         //�Ա�  1��  2Ů
private int age;        //����
private String createTime;   //ע��ʱ��
private int isAvalible;   //�Ƿ���� 1����  2����
private String picImg;      //�û�ͷ��
private String bannerUrl;    //���������û�����ͼƬ
private int msgNum;       //վ����δ����Ϣ��
private int sysMsgNum;   //
private String lastSystemTime;   //�ϴ�ͳ��ϵͳ��Ϣʱ��
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getClassId() {
	return classId;
}
public void setClassId(int classId) {
	this.classId = classId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getShowName() {
	return showName;
}
public void setShowName(String showName) {
	this.showName = showName;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public int getIsAvalible() {
	return isAvalible;
}
public void setIsAvalible(int isAvalible) {
	this.isAvalible = isAvalible;
}
public String getPicImg() {
	return picImg;
}
public void setPicImg(String picImg) {
	this.picImg = picImg;
}
public String getBannerUrl() {
	return bannerUrl;
}
public void setBannerUrl(String bannerUrl) {
	this.bannerUrl = bannerUrl;
}
public int getMsgNum() {
	return msgNum;
}
public void setMsgNum(int msgNum) {
	this.msgNum = msgNum;
}
public int getSysMsgNum() {
	return sysMsgNum;
}
public void setSysMsgNum(int sysMsgNum) {
	this.sysMsgNum = sysMsgNum;
}
public String getLastSystemTime() {
	return lastSystemTime;
}
public void setLastSystemTime(String lastSystemTime) {
	this.lastSystemTime = lastSystemTime;
}
@Override
public String toString() {
	return "Edu_User [userId=" + userId + ", mobile=" + mobile + ", email=" + email + ", classId=" + classId
			+ ", password=" + password + ", userName=" + userName + ", showName=" + showName + ", sex=" + sex + ", age="
			+ age + ", createTime=" + createTime + ", isAvalible=" + isAvalible + ", picImg=" + picImg + ", bannerUrl="
			+ bannerUrl + ", msgNum=" + msgNum + ", sysMsgNum=" + sysMsgNum + ", lastSystemTime=" + lastSystemTime
			+ "]";
}


}
