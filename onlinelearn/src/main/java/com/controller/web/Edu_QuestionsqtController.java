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
import com.bean.Edu_Questions_Comment;
import com.bean.Edu_Questions_Tag;
import com.service.Edu_QuestionsService;
import com.service.Edu_Questions_CommentService;
import com.service.Edu_Questions_TagService;

@Controller
@RequestMapping("/front/equestions")
public class Edu_QuestionsqtController {
	@Autowired
	private Edu_QuestionsService edu_QuestionsService;
	@Autowired
	private Edu_Questions_TagService edu_Questions_TagService;
	@Autowired
	public Edu_Questions_CommentService edu_Questions_CommentService;
	
	@RequestMapping("/edlist/{flag}")
	public ModelAndView listAll(@PathVariable("flag") int flag,HttpServletRequest request){
//		int type=Integer.parseInt(request.getParameter("type"));
//		System.err.println("type"+type);
		ModelAndView mv =new ModelAndView();
		Map map = new HashMap<>();
		map.put("flag", flag);
		List<Edu_Questions> list=edu_QuestionsService.listAll(map);
		System.out.println(list);
		mv.setViewName("web/questions/questions-list");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/listlb")
	public ModelAndView listlb(){
		ModelAndView mv =new ModelAndView();
		List<Edu_Questions_Tag> listl=edu_Questions_TagService.listAlls();
		mv.addObject("questionsTagList", listl);
		mv.setViewName("web/questions/questions-list");
		return mv;
	}
	
	
//	@RequestMapping("/eddelete")
//	public String delete(int id){
//		edu_QuestionsService.delete(id);
//		return "redirect:edlist";
//	}
//	
//	@RequestMapping("/edsave")
//	public String save(Edu_Questions edu_Questions){
//		edu_QuestionsService.save(edu_Questions);
//		return "redirect:edlist";
//	}
//	
	@RequestMapping("/webedgetById/{id}")
	public ModelAndView getById(@PathVariable("id")int id){
		System.out.println(id);
		ModelAndView mv =new ModelAndView();
		Edu_Questions questions=edu_QuestionsService.getById(id);
		List<Edu_Questions_Comment> questionsCommentRepList=edu_Questions_CommentService.getByIdsx(id);
		mv.addObject("questionsCommentRepList", questionsCommentRepList);
//		List<Edu_Questions_Tag> question=edu_Questions_TagService.getByIdbq(id);
//		mv.addObject("question", question);
//		System.out.println(questions.getEdu_User());
		mv.setViewName("/web/questions/questions-info");
		mv.addObject("questions", questions);
		return mv;
	}
	
//	@RequestMapping("/getByIdsx/{id}")
//	public ModelAndView getByIdsx(@PathVariable("id")int id){
//		System.err.println("ÄãºÃ");
//		System.err.println("id---------"+id);
//		ModelAndView mv =new ModelAndView();
//		List<Edu_Questions_Comment> questionsCommentRepList=edu_Questions_CommentService.getByIdsx(id);
//		mv.addObject("questionsCommentRepList", questionsCommentRepList);
//		System.out.println(questionsCommentRepList);
//		mv.setViewName("/web/questionscomment/questionscomment-ajax-listreply");
//		return mv;
//	}
	
	
	@RequestMapping("/edupdate")
	public String update(Edu_Questions edu_Questions){
		System.out.println(edu_Questions);
		edu_QuestionsService.update(edu_Questions);
		return "redirect:edlist";
	}
	
	
	
}
