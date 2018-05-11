package com.controller.back;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Article_Content;
import com.service.Edu_Article_ContentService;

@Controller
@RequestMapping("/admin/eacontent")
public class Edu_Article_ContentController {

	@Autowired
	private Edu_Article_ContentService edu_Article_ContentService;
	
	@RequestMapping("/eaclist")
	public ModelAndView list(){
		ModelAndView mv=new ModelAndView();
		List<Edu_Article_Content> list=edu_Article_ContentService.listAll();
		mv.setViewName("");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/eacdelete")
	public String delete(int articleId){
		edu_Article_ContentService.delete(articleId);
		return "redirect:eaclist";
	}
	
	@RequestMapping("/eacsave")
	public String save(Edu_Article_Content edu_Article_Content){
		edu_Article_ContentService.save(edu_Article_Content);
		return "redirect:eaclist";
	}
	
	@RequestMapping("/eacupdate")
	public String update(Edu_Article_Content edu_Article_Content){
		edu_Article_ContentService.update(edu_Article_Content);
		return "redirect:eaclist";
	}
	
	@RequestMapping("/eacgetById")
	public ModelAndView getById(int articleId){
		ModelAndView mv =new ModelAndView();
		Edu_Article_Content edu_Article_Content=edu_Article_ContentService.getById(articleId);
		mv.setViewName("eacupdate");
		mv.addObject("edu_Article_Content", edu_Article_Content);
		return mv;
	}
}
