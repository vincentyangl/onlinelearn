package com.bean;

import java.util.Date;

public class Edu_Questions_Comment {
private int id;        //����id
private int cusId;        //������id
private int questionId;     //�ʴ�id
private String content;      //��������
private int isBest;        //�Ƿ���Ѵ� 0��1��
private int replyCount;     //�ظ�����
private int praiseCount;     //������
private String addTime;      //�ظ�ʱ��
private int commentId;      //��������id
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCusId() {
	return cusId;
}
public void setCusId(int cusId) {
	this.cusId = cusId;
}
public int getQuestionId() {
	return questionId;
}
public void setQuestionId(int questionId) {
	this.questionId = questionId;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getIsBest() {
	return isBest;
}
public void setIsBest(int isBest) {
	this.isBest = isBest;
}
public int getReplyCount() {
	return replyCount;
}
public void setReplyCount(int replyCount) {
	this.replyCount = replyCount;
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
public int getCommentId() {
	return commentId;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
@Override
public String toString() {
	return "Edu_Questions_Comment [id=" + id + ", cusId=" + cusId + ", questionId=" + questionId + ", content="
			+ content + ", isBest=" + isBest + ", replyCount=" + replyCount + ", praiseCount=" + praiseCount
			+ ", addTime=" + addTime + ", commentId=" + commentId + "]";
}


}
