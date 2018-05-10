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
	@Autowired
	private Edu_Article_ContentService edu_Article_ContentService;
	
	@RequestMapping("/ealist")
	public ModelAndView list(@RequestParam(required=true,defaultValue="1") Integer page,Model md, HttpServletRequest request){
//		PageHelper.startPage(page,5);
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Article> list=edu_ArticleService.listAll(map);
//		PageInfo<Edu_Article> pageInfo=new PageInfo<Edu_Article>(list);
//		System.out.println(list);
		mv.setViewName("/web/article/article-list");
		mv.addObject("list", list);
//		mv.addObject("page", pageInfo);
		return mv;
	}
	
	@RequestMapping("/wabGetById/{articleId}")
	public ModelAndView getById(@PathVariable("articleId") int articleId){
		ModelAndView mv =new ModelAndView();
		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
		System.out.println(edu_Article);
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
	
//	@RequestMapping("/eadelete")
//	public String delete(int articleId){
//		edu_ArticleService.delete(articleId);
//		return "redirect:ealist";
//	}
//	
//	@RequestMapping("/eagetById")
//	public ModelAndView getById(int articleId){
////		System.out.println("123");
//		ModelAndView mv =new ModelAndView();
//		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
////		System.out.println(edu_Article);
//		Edu_Article_Content edu_Article_Content=edu_Article_ContentService.getById(articleId);
//		mv.setViewName("/back/articleConsultingManagement/articleScienceUpdate");
//		mv.addObject("edu_Article", edu_Article);
//		mv.addObject("edu_Article_Content", edu_Article_Content);
//		return mv;
//	}
//	
//	
//	@RequestMapping("/eaupdate")
//	public String update(Edu_Article edu_Article,HttpServletRequest request){
//		String content=request.getParameter("content");
//		int articleId=Integer.parseInt(request.getParameter("articleId"));
//		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
//		edu_Article_Content.setArticleId(articleId);
//		edu_Article_Content.setContent(content);
//		edu_Article.setEdu_Article_Content(edu_Article_Content);
//		edu_ArticleService.update(edu_Article);
//		System.out.println(edu_Article.getEdu_Article_Content().getContent());
//		return "redirect:ealist";
//	}
//	
//	@RequestMapping("/easave")
//	public String save(Edu_Article edu_Article,HttpServletRequest request){
//		System.out.println("yes");
//		
//		String title=request.getParameter("title");
//		String summary=request.getParameter("summary");
//		int articleType=Integer.parseInt(request.getParameter("articleType"));
//		String author=request.getParameter("author");
//		String source=request.getParameter("source");
//		String imageUrl=request.getParameter("imageUrl");
//		int clickNum=Integer.parseInt(request.getParameter("clickNum"));
//		String publishTime=request.getParameter("publishTime");
//		String content=request.getParameter("content");
//		int sort=Integer.parseInt(request.getParameter("sort"));
//		
//		edu_Article.setTitle(title);
//		edu_Article.setSummary(summary);
//		edu_Article.setArticleType(articleType);
//		edu_Article.setAuthor(author);
//		edu_Article.setSource(source);
//		edu_Article.setImageUrl(imageUrl);
//		edu_Article.setClickNum(clickNum);
//		edu_Article.setPublishTime(Timestamp.valueOf(publishTime));
//		edu_Article.setSort(sort);
//		
//		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
//		edu_ArticleService.save(edu_Article);
//		System.out.println();
//		return "redirect:ealist";
//	}
//	
//	@RequestMapping("/tzsave")
//	public ModelAndView tzsave(){
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("/back/articleConsultingManagement/articleScienceSave");
//		return mv;
//	}
	
//	@RequestMapping("/eaupdate")
//	public String update(Edu_Article_Content edu_Article_Content){
//		edu_Article_ContentService.update(edu_Article_Content);
//		return "redirect:ealist";
//	}
}
