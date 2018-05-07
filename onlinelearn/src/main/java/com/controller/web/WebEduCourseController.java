package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.EduTeacher;
import com.bean.SysSubject;
import com.service.EduCourseService;
import com.service.EduTeacherService;
import com.service.SysSubjectService;

@Controller
@RequestMapping("/front")
public class WebEduCourseController {

	@Autowired
	private SysSubjectService sysSubjectService;
	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private EduCourseService eduCourseService;
	
	@RequestMapping("/course")
	public ModelAndView course() {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map.put("parent_id", 0);
		List<SysSubject> subjectList = sysSubjectService.listAll(map);
		List<EduTeacher> teacherList = eduTeacherService.listAll(map);
		List<EduCourse> eduCourses = eduCourseService.listAll(map);
		mv.addObject("subjectList", subjectList);
		mv.addObject("teacherList", teacherList);
		mv.addObject("courseList", eduCourses);
		mv.setViewName("web/course/courses-list");
		return mv;
	}
	
	
}
