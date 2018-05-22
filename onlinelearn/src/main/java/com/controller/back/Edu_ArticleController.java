package com.controller.back;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Article;
import com.bean.Edu_Article_Content;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_ArticleService;
import com.service.Edu_Article_ContentService;

@Controller
@RequestMapping("/admin/earticle")
public class Edu_ArticleController {

	@Autowired
	private Edu_ArticleService edu_ArticleService;
	@Autowired
	private Edu_Article_ContentService edu_Article_ContentService;

	@RequestMapping("/articleList")
	public ModelAndView list(@RequestParam(required=true,defaultValue="1") Integer page,Model md, HttpServletRequest request){
		PageHelper.startPage(page,5);
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Article> list=edu_ArticleService.listAll(map);
		PageInfo<Edu_Article> pageInfo=new PageInfo<Edu_Article>(list);
		mv.setViewName("/back/articleConsultingManagement/articleScienceList");
		mv.addObject("list", list);
		mv.addObject("map", map);
		mv.addObject("page", pageInfo);
		return mv;
	}

	private Map initMap(HttpServletRequest request,Map map){
		String title=request.getParameter("title");
		String articleType=request.getParameter("articleType");
		if (title!=null&&title.trim().length()>0) {
			map.put("title", title);
			request.setAttribute("title", title);
		}
		if (articleType!=null&&articleType.length()>0) {
			map.put("articleType", Integer.valueOf(articleType));
			request.setAttribute("articleType", Integer.valueOf(articleType));
		}
		return map;
	}

	@RequestMapping("/delete/{articleId}")
	public String delete(@PathVariable("articleId")int articleId){
		edu_ArticleService.delete(articleId);
		return "redirect:/admin/earticle/articleList";
	}

	@RequestMapping("/getById/{articleId}")
	public ModelAndView getById(@PathVariable("articleId")int articleId){
		ModelAndView mv =new ModelAndView();
		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
		Edu_Article_Content edu_Article_Content=edu_Article_ContentService.getById(articleId);
		mv.setViewName("/back/articleConsultingManagement/articleScienceEdit");
		mv.addObject("edu_Article", edu_Article);
		mv.addObject("edu_Article_Content", edu_Article_Content);
		return mv;
	}

	@RequestMapping("/update")
	public String update(@RequestParam("file")MultipartFile file, Edu_Article edu_Article,Edu_Article_Content edu_Article_Content,HttpServletRequest request) throws Exception{
		String hidden = request.getParameter("hidden");
		if(!file.isEmpty()) {
			String path = request.getRealPath("/images/upload/article/");
			String filename = file.getOriginalFilename();
			File filepath = new File(path,filename);         
			if (!filepath.getParentFile().exists()) { 
				filepath.getParentFile().mkdirs();
			}
			try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} 
			edu_Article.setImageUrl("/images/upload/article/"+filename);
		}else{
			edu_Article.setImageUrl(hidden);
		}
		
		edu_Article_Content.setArticleId(edu_Article.getArticleId());
		edu_Article.setEdu_Article_Content(edu_Article_Content);
		edu_ArticleService.update(edu_Article);
		edu_ArticleService.updateContent(edu_Article);
		return "redirect:/admin/earticle/articleList";
	}




	@RequestMapping("/save")
	public String save(Edu_Article edu_Article,Edu_Article_Content edu_Article_Content,@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception{
		edu_Article.setEdu_Article_Content(edu_Article_Content);;
		if(!file.isEmpty()) {
			String path = request.getRealPath("/images/upload/article/");
			String filename = file.getOriginalFilename();
			File filepath = new File(path,filename);         
			if (!filepath.getParentFile().exists()) { 
				filepath.getParentFile().mkdirs();
			}
			try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} 
			edu_Article.setImageUrl("/images/upload/article/"+filename);
		}
		edu_Article.setCreateTime(new Date());
		edu_ArticleService.save(edu_Article);
		edu_ArticleService.saveContent(edu_Article);
		return "redirect:/admin/earticle/articleList";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "/back/articleConsultingManagement/articleScienceAdd";
	}
	
}