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
	
	@RequestMapping("/ealist")
	public ModelAndView list(@RequestParam(required=true,defaultValue="1") Integer page,Model md, HttpServletRequest request){
		PageHelper.startPage(page,5);
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Article> list=edu_ArticleService.listAll(map);
		PageInfo<Edu_Article> pageInfo=new PageInfo<Edu_Article>(list);
//		System.out.println(list);
		mv.setViewName("/back/articleConsultingManagement/articleScience");
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);
		return mv;
	}
	
	//map
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
	
	@RequestMapping("/eadelete")
	public String delete(int articleId){
		edu_ArticleService.delete(articleId);
		return "redirect:ealist";
	}
	
	@RequestMapping("/eagetById")
	public ModelAndView getById(int articleId){
		ModelAndView mv =new ModelAndView();
		Edu_Article edu_Article=edu_ArticleService.getById(articleId);
		Edu_Article_Content edu_Article_Content=edu_Article_ContentService.getById(articleId);
		mv.setViewName("/back/articleConsultingManagement/articleScienceUpdate");
		mv.addObject("edu_Article", edu_Article);
		mv.addObject("edu_Article_Content", edu_Article_Content);
//		System.out.println(edu_Article_Content.getContent());
		return mv;
	}
	
	@RequestMapping("/eaupdate")
	public String update(@RequestParam("file")MultipartFile file, Edu_Article edu_Article,HttpServletRequest request) throws Exception{
		System.out.println("123");
		if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getRealPath("/images/upload/article/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);         
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            edu_Article.setImageUrl("/images/upload/article/"+filename);
		}

		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
		String content=request.getParameter("content");
		int articleId=Integer.parseInt(request.getParameter("articleId"));
		edu_Article_Content.setArticleId(edu_Article.getArticleId());
		edu_Article_Content.setContent(content);
		edu_Article_Content.setArticleId(articleId);
		edu_Article.setEdu_Article_Content(edu_Article_Content);
		edu_ArticleService.update(edu_Article);
		edu_ArticleService.updateContent(edu_Article);
		System.out.println(edu_Article.getEdu_Article_Content().getContent());
		return "redirect:ealist";
	}
	


	
	@RequestMapping("/easave")
	public String save(Edu_Article edu_Article,@RequestParam("file")MultipartFile file,HttpServletRequest request) throws Exception{
		System.out.println("yes");
		String content=request .getParameter("content");
		Edu_Article_Content edu_Article_Content=new Edu_Article_Content();
		edu_Article_Content.setContent(content);
		edu_Article.setEdu_Article_Content(edu_Article_Content);;
		if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getRealPath("/images/upload/article/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);         
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
            edu_Article.setImageUrl("/images/upload/article/"+filename);
		}
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		edu_Article.setCreateTime(new Date());
		edu_ArticleService.save(edu_Article);
		edu_ArticleService.saveContent(edu_Article);
		System.out.println(edu_Article);
		return "redirect:/admin/earticle/ealist";
	}

	
	@RequestMapping("/tzsave")
	public String tzsave(){
		return "/back/articleConsultingManagement/articleScienceSave";
	}

}
