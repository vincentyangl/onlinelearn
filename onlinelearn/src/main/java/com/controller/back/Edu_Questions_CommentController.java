package com.controller.back;

import java.io.UnsupportedEncodingException;
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

import com.bean.Edu_Questions;
import com.bean.Edu_Questions_Comment;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.sym.Name;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_Questions_CommentService;

@Controller
@RequestMapping("/admin/eqcomment")
public class Edu_Questions_CommentController {

	@Autowired
	private Edu_Questions_CommentService edu_Questions_CommentService;

	@RequestMapping("/eqclist")
	public ModelAndView list(@RequestParam(required=true,defaultValue="1") Integer page,Model md,HttpServletRequest request) throws UnsupportedEncodingException{
		PageHelper.startPage(page,5);
		ModelAndView mv =new ModelAndView();
		Map map=new HashMap();
		map=initMap(request,map);
		List<Edu_Questions_Comment> list=edu_Questions_CommentService.listAll(map);
		PageInfo<Edu_Questions_Comment> pageInfo=new PageInfo<Edu_Questions_Comment>(list);
		mv.setViewName("/back/QuestionAnswer/QuestionAnswerReply");
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);
		return mv;
	}


	//·â×°map
	private Map initMap(HttpServletRequest request,Map map) throws UnsupportedEncodingException{
		String id=request.getParameter("id");
		String isBest=request.getParameter("isBest");
		String title=request.getParameter("title");
		if (id!=null&&id.length()>0) {
			map.put("id", Integer.valueOf(id));
			request.setAttribute("id", Integer.valueOf(id));
		}
		if (isBest!=null&&isBest.length()>0&&!isBest.equals("-1")) {
			map.put("isBest", Integer.valueOf(isBest));
			request.setAttribute("isBest", Integer.valueOf(isBest));
		}
		if (title!=null&&title.length()>0) {
			title=new String(title.getBytes("ISO-8859-1"),"utf8");
			System.out.println(title);
			map.put("title", title);
			request.setAttribute("title", title);
		}
		return map;
	}

	@RequestMapping("/eqcdelete")
	public String delete(int id){
		edu_Questions_CommentService.delete(id);
		return "redirect:eqclist";
	}

	@RequestMapping("/eqclistpl")
	public ModelAndView listpl(int id){
		//		System.out.println("ÄãºÃ");
		//		System.out.println(id);
		ModelAndView mv =new  ModelAndView();
		List<Edu_Questions_Comment> lists=edu_Questions_CommentService.listPL(id);
		mv.addObject("lists", lists);
		mv.setViewName("/back/QuestionAnswer/QuestionComment");
		return mv;
	}
	/*	
	@RequestMapping("/eqclistpd")
	public ModelAndView listpd(int id){
		ModelAndView mv =new  ModelAndView();
		List<Edu_Questions_Comment> listpd=edu_Questions_CommentService.getByIdPD(id);
		mv.addObject("listpd", listpd);
		mv.setViewName("");
		return mv;

	}*/

	@RequestMapping("/eqcupdate")
	public String update(Edu_Questions_Comment edu_Questions_Comment,HttpServletRequest request){
		int isBest=Integer.parseInt(request.getParameter("isBest"));
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("isBest:"+isBest);
		if (isBest==1) {
			 if (isBest==1) {
				isBest=0;
			}
		}else{
			int eqid=Integer.parseInt(request.getParameter("QUESTION_ID.id"));
			System.out.println(eqid);
			List<Edu_Questions_Comment > list=edu_Questions_CommentService.getByIdPD(eqid);
			System.out.println(list);
			int a=0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getIsBest()==1) {
				a=1;
				}
			}
			if (a==0) {
				System.out.println(id);
				System.out.println(isBest);
				if (isBest==0) {
					isBest=1;
				}else if (isBest==1) {
					isBest=0;
				}
			}else{
				return "redirect:/admin/equestions/edlist";
			}
		}
		
		edu_Questions_Comment.setId(id);
		edu_Questions_Comment.setIsBest(isBest);
		System.out.println(id);
		System.out.println(isBest);
		edu_Questions_CommentService.update(edu_Questions_Comment);
		
		
		return "redirect:/admin/equestions/edlist";
	}
}
