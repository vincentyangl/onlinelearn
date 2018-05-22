package com.controller.back;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Questions_Tag;
import com.service.Edu_Questions_TagService;
import com.util.JsonUtils;
import com.util.Ztree;


@Controller
@RequestMapping("/admin/eqtag")
public class Edu_Questions_TagController {

	@Autowired
	private Edu_Questions_TagService edu_Questions_TagService;
	@RequestMapping("/eqtlist")
	public ModelAndView list(){
		ModelAndView mv=new ModelAndView();
		List<Ztree> list=edu_Questions_TagService.listAll();
		String json=JsonUtils.objectToJson(list);
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerLists");
		mv.addObject("json", json);
		return mv;
	}
	
	@RequestMapping("/eqtdelete")
	public String delete(int qtid){
		edu_Questions_TagService.delete(qtid);
		return "redirect:eqtlist";
	}
	
	@RequestMapping("/eqtsave")
	public String save(Edu_Questions_Tag edu_Questions_Tag,HttpServletRequest request){
//		String questionsTagName=request.getParameter("questionsTagName");
//		edu_Questions_Tag.setQuestionsTagName(questionsTagName);
		edu_Questions_Tag.setCreateTime(new Date());
		edu_Questions_TagService.save(edu_Questions_Tag);
		return "redirect:eqtlist";
	}
	
//	@RequestMapping("/tzsasve")
//	public String tzsave(){
//		System.out.println("nihao");
//		return "redirect:/back/QuestionAnswer/QuestionAnswerListsave";
//	}
//	
//	@RequestMapping("/eqtgetById")
//	public ModelAndView getById(int questionsTagId){
//		ModelAndView mv=new ModelAndView();
//		Edu_Questions_Tag edu_Questions_Tag=edu_Questions_TagService.getById(questionsTagId);
//		mv.setViewName("/back/QuestionAnswer/QuestionAnswerListupdate");
//		mv.addObject("edu_Questions_Tag", edu_Questions_Tag);
//		return mv;
//	}
	
	@RequestMapping("/eqtupdate")
	public String update(@RequestParam(value = "id", defaultValue = "0") int qtid,@RequestParam(value = "name", defaultValue = "null")String tagName,Edu_Questions_Tag edu_Questions_Tag){
		Edu_Questions_Tag questionsTag=new Edu_Questions_Tag();
		questionsTag.setQuestionsTagId(qtid);
		questionsTag.setQuestionsTagName(tagName);
		questionsTag.setCreateTime(new Date());
		System.out.println(questionsTag);
		edu_Questions_TagService.update(questionsTag);
		return "redirect:eqtlist";
	}
	
//	@RequestMapping("/updates")
//	public String updates(int qtid){
//		edu_Questions_TagService.updates(qtid);
//		return "redirect:eqtlist";
//	}
	
//	@RequestMapping("/updateTag")
//	@ResponseBody
//	public String updateTag(@RequestParam(value = "id", defaultValue = "0") int qtid,@RequestParam(value = "name", defaultValue = "null")String tagName) {
//		QuestionsTag questionsTag=new QuestionsTag();
//		questionsTag.setQuestions_tag_id(qtid);
//		questionsTag.setQuestions_tag_name(tagName);
//		questionsTag.setCreate_time(new Date());
//		System.out.println(questionsTag);
//		questionsTagService.update(questionsTag);
//		return "redirect:/admin/questions/toQuestionsTagList";
//	}

}
