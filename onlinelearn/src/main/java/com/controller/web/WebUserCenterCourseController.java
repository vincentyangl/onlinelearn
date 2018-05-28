package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.EduCourseFavorites;
import com.bean.Edu_User;
import com.bean.PageCourseBean;
import com.bean.UnReadLetter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EduCourseFavoritesService;
import com.service.EduCourseService;
import com.service.EduMsgReceiveService;
import com.service.WebEduMsgReceivingService;
import com.tools.Result;
import com.util.ObjectUtils;

@Controller
public class WebUserCenterCourseController {

	@Autowired
	private EduCourseService eduCourseService;
	@Autowired
	private EduCourseFavoritesService eduCourseFavoritesService;
	@Autowired
	private WebEduMsgReceivingService webEduMsgReceivingService;
	
	@RequestMapping("/uc/freeCourseList")
	public ModelAndView freeCourseList(@RequestParam(required=true,defaultValue="1")Integer currentPage) {
		ModelAndView mv = new ModelAndView();
		//分页
		PageHelper.startPage(currentPage, 9);
		Map map = new HashMap<>();
		map.put("is_avaliable", 1);
		map.put("current_price", 0);
		List<EduCourse> courseList = eduCourseService.listAll(map);
		//分页转换
		PageInfo<EduCourse> info = new PageInfo<>(courseList);
		PageCourseBean page = new PageCourseBean();
		page.setCurrentPage(info.getPageNum());
		page.setPageSize(info.getPageSize());
		page.setTotalPageSize(info.getPages());
		page.setTotalResultSize(info.getTotal());
		mv.addObject("courseList", courseList);
		mv.addObject("page", page);
		mv.setViewName("web/ucenter/uc_freecourse");
		return mv;
	}
	
	@RequestMapping("/uc/myFavorites")
	public ModelAndView myFavorites(HttpSession session,@RequestParam(required=true,defaultValue="1")Integer currentPage) {
		ModelAndView mv = new ModelAndView();
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		//分页
		PageHelper.startPage(currentPage, 6);
		Map map = new HashMap<>();
		map.put("userId", user.getUserId());
		List<EduCourseFavorites> favoriteList = eduCourseFavoritesService.listAll(map);
		//分页转换
		PageInfo<EduCourseFavorites> info = new PageInfo<>(favoriteList);
		PageCourseBean page = new PageCourseBean();
		page.setCurrentPage(info.getPageNum());
		page.setPageSize(info.getPageSize());
		page.setTotalPageSize(info.getPages());
		page.setTotalResultSize(info.getTotal());
		mv.addObject("page", page);
		mv.addObject("favoriteList", favoriteList);
		mv.setViewName("/web/ucenter/favourite_course_list");
		return mv;
	}
	
	@RequestMapping("/front/createfavorites/{courseId}")
	public Result createfavorites(@PathVariable("courseId") int courseId,HttpSession session,EduCourseFavorites eduCourseFavorites) {
		Result result = new Result();
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		Map map = new HashMap<>();
		map.put("courseId", courseId);
		map.put("userId", user.getUserId());
		List<EduCourseFavorites> favoriteList = eduCourseFavoritesService.listAll(map);
		if (favoriteList.size()==0) {
			eduCourseFavorites.setEduCourse(eduCourseService.getById(courseId));
			eduCourseFavorites.setUser(user);
			eduCourseFavoritesService.save(eduCourseFavorites);
			result.setSuccess(false);
			result.setMessage("收藏成功!");
		}else {
			result.setSuccess(true);
			result.setMessage("已经收藏过了!");
		}
		return result;
	}
	
	@RequestMapping("/uc/deleteFaveorite/{id}")
	public String deleteFaveorite(@PathVariable("id") int id) {
		eduCourseFavoritesService.delete(id);
		return "redirect:/uc/myFavorites";
	}
	
	@RequestMapping("/uc/ajax/queryUnReadLetter")
	public Result queryUnReadLetter(HttpSession session,UnReadLetter letter) {
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		Map map = new HashMap<>();
			map.put("receivingCusid", 2);
			map.put("status", 0);
			int unReadNum = webEduMsgReceivingService.queryUnReadLetter(map);
			letter.setUnReadNum(unReadNum);
			map.put("type", 1);
			int SMNum = webEduMsgReceivingService.queryUnReadLetter(map);
			letter.setSMNum(SMNum);
			map.put("type", 2);
			int MNum = webEduMsgReceivingService.queryUnReadLetter(map);
			letter.setmNum(MNum);
		Result result = new Result();
		result.setEntity(letter);
		return result;
	}
	
}
