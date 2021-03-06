package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.EduTeacher;
import com.bean.SysSubject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EduCourseService;
import com.service.EduTeacherService;
import com.service.SysSubjectService;


@Controller
public class WebEduTeacherController {


	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private EduCourseService eduCourseService;
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/front/teacher")
	public ModelAndView listAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer page,Model md){
		PageHelper.startPage(page,8);
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		List<EduTeacher> list = eduTeacherService.listAll(map);
		List<SysSubject> lists = sysSubjectService.listDad();
		PageInfo<EduTeacher> pageInfo = new PageInfo<EduTeacher>(list);
		mv.addObject("list", list);
		mv.addObject("lists", lists);
		mv.addObject("page", pageInfo);
		mv.setViewName("/web/teacher/teacherList");
		return mv;
	}
	@RequestMapping("/front/teacher/getBySid/{subjectId}")
	public ModelAndView getBySid(@PathVariable int subjectId){
		ModelAndView mv = new ModelAndView();
		List<EduTeacher> list =  eduTeacherService.getTeacherBySubjectId(subjectId);
		List<SysSubject> lists = sysSubjectService.listDad();
		mv.addObject("list", list);
		System.out.println(list);
		mv.addObject("lists", lists);
		mv.setViewName("/web/teacher/teacherList");
		return mv;
	}
	@RequestMapping("/front/teacher/getById/{id}")
	public ModelAndView getById(@PathVariable("id")int id) {
		ModelAndView mv = new ModelAndView();
		EduTeacher eduTeacher = eduTeacherService.getById(id);
		List<EduCourse> list = eduCourseService.getByTeacherId(id);
		mv.addObject("list", list);
		mv.addObject("teacher", eduTeacher);
		mv.setViewName("/web/teacher/teacherInfo");
		return mv;
	}
}
