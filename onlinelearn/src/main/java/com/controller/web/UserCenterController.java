package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.Edu_User;
import com.service.EduCourseService;

@Controller
@RequestMapping("/uc")
public class UserCenterController {

	@Autowired
	private EduCourseService eduCourseService;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		map.put("userId", user.getUserId());
		map.put("is_avaliable", 1);
		map.put("current_price", 0);
		List<EduCourse> courseList = eduCourseService.listAll(map);
		mv.addObject("courseList", courseList);
		mv.setViewName("web/ucenter/uc_freecourse");
		return mv;
	}
}
