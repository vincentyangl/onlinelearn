package com.controller.web;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Article;
import com.bean.Edu_Article_Content;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_ArticleService;
import com.service.Edu_Article_ContentService;

@Controller
@RequestMapping("/front/earticle")
public class Edu_ArticleqtController {

	@Autowired
	private Edu_ArticleService edu_ArticleService;
	
	@RequestMapping("/ealist")
	public ModelAndView list(HttpServletRequest request){
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Article> list=edu_ArticleService.listAll(map);
		mv.setViewName("/web/article/article-list");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/wabGetById/{articleId}")
	public ModelAndView getById(@PathVariable("articleId") int articleId){
		ModelAndView mv =new ModelAndView();
		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
		mv.addObject("edu_Article", edu_Article);
		mv.setViewName("/web/article/article-info");
		return mv;
		
	}
	
	//·â×°map
			private Map initMap(HttpServletRequest request,Map map){
				String title=request.getParameter("title");
				String articleType=request.getParameter("articleType");
				if (title!=null) {
					map.put("title", title);
					request.setAttribute("title", title);
				}
				if (articleType!=null&&articleType.length()>0) {
					map.put("articleType", Integer.valueOf(articleType));
					request.setAttribute("articleType", Integer.valueOf(articleType));
				}
				return map;
			}
	
//	@RequestMapping("/eagetById")
//	public ModelAndView getById(int articleId){
//		ModelAndView mv =new ModelAndView();
//		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
//		Edu_Article_Content edu_Article_Content=edu_Article_ContentService.getById(articleId);
//		mv.setViewName("/back/articleConsultingManagement/articleScienceUpdate");
//		mv.addObject("edu_Article", edu_Article);
//		mv.addObject("edu_Article_Content", edu_Article_Content);
//		return mv;
//	}
}
