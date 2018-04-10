package com.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduTeacher;
import com.service.EduTeacherService;

@Controller
@RequestMapping("/admin/teacher")
public class EduTeacherController {

	@Autowired
	private EduTeacherService eduTeacherService;
	@RequestMapping("teacherList")
	public ModelAndView listAll(){
		ModelAndView mv = new ModelAndView();
		List<EduTeacher> list = eduTeacherService.listAll();
		mv.addObject("list", list);
		mv.setViewName("/back/teacher/teacherList");
		return mv;
	}
	@RequestMapping("teacherGetById/{id}")
	public ModelAndView getById(@PathVariable("id")int id){
		ModelAndView mv = new ModelAndView();
		EduTeacher eduTeacher= eduTeacherService.getById(id);
		mv.addObject("eduTeacher", eduTeacher);
		mv.setViewName("");
		return mv;
	}
	@RequestMapping("deleteById/{id}")
	public String delete(@PathVariable("id")int id){
		eduTeacherService.delete(id);
		return "redirect:teacherList";
	}
	@RequestMapping("updateById")
	public String update(EduTeacher eduTeacher){
		eduTeacherService.update(eduTeacher);
		return "redirect:teacherList";
	}
	@RequestMapping("save")
	public String save(EduTeacher eduTeacher){
		eduTeacherService.save(eduTeacher);
		return "redirect:teacherList";
	}
}
