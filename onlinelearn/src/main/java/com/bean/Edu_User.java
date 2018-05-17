package com.bean;

import java.util.Date;

public class Edu_User {

private int userId;    //学员ID
private String mobile;   //手机号
private String email;    //邮箱号
private Edu_class id;     //班级编号
private String password;    //密码
private String userName;   //用户名
private String showName;   //显示名 （昵称）
private int sex;         //性别  1男  2女
private int age;        //年龄
private Date createTime;   //注册时间
private int isAvalible;   //是否可用 1正常  2冻结
private String picImg;      //用户头像
private String bannerUrl;    //个人中心用户背景图片
private int msgNum;       //站内信未读消息数
private int sysMsgNum;   //
private Date lastSystemTime;   //上传统计系统消息时间
private int num;


public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
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
public Edu_class getId() {
	return id;
}
public void setId(Edu_class id) {
	this.id = id;
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

public int getIsAvalible() {
	return isAvalible;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
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
public Date getLastSystemTime() {
	return lastSystemTime;
}
public void setLastSystemTime(Date lastSystemTime) {
	this.lastSystemTime = lastSystemTime;
}




}
