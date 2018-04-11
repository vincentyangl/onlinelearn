package com.controller.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_User;
import com.service.Edu_UserService;

@Controller
@RequestMapping("/euser")
public class Edu_UserController {
	@Autowired
	private Edu_UserService edu_UserService;
	@RequestMapping("/eulist")
	public ModelAndView listAll(){
		ModelAndView mv=new ModelAndView();
		List<Edu_User> list=edu_UserService.listAll();
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerList");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/eudelete")
	public String delete(int id,HttpServletRequest request){
		edu_UserService.delete(id);
		return "redirect:eulist";
	}
	
	@RequestMapping("/eusave")
	public String save(Edu_User edu_User){
		edu_UserService.save(edu_User);
		return "redirect:eulist";
	}
	
	@RequestMapping("/eugetById")
	public ModelAndView getById(int id){
		ModelAndView mv =new ModelAndView();
		Edu_User edu_User=edu_UserService.getById(id);
		mv.setViewName("euupdate");
		mv.addObject("edu_User", edu_User);
		return mv;
	}
	
	@RequestMapping("/euupdate")
	public String update(Edu_User edu_User){
		edu_UserService.update(edu_User);
		return "redirect:eulist";
	}
}
