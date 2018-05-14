package com.bean;

import java.util.Date;
import java.util.List;

public class EduComment {

	private int commentId; //评论id
	private Edu_User user; //评论人
	private int pCommentId;//'父级评论id(为0则是一级评论,不为0则是回复)
	private String content;//评论内容
	private Date addTime;//评论时间
	private int ontherId;//评论相关ID（课程）
	private int praiseCount;//点赞数量
	private int replyCount;//回复数量
	private int type;//1文章 2课程
	private List<EduComment> eduComments;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public Edu_User getUser() {
		return user;
	}
	public void setUser(Edu_User user) {
		this.user = user;
	}
	public int getpCommentId() {
		return pCommentId;
	}
	public void setpCommentId(int pCommentId) {
		this.pCommentId = pCommentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getOntherId() {
		return ontherId;
	}
	public void setOntherId(int ontherId) {
		this.ontherId = ontherId;
	}
	public int getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public List<EduComment> getEduComments() {
		return eduComments;
	}
	public void setEduComments(List<EduComment> eduComments) {
		this.eduComments = eduComments;
	}
	
}
