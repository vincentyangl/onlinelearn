package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.Edu_User;
import com.bean.PageCourseBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EduCourseService;
import com.util.ObjectUtils;

@Controller
@RequestMapping("/uc")
public class UserCenterController {

	@Autowired
	private EduCourseService eduCourseService;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session,@RequestParam(required=true,defaultValue="1")Integer currentPage){
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		//·ÖÒ³
		PageHelper.startPage(currentPage, 9);
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		if (ObjectUtils.isNotNull(user)) {
			map.put("userId", user.getUserId());
			map.put("is_avaliable", 1);
			map.put("current_price", 0);
			List<EduCourse> courseList = eduCourseService.listAll(map);
			mv.addObject("courseList", courseList);
			//·ÖÒ³×ª»»
			PageInfo<EduCourse> info = new PageInfo<>(courseList);
			PageCourseBean page = new PageCourseBean();
			page.setCurrentPage(info.getPageNum());
			page.setPageSize(info.getPageSize());
			page.setTotalPageSize(info.getPages());
			page.setTotalResultSize(info.getTotal());
			mv.addObject("page", page);
			mv.setViewName("web/ucenter/uc_freecourse");
		}else {
			mv.setViewName("web/index/index");
		}
		return mv;
	}
	
}
