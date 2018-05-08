package com.bean;

import java.util.Date;

public class Edu_emailsend_history {//邮件发送记录
	
	private int id;
	private String email;  //邮箱号
	private Edu_User userId; //用户id
	private String title; //邮箱标题
	private String content;//邮箱正文
	private Date create_time;//发送时间
	private Date send_time;//发送时间
	private int status;//(状态)1 已发送 2 未发送
	private int type;//1 普通 2 定时
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Edu_User getUserId() {
		return userId;
	}
	public void setUserId(Edu_User userId) {
		this.userId = userId;
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
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	

}
