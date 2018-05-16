package com.bean;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Edu_Questions_Comment {
private int id;        //主键id
private Edu_User edu_User;        //评论人id
private Edu_Questions edu_Questions;     //问答id
private String content;      //评论内容
private int isBest;        //是否最佳答案 0否1是
private int replyCount;     //回复数量
private int praiseCount;     //点赞数
private Timestamp addTime;      //回复时间
private int commentId;      //父级评论id

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
public Edu_Questions getEdu_Questions() {
	return edu_Questions;
}
public void setEdu_Questions(Edu_Questions edu_Questions) {
	this.edu_Questions = edu_Questions;
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
public Timestamp getAddTime() {
	return addTime;
}
public void setAddTime(Timestamp addTime) {
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
	return "Edu_Questions_Comment [id=" + id + ", edu_User=" + edu_User + ", edu_Questions=" + edu_Questions
			+ ", content=" + content + ", isBest=" + isBest + ", replyCount=" + replyCount + ", praiseCount="
			+ praiseCount + ", addTime=" + addTime + ", commentId=" + commentId + "]";
}

}
