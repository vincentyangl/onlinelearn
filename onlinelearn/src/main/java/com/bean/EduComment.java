package com.bean;

import java.util.Date;
import java.util.List;

public class EduComment {

	private int commentId; //����id
	private Edu_User user; //������
	private int pCommentId;//'��������id(Ϊ0����һ������,��Ϊ0���ǻظ�)
	private String content;//��������
	private Date addTime;//����ʱ��
	private int ontherId;//�������ID���γ̣�
	private int praiseCount;//��������
	private int replyCount;//�ظ�����
	private int type;//1���� 2�γ�
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
