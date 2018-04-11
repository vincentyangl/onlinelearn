package com.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Questions;
import com.service.Edu_QuestionsService;

@Controller
@RequestMapping("/admin/equestions")
public class Edu_QuestionsController {
	@Autowired
	private Edu_QuestionsService edu_QuestionsService;
	
	@RequestMapping("/edlist")
	public ModelAndView listAll(){
		ModelAndView mv =new ModelAndView();
		List<Edu_Questions> list=edu_QuestionsService.listAll();
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerLabel");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/eddelete")
	public String delete(int id){
		edu_QuestionsService.delete(id);
		return "redirect:edlist";
	}
	
	@RequestMapping("/edsave")
	public String save(Edu_Questions edu_Questions){
		edu_QuestionsService.save(edu_Questions);
		return "redirect:edlist";
	}
	
	@RequestMapping("/edgetById")
	public ModelAndView getById(int id){
		ModelAndView mv =new ModelAndView();
		Edu_Questions edu_Questions=edu_QuestionsService.getById(id);
		mv.setViewName("edupdate");
		mv.addObject("edu_Questions", edu_Questions);
		return mv;
	}
	
	@RequestMapping("/edupdate")
	public String update(Edu_Questions edu_Questions){
		edu_QuestionsService.update(edu_Questions);
		return "redirect:edlist";
	}
}
