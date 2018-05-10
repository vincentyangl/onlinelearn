package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Questions;
import com.service.Edu_QuestionsService;

@Controller
@RequestMapping("/front/equestions")
public class Edu_QuestionsqtController {
	@Autowired
	private Edu_QuestionsService edu_QuestionsService;
	
	@RequestMapping("/edlist/{flag}")
	public ModelAndView listAll(@PathVariable("flag") int flag){
		ModelAndView mv =new ModelAndView();
		Map map = new HashMap<>();
		map.put("flag", flag);
		List<Edu_Questions> list=edu_QuestionsService.listAll(map);
		System.out.println(list);
		mv.setViewName("web/questions/questions-list");
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
	
	@RequestMapping("/webedgetById")
	public ModelAndView getById(int id,HttpServletRequest request){
		int ids=Integer.parseInt(request.getParameter("id"));
		System.out.println(ids);
		ModelAndView mv =new ModelAndView();
		Edu_Questions edu_Questions=edu_QuestionsService.getById(id);
		System.out.println(edu_Questions.getEdu_User());
		mv.setViewName("/web/questions/questions-info");
		mv.addObject("edu_Questions", edu_Questions);
		return mv;
	}
	
	@RequestMapping("/edupdate")
	public String update(Edu_Questions edu_Questions){
		System.out.println(edu_Questions);
		edu_QuestionsService.update(edu_Questions);
		return "redirect:edlist";
	}
	
	
	
}
