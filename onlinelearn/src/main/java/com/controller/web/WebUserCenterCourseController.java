package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.EduCourseFavorites;
import com.bean.Edu_User;
import com.service.EduCourseFavoritesService;
import com.service.EduCourseService;
import com.tools.Result;
import com.util.ObjectUtils;

@Controller
public class WebUserCenterCourseController {

	@Autowired
	private EduCourseService eduCourseService;
	@Autowired
	private EduCourseFavoritesService eduCourseFavoritesService;
	
	
	@RequestMapping("/uc/freeCourseList")
	public ModelAndView freeCourseList() {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map.put("is_avaliable", 1);
		map.put("current_price", 0);
		List<EduCourse> courseList = eduCourseService.listAll(map);
		mv.addObject("courseList", courseList);
		mv.setViewName("web/ucenter/uc_freecourse");
		return mv;
	}
	
	@RequestMapping("/uc/myFavorites")
	public ModelAndView myFavorites(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		Map map = new HashMap<>();
		map.put("userId", user.getUserId());
		List<EduCourseFavorites> favoriteList = eduCourseFavoritesService.listAll(map);
		mv.addObject("favoriteList", favoriteList);
		mv.setViewName("/web/ucenter/favourite_course_list");
		return mv;
	}
	
	@RequestMapping("/front/createfavorites/{courseId}")
	public Result createfavorites(@PathVariable("courseId") int courseId,HttpSession session) {
		Result result = new Result();
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		Map map = new HashMap<>();
		map.put("courseId", courseId);
		map.put("userId", user.getUserId());
		List<EduCourseFavorites> favoriteList = eduCourseFavoritesService.listAll(map);
		if (favoriteList.size()==0) {
			EduCourseFavorites eduCourseFavorites = new EduCourseFavorites();
			eduCourseFavorites.setEduCourse(eduCourseService.getById(courseId));
			eduCourseFavorites.setUser(user);
			eduCourseFavoritesService.save(eduCourseFavorites);
			result.setSuccess(true);
			result.setMessage("收藏成功!");
		}else {
			result.setSuccess(false);
			result.setMessage("已经收藏过了!");
		}
		return result;
	}
	
}
