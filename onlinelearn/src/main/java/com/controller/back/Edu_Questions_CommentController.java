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
					map.put("titie", title);
					request.setAttribute("titie", title);
				}
				return map;
			}
	
	@RequestMapping("/eqcdelete")
	public String delete(int id){
		edu_Questions_CommentService.delete(id);
		return "redirect:eqclist";
	}
}
