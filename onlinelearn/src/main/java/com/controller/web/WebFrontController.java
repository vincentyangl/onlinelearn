package com.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebFrontController {

	@RequestMapping("/")
	public String index(){
		return "web/index/index";
	}
	
	@RequestMapping("/article")
	public String article(){
		return "web/article/article-list";
	}

	@RequestMapping("/course")
	public String course(){
		return "web/course/courses-list";
	}
	
	@RequestMapping("/teacher")
	public String teacher(){
		return "web/teacher/teacher_list";
	}

	@RequestMapping("/question")
	public String question(){
		return "web/questions/questions-list";
	}
}
