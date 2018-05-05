package com.bean;

import java.util.Date;
import java.util.List;

public class EduCourse {

	//课程编号
	private int course_id;
	//课程名称
	private String course_name;
	//1正常2下架3.删除
	private int is_avaliable;
	//课程专业
	private SysSubject sysSubject;
	//课程专业链
	private String subject_link;
	//添加时间
	private Date add_time;
	//课程原价格（只显示）
	private double source_price;
	//课程销售价格（实际支付价格）设置为0则可免费观看
	private double current_price;
	//课程简介
	private String title;
	//课程详情
	private String context;
	//总课时
	private int lession_num;
	//图片路径
	private String logo;
	//最后更新时间
	private Date update_time;
	//销售数量
	private int page_buyCount;
	//浏览数量
	private int page_viewCount;
	//有效结束时间
	private Date end_time;
	//有效期类型，0：到期时间，1：按天数
	private int loseType;
	//有效期:商品订单过期时间点
	private String lose_time;
	//序列
	private int sequence;
	//该课程总共卖了多少钱（新加字段暂时没用到）
	private double course_gross_income;
	//负责给课程的老师
	private List<EduTeacher> eduTeachers;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getIs_avaliable() {
		return is_avaliable;
	}
	public void setIs_avaliable(int is_avaliable) {
		this.is_avaliable = is_avaliable;
	}
	public SysSubject getSysSubject() {
		return sysSubject;
	}
	public void setSysSubject(SysSubject sysSubject) {
		this.sysSubject = sysSubject;
	}
	public String getSubject_link() {
		return subject_link;
	}
	public void setSubject_link(String subject_link) {
		this.subject_link = subject_link;
	}
	public Date getAdd_time() {
		return add_time;
	}
	public void setAdd_time(Date add_time) {
		this.add_time = add_time;
	}
	public double getSource_price() {
		return source_price;
	}
	public void setSource_price(double source_price) {
		this.source_price = source_price;
	}
	public double getCurrent_price() {
		return current_price;
	}
	public void setCurrent_price(double current_price) {
		this.current_price = current_price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getLession_num() {
		return lession_num;
	}
	public void setLession_num(int lession_num) {
		this.lession_num = lession_num;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public int getPage_buyCount() {
		return page_buyCount;
	}
	public void setPage_buyCount(int page_buyCount) {
		this.page_buyCount = page_buyCount;
	}
	public int getPage_viewCount() {
		return page_viewCount;
	}
	public void setPage_viewCount(int page_viewCount) {
		this.page_viewCount = page_viewCount;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public int getLoseType() {
		return loseType;
	}
	public void setLoseType(int loseType) {
		this.loseType = loseType;
	}
	public String getLose_time() {
		return lose_time;
	}
	public void setLose_time(String lose_time) {
		this.lose_time = lose_time;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public double getCourse_gross_income() {
		return course_gross_income;
	}
	public void setCourse_gross_income(double course_gross_income) {
		this.course_gross_income = course_gross_income;
	}
	public List<EduTeacher> getEduTeachers() {
		return eduTeachers;
	}
	public void setEduTeachers(List<EduTeacher> eduTeachers) {
		this.eduTeachers = eduTeachers;
	}
	
	
	
}
