package com.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduComment;
import com.service.EduCommentService;

@Controller
public class WebEduCommentController {

	@Autowired
	private EduCommentService eduCommentService;
	@RequestMapping("/addArtucleqt/{eduComment}")
	public ModelAndView addArtucleqt(@PathVariable("eduComment")EduComment eduComment){
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
