package com.bean;

import java.util.Date;
import java.util.List;

public class EduKpoint {

	private int id;//�γ̽ڵ�id
	private int courseId;//��Ӧ�Ŀγ�id
	private String name;//�γ̽ڵ�����
	private int pId;//�γ̽ڵ㸸ID
	private Date addTime;//���ʱ��
	private int sort;//����
	private int playCount;//���Ŵ���
	private int isFree;//�Ƿ����1��2��
	private String videoUrl;//��Ƶ·��
	private EduTeacher eduTeacher;//¼��Ƶ����ʦ
	private String playTime;//���ŵ�ʱ��
	private int kpointType;//�ڵ����� 0��Ŀ¼��1���½�
	private String videoType;//��Ƶ����
	private String fileType;//VIDEO��Ƶ AUDIO��Ƶ FILE�ĵ� TXT�ı� ATLASͼƬ��
	private String content;//�ı�
	//�ӽڵ㼯��
	private List<EduKpoint> kpointList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getPlayCount() {
		return playCount;
	}
	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}
	public int getIsFree() {
		return isFree;
	}
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public EduTeacher getEduTeacher() {
		return eduTeacher;
	}
	public void setEduTeacher(EduTeacher eduTeacher) {
		this.eduTeacher = eduTeacher;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	public int getKpointType() {
		return kpointType;
	}
	public void setKpointType(int kpointType) {
		this.kpointType = kpointType;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<EduKpoint> getKpointList() {
		return kpointList;
	}
	public void setKpointList(List<EduKpoint> kpointList) {
		this.kpointList = kpointList;
	}
	
}
