package com.controller.back;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourseStudyHistory;
import com.bean.Edu_User;
import com.bean.Edu_user_login_log;
import com.service.StatisticalFigureService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/statisticsPage")
public class StatisticalFigureController {//统计图
  
	@Autowired  
	public StatisticalFigureService service;
	
	@RequestMapping("/registered")//学员注册统计图
	public ModelAndView Figure(HttpServletRequest request) throws Exception {
		String createTime=request.getParameter("create_time");
		Map map=new HashMap<>();
		map.put("createTime", createTime);
		ModelAndView mv=new ModelAndView();
		List<Edu_User>list=service.listAll(map);
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		for (Edu_User edu_User : list) {
			list1.add(sdf2.format(sdf1.parse(edu_User.getCreateTime()+"")));
			list2.add(edu_User.getNum()+"");
		}
		mv.addObject("createTime", JsonUtils.objectToJson(list1));
		mv.addObject("num", JsonUtils.objectToJson(list2));
		mv.setViewName("/back/figure/statisticalFigure");
		return mv;
	}
	@RequestMapping("/videoViewingNum")//视频播放统计图
	public ModelAndView Studyhistory(HttpServletRequest request) throws Exception {
		String update_Time=request.getParameter("update_Time");
		Map map=new HashMap<>();
		map.put("updateTime", update_Time);
		ModelAndView mv=new ModelAndView();
		List<EduCourseStudyHistory>list=service.listStudyhistory(map);
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		for (EduCourseStudyHistory eduCourseStudyHistory : list) {
			list1.add(sdf2.format(sdf1.parse(eduCourseStudyHistory.getUpdateTime()+"")));
			list2.add(eduCourseStudyHistory.getNum()+"");
		}
		mv.addObject("update_Time", JsonUtils.objectToJson(list1));
		mv.addObject("num", JsonUtils.objectToJson(list2));
		mv.setViewName("/back/figure/StudyhistoryFigure");
		return mv;
	}
	@RequestMapping("/login")//视频播放统计图
	public ModelAndView Edu_user_login(HttpServletRequest request) throws Exception {
		String LOGIN_TIME=request.getParameter("LOGIN_TIME");
		Map map=new HashMap<>();
		map.put("LOGIN_TIME", LOGIN_TIME);
		ModelAndView mv=new ModelAndView();
		List<Edu_user_login_log>list=service.listLoginAll(map);
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		SimpleDateFormat sdf1= new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		for (Edu_user_login_log edu_user_login_log : list) {
			list1.add(sdf2.format(sdf1.parse(edu_user_login_log.getLogin_time()+"")));
			list2.add(edu_user_login_log.getNum()+"");
		}
		mv.addObject("LOGIN_TIME", JsonUtils.objectToJson(list1));
		mv.addObject("num", JsonUtils.objectToJson(list2));
		mv.setViewName("/back/figure/Edu_user_loginFigure");
		return mv;
	}
}
