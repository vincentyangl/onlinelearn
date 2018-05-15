package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CommentPraise;
import com.bean.EduComment;
import com.bean.Edu_User;
import com.service.CommentPraiseService;
import com.service.EduCommentService;
import com.util.ObjectUtils;

@Controller
@RequestMapping("/web/comment/ajax")
public class WebEduCommentController {

	@Autowired
	private EduCommentService eduCommentService;
	@Autowired
	private CommentPraiseService commentPraiseService;
	
	@RequestMapping("/query")
	public ModelAndView query(HttpSession session,int otherId,int type,String order) {
		ModelAndView mv = new ModelAndView();
		System.out.println("65------------------------------------");
		Map map = new HashMap<>();
		if (ObjectUtils.isNotNull(otherId)) {
			map.put("otherId", otherId);
		}
		if (ObjectUtils.isNotNull(type)) {
			map.put("type", type);
		}
		if (order!=null&&order.trim().length()!=0) {
			map.put("order", order);
		}
		List<EduComment> commentList = eduCommentService.listAll(map);
		System.out.println(otherId+"type"+type+"order"+order+"-------------"+commentList.size());
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		mv.addObject("user", user);
		mv.addObject("commentList", commentList);
		mv.setViewName("/web/comment/comment");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/addcomment")
	public String addcomment(EduComment eduComment,HttpSession session) {
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		eduComment.setUser(user);
		System.out.println(eduComment.getOtherId()+"========");
		eduCommentService.save(eduComment);
		if (eduComment.getpCommentId()>0) {
			eduCommentService.updateReplyCount(eduComment.getpCommentId());
		}
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/commentreply")
	public ModelAndView commentreply(int otherId,int pCommentId) {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map.put("otherId", otherId);
		map.put("pCommentId", pCommentId);
		List<EduComment> commentList = eduCommentService.listAll(map);
		mv.addObject("commentList", commentList);
		mv.setViewName("/web/comment/comment_reply");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/addPraise")
	public int addPraise(CommentPraise praise) {
		System.out.println(praise.getCommentId()+"ot"+praise.getOtherId()+"us"+praise.getUserId()+"ty"+praise.getType());
		List<CommentPraise> praises = commentPraiseService.listAll(praise);
		int count = 0;
		if (praises.size()==0) {
			eduCommentService.updatePraiseCount(praise.getCommentId());
			commentPraiseService.save(praise);
			count = 1;
		}
		return count;
	}
	
}
