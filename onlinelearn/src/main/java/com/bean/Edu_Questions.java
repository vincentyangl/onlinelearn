package com.bean;



public class Edu_Questions {
private int id;   //����
private Edu_User edu_User;    //������id(����)
private String titie;    //�ʴ����
private String content;     //�ʴ�����
private int type;       //���� 1�γ��ʴ� 2 ѧϰ����
private int status;     //״̬ 0�ɻظ�1���ɻظ���������Ѵ𰸺��Ϊ1 �� 
private int replyCount;     //�ʴ�ظ�����
private int browseCount;     //�ʴ��������
private int praiseCount;      //�ʴ��������
private String addTime;        //����ʱ��
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
public String getTitie() {
	return titie;
}
public void setTitie(String titie) {
	this.titie = titie;
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
public String getAddTime() {
	return addTime;
}
public void setAddTime(String addTime) {
	this.addTime = addTime;
}
@Override
public String toString() {
	return "Edu_Questions [id=" + id + ", edu_User=" + edu_User + ", titie=" + titie + ", content=" + content
			+ ", type=" + type + ", status=" + status + ", replyCount=" + replyCount + ", browseCount=" + browseCount
			+ ", praiseCount=" + praiseCount + ", addTime=" + addTime + "]";
}

}