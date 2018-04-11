package com.bean;

import java.util.Date;

public class Edu_Questions_Comment {
private int id;        //主键id
private int cusId;        //评论人id
private int questionId;     //问答id
private String content;      //评论内容
private int isBest;        //是否最佳答案 0否1是
private int replyCount;     //回复数量
private int praiseCount;     //点赞数
private String addTime;      //回复时间
private int commentId;      //父级评论id
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
