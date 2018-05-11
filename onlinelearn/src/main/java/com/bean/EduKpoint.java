package com.bean;

import java.util.Date;
import java.util.List;

public class EduKpoint {

	private int id;//课程节点id
	private int courseId;//对应的课程id
	private String name;//课程节点名称
	private int pId;//课程节点父ID
	private Date addTime;//添加时间
	private int sort;//排序
	private int playCount;//播放次数
	private int isFree;//是否免费1是2否
	private String videoUrl;//视频路径
	private EduTeacher eduTeacher;//录视频的老师
	private String playTime;//播放的时间
	private int kpointType;//节点类型 0是目录，1是章节
	private String videoType;//视频类型
	private String fileType;//VIDEO视频 AUDIO音频 FILE文档 TXT文本 ATLAS图片集
	private String content;//文本
	//子节点集合
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
