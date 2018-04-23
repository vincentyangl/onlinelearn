package com.controller.back;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.service.EduCourseService;

@Controller
@RequestMapping("/admin/course")
public class EduCourseController {

	@Autowired
	private EduCourseService eduCourseService;
	
	@RequestMapping("/courseList")
	public ModelAndView courseList() {
		ModelAndView mv = new ModelAndView();
		List<EduCourse> eduCourses = eduCourseService.listAll(new HashMap<>());
		mv.addObject("eduCourses", eduCourses);
		mv.setViewName("/back/course/courseList");
		return mv;
	}
	
	@RequestMapping("/toCourseAdd")
	public String toCourseAdd() {
		return "/back/course/courseAdd";
	}
	
	@RequestMapping("/queryCourseList")
	public ModelAndView queryCourseList(String qname,int is_avaliable,int subjectId,String beginTime,String endTime) {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		if (qname!=null&&qname.trim().length()!=0) {
			map.put("qname", qname);
		}
		if (is_avaliable!=-1) {
			map.put("is_avaliable", is_avaliable);
		}
		if (subjectId!=-1) {
			map.put("subjectId", subjectId);
		}
		if (beginTime!=null&&beginTime.trim().length()!=0) {
			map.put("beginTime", beginTime);
		}
		if (endTime!=null&&endTime.trim().length()!=0) {
			map.put("endTime", endTime);
		}
		List<EduCourse> eduCourses = eduCourseService.listAll(map);
		mv.addObject("eduCourses", eduCourses);
		mv.setViewName("/back/course/courseList");
		return mv;
	}
	
	@RequestMapping("/courseDelete/{course_id}")
	public String courseDelete(@PathVariable("course_id") int course_id) {
		eduCourseService.delete(course_id);
		return "/admin/course/courseList";
	}
	
	@RequestMapping("/courseAdd")
	public String courseAdd() {
		return "/back/course/courseAdd";
	}
	
}
