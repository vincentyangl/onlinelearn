package com.service;

import java.util.List;
import java.util.Map;

import com.bean.EduCourseStudyHistory;
import com.bean.EduKpoint;
import com.bean.Edu_User;
import com.bean.Edu_user_login_log;

public interface StatisticalFigureService {

	public List<Edu_User> listAll(Map map);//学员注册统计图
	public List<EduCourseStudyHistory>listStudyhistory(Map map);//视频播放统计图
	public List<Edu_user_login_log> listLoginAll(Map map); //学员登录信息统计图
}
