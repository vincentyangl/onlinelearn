package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduTeacher;
import com.bean.SysSubject;
import com.service.EduTeacherService;
import com.service.SysSubjectService;


@Controller
public class WebEduTeacherController {

	
	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/front/teacher")
	public ModelAndView listAll(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		List<EduTeacher> list = eduTeacherService.listAll(map);
		List<SysSubject> lists = sysSubjectService.listDad();
		mv.addObject("list", list);
		mv.addObject("lists", lists);
		mv.setViewName("/web/teacher/teacherList");
		return mv;
	}
	@RequestMapping("/front/teacher/getBySid/{subjectId}")
	public ModelAndView getBySid(@PathVariable int subjectId){
		ModelAndView mv = new ModelAndView();
		System.out.println(subjectId);
		List<EduTeacher> list =  eduTeacherService.listBySid(subjectId);
		List<SysSubject> lists = sysSubjectService.listDad();
		mv.addObject("list", list);
		mv.addObject("lists", lists);
		mv.setViewName("/web/teacher/teacherList");
		return mv;
	}
	@RequestMapping("/front/teacher/getById/{id}")
	public ModelAndView getById(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		EduTeacher eduTeacher = eduTeacherService.getById(id);
		List<SysSubject> lsit = sysSubjectService.listAll(new HashMap());
		mv.addObject("list", lsit);
		mv.addObject("teacher", eduTeacher);
		mv.setViewName("/web/teacher/teacherInfo");
		return mv;
	}
}
