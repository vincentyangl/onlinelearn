package com.bean;

import java.sql.Timestamp;
import java.util.List;

public class Edu_Questions {
private int id;   //����
private Edu_User edu_User;    //������id(����)
private String title;    //�ʴ����
private String content;     //�ʴ�����
private int type;       //���� 1�γ��ʴ� 2 ѧϰ����
private int status;     //״̬ 0�ɻظ�1���ɻظ���������Ѵ𰸺��Ϊ1 �� 
private int replyCount;     //�ʴ�ظ�����
private int browseCount;     //�ʴ��������
private int praiseCount;      //�ʴ��������
private Timestamp addTime;        //���ʱ��
//private List<Edu_Questions_Tag> edu_Questions_Tag;
//public List<Edu_Questions_Tag> getEdu_Questions_Tag() {
//	return edu_Questions_Tag;
//}
//public void setEdu_Questions_Tag(List<Edu_Questions_Tag> edu_Questions_Tag) {
//	this.edu_Questions_Tag = edu_Questions_Tag;
//}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Edu_User getEdu_User() {
	return edu_User;
}
public void setEdu_User(Edu_User edu_User) {
	this.edu_User = edu_User;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getReplyCount() {
	return replyCount;
}
public void setReplyCount(int replyCount) {
	this.replyCount = replyCount;
}
public int getBrowseCount() {
	return browseCount;
}
public void setBrowseCount(int browseCount) {
	this.browseCount = browseCount;
}
public int getPraiseCount() {
	return praiseCount;
}
public void setPraiseCount(int praiseCount) {
	this.praiseCount = praiseCount;
}
public Timestamp getAddTime() {
	return addTime;
}
public void setAddTime(Timestamp addTime) {
	this.addTime = addTime;
}
@Override
public String toString() {
	return "Edu_Questions [id=" + id + ", edu_User=" + edu_User + ", title=" + title + ", content=" + content
			+ ", type=" + type + ", status=" + status + ", replyCount=" + replyCount + ", browseCount=" + browseCount
			+ ", praiseCount=" + praiseCount + ", addTime=" + addTime + "]";
}

}
