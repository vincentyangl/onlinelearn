package com.controller.back;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Article;
import com.bean.Edu_Questions;
import com.bean.Edu_User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_QuestionsService;
import com.service.Edu_UserService;

@Controller
@RequestMapping("/admin/equestions")
public class Edu_QuestionsController {
	@Autowired
	private Edu_QuestionsService edu_QuestionsService;

	@RequestMapping("/edlist")
	public ModelAndView listAll(@RequestParam(required=true,defaultValue="1") Integer page,Model md, HttpServletRequest request){
		PageHelper.startPage(page,5);
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Questions> list=edu_QuestionsService.listAll(map);
		PageInfo<Edu_Questions> pageInfo=new PageInfo<Edu_Questions>(list);
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerLabel");
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);
		return mv;
	}
	
	//·â×°map
		private Map initMap(HttpServletRequest request,Map map){
			String title=request.getParameter("title");
			String type=request.getParameter("type");		
			if (title!=null) {
				map.put("title", title);
				request.setAttribute("title", title);
			}
			if (type!=null&&type.length()>0) {
				map.put("type", Integer.valueOf(type));
				request.setAttribute("type", Integer.valueOf(type));
				
			}
			return map;
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
	public ModelAndView getById(int id,HttpServletRequest request){
		int ids=Integer.parseInt(request.getParameter("id"));
		System.out.println(ids);
		ModelAndView mv =new ModelAndView();
		Edu_Questions edu_Questions=edu_QuestionsService.getById(id);
		System.out.println("userid"+edu_Questions.getEdu_User().getUserId());
		System.out.println("dsaasda"+edu_Questions.getEdu_User());
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerLabelupdate");
		mv.addObject("edu_Questions", edu_Questions);
		return mv;
	}
	
	@RequestMapping("/edupdate")
	public String update(Edu_Questions edu_Questions){
		System.out.println("update"+edu_Questions.getEdu_User());
		System.out.println(edu_Questions);
		edu_QuestionsService.update(edu_Questions);
		return "redirect:edlist";
	}
}
