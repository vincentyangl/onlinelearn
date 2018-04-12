package com.bean;

import java.sql.Date;

public class Edu_class { //班级表

	private int id;//班级ID
	private String cname;//班级名称
	private String cyear;//第几届班级
	private Date update_time;//更新时间
	private int status;//班级状态：1 开班中； 0 未开班； 2 已毕业
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCyear() {
		return cyear;
	}
	public void setCyear(String cyear) {
		this.cyear = cyear;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
     
	
}
