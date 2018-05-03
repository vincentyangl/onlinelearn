package com.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SysSubject;
import com.service.SysSubjectService;

@Controller
public class SysSubjectController {

	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/admin/SysSubject/SysSubjectList")
	public ModelAndView listAll(){
		System.out.println("11");
		ModelAndView mv = new ModelAndView();
		List<SysSubject> list = sysSubjectService.listAll();
		mv.addObject("list", list);
		mv.setViewName("/back/teacher/teacherAdd");
		return mv;
	}
}
