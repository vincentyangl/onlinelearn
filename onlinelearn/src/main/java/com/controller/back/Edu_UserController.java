package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_User;
import com.bean.Edu_class;
import com.service.Edu_UserService;
import com.service.Edu_classService;

@Controller
@RequestMapping("/admin/student")
public class Edu_UserController {
	
	@Autowired
	private Edu_UserService edu_UserService;
	@Autowired
	private Edu_classService edu_classService;
	
	@RequestMapping("/Edu_userAll")
	public ModelAndView listAll(HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		Map map=new HashMap<>();
		map=initMAP(request, map);
		List<Edu_User> list=edu_UserService.listAll(map);
		List<Edu_class>type=edu_classService.listAll();
		mv.addObject("type", type);
		mv.addObject("list", list);
		mv.setViewName("/back/student/student");
		return mv;
	}
	
	public Map initMAP(HttpServletRequest request,Map map) {
		String qname=request.getParameter("qname");
		String id=request.getParameter("id");
		map.put("id", id);
		map.put("qname", qname);
		return map;
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
