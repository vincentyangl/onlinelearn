package com.bean;

import java.util.Date;
import java.util.List;

public class EduCourse {

	//�γ̱��
	private int course_id;
	//�γ�����
	private String course_name;
	//1����2�¼�3.ɾ��
	private int is_avaliable;
	//�γ�רҵ
	private SysSubject sysSubject;
	//�γ�רҵ��
	private String subject_link;
	//���ʱ��
	private Date add_time;
	//�γ�ԭ�۸�ֻ��ʾ��
	private double source_price;
	//�γ����ۼ۸�ʵ��֧���۸�����Ϊ0�����ѹۿ�
	private double current_price;
	//�γ̼��
	private String title;
	//�γ�����
	private String context;
	//�ܿ�ʱ
	private int lession_num;
	//ͼƬ·��
	private String logo;
	//������ʱ��
	private Date update_time;
	//��������
	private int page_buyCount;
	//�������
	private int page_viewCount;
	//��Ч����ʱ��
	private Date end_time;
	//��Ч�����ͣ�0������ʱ�䣬1��������
	private int loseType;
	//��Ч��:��Ʒ��������ʱ���
	private String lose_time;
	//����
	private int sequence;
	//�ÿγ��ܹ����˶���Ǯ���¼��ֶ���ʱû�õ���
	private double course_gross_income;
	//������γ̵���ʦ
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
