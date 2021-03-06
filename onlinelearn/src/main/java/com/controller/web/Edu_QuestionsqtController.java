package com.controller.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_Questions;
import com.bean.Edu_Questions_Comment;
import com.bean.Edu_Questions_Tag;
import com.bean.Edu_User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_QuestionsService;
import com.service.Edu_Questions_CommentService;
import com.service.Edu_Questions_TagService;
import com.tools.Result;

@Controller
@RequestMapping("/front/equestions")
public class Edu_QuestionsqtController {
	@Autowired
	private Edu_QuestionsService edu_QuestionsService;
	@Autowired
	private Edu_Questions_TagService edu_Questions_TagService;
	@Autowired
	public Edu_Questions_CommentService edu_Questions_CommentService;
	
	@RequestMapping("/edlist/{flag}")
	public ModelAndView listAll(@PathVariable("flag") int flag,HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer page){
//		int type=Integer.parseInt(request.getParameter("type"));
//		System.err.println("type"+type);
		ModelAndView mv =new ModelAndView();
		PageHelper.startPage(page, 5);
		Map map = new HashMap<>();
		map.put("flag", flag);
		List<Edu_Questions> list=edu_QuestionsService.listAll(map);
		PageInfo<Edu_Questions> p=new PageInfo<Edu_Questions>(list);
		List<Edu_Questions_Tag> questionsTagList=edu_Questions_TagService.listAlls();
		mv.addObject("questionsTagList",questionsTagList );
		mv.setViewName("web/questions/questions-list");
		mv.addObject("list", list);
		mv.addObject("page", p);//分页数据
		List<Integer> is = new ArrayList<>();
		for (int i = 1; i <= p.getPages(); i++) {
			is.add(i);
		}
		mv.addObject("totalPage", page);//当前页
		mv.addObject("pageNum", is);//总页数
		return mv;
	}
	
	/**
	 * 热门问答推荐
	 */
		@RequestMapping("/ajax/hotRecommend")
		@ResponseBody
		public Result hotRecommend() {
			Result result=new Result();
			boolean b =true;
			List<Edu_Questions> listquestions=edu_QuestionsService.listAlls();
			result.setEntity(listquestions);
			result.setSuccess(b);
//			System.out.println(result);
			return result;
		}
	
	@RequestMapping("/ajax/hotRecommend/{flag}")
	@ResponseBody
	public Result hotRecommend(@PathVariable("flag") int flag){
		System.out.println("cfcffc");
		Result result = new Result();
		boolean b = true;
		flag =3;
		Map map = new HashMap<>();
		map.put("flag", flag);
		List<Edu_Questions> list =edu_QuestionsService.listAll(map);
		System.out.println("sss"+list);
		result.setEntity(list);
		result.setSuccess(b);
		return result;
	}
	@RequestMapping("/listlb")
	public ModelAndView listlb(){
		ModelAndView mv =new ModelAndView();
		List<Edu_Questions_Tag> listl=edu_Questions_TagService.listAlls();
		mv.addObject("questionsTagList", listl);
		mv.setViewName("web/questions/questions-list");
		return mv;
	}
	
	
//	@RequestMapping("/eddelete")
//	public String delete(int id){
//		edu_QuestionsService.delete(id);
//		return "redirect:edlist";
//	}
//	
//	@RequestMapping("/edsave")
//	public String save(Edu_Questions edu_Questions){
//		edu_QuestionsService.save(edu_Questions);
//		return "redirect:edlist";
//	}
//	
	@RequestMapping("/webedgetById/{id}")
	public ModelAndView getById(@PathVariable("id")int id){
		System.out.println(id);
		ModelAndView mv =new ModelAndView();
		Edu_Questions questions=edu_QuestionsService.getById(id);
		List<Edu_Questions_Comment> questionsCommentRepList=edu_Questions_CommentService.getByIdsx(id);
		mv.addObject("questionsCommentRepList", questionsCommentRepList);
//		List<Edu_Questions_Tag> question=edu_Questions_TagService.getByIdbq(id);
//		mv.addObject("question", question);
//		System.out.println(questions.getEdu_User());
		mv.setViewName("/web/questions/questions-info");
		mv.addObject("questions", questions);
		return mv;
	}
	
//	@RequestMapping("/getByIdsx/{id}")
//	public ModelAndView getByIdsx(@PathVariable("id")int id){
//		System.err.println("你好");
//		System.err.println("id---------"+id);
//		ModelAndView mv =new ModelAndView();
//		List<Edu_Questions_Comment> questionsCommentRepList=edu_Questions_CommentService.getByIdsx(id);
//		mv.addObject("questionsCommentRepList", questionsCommentRepList);
//		System.out.println(questionsCommentRepList);
//		mv.setViewName("/web/questionscomment/questionscomment-ajax-listreply");
//		return mv;
//	}
	
	
	@RequestMapping("/edupdate")
	public String update(Edu_Questions edu_Questions){
		System.out.println(edu_Questions);
		edu_QuestionsService.update(edu_Questions);
		return "redirect:edlist";
	}
	
//	@RequestMapping("/updatedz")
//	public String updatedz(Edu_Questions edu_Questions,HttpServletRequest request){
//		int praiseCount=Integer.parseInt(request.getParameter("praiseCount"));
//		praiseCount=praiseCount+1;
//		edu_Questions.setPraiseCount(praiseCount);
//		edu_QuestionsService.updatedz(edu_Questions);
//		return "/web/questions/questions-info";
//	}
	
	
	/**
	 *	点赞
	 */
	@RequestMapping("/comment/ajax/addPraise")
	@ResponseBody
	public Result updatePraise(HttpServletRequest request) {
		Result result=new Result();
		int targetId=Integer.parseInt(request.getParameter("praise.targetId"));
		int type = Integer.parseInt(request.getParameter("praise.type"));
		System.out.println(targetId);
		System.out.println(type);
		boolean b;
		if (type==1) {
//			System.out.println("dszdsaf");
			edu_QuestionsService.updatedz(targetId);
			b=true;
			result.setSuccess(b);
		}else{
//			System.out.println("sadcacca");
			edu_Questions_CommentService.updatedzc(targetId);
			b=true;
			result.setSuccess(b);
		}			
		return result;
	}

	/**
	 * 提问前先登录 
	 */
	@RequestMapping("/toadd")
	public ModelAndView toadd(){
		ModelAndView mv =new ModelAndView();
		List<Edu_Questions_Tag> edu_Questions_Tags=edu_Questions_TagService.listtj();
		mv.addObject("edu_Questions_Tags", edu_Questions_Tags);
		mv.setViewName("/web/questions/questions-add");
		return mv;
	}
	
	/**
	 * 提交问答
	 */
	@RequestMapping("/ajax/add")
	@ResponseBody
	public Result add(HttpSession session,HttpServletRequest request){
		System.out.println("1234");
		int type=Integer.parseInt(request.getParameter("type"));
		String a[]= request.getParameter("questionsTag").split(",");
		int b[] = new int [a.length];
		for(int i=1;i<a.length;i++){
			b[i]=Integer.parseInt(a[i]);	
		}
			Result result = new Result();
			Edu_User  user=	(Edu_User) session.getAttribute("login_success");
			Edu_Questions questions = new Edu_Questions();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date add_time = null;
			try {
				add_time = df.parse(df.format(new Date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			questions.setEdu_User(user);
			questions.setTitle(request.getParameter("title"));
			questions.setContent(request.getParameter("content"));
			questions.setType(type);
			questions.setStatus(0);
			questions.setReplyCount(0);
			questions.setBrowseCount(0);
			questions.setPraiseCount(0);
			questions.setAddTime(add_time);
			edu_QuestionsService.save(questions);
			int qid =edu_QuestionsService.getMaxId();
			for (int i = 1; i < b.length; i++) {
				Map map = new HashMap<>();
				int tid = b[i];
				map.put("qid", qid);
				map.put("tid", tid);
				edu_QuestionsService.saveRelation(map);
			}
			result.setEntity(qid);
			result.setSuccess(true);
			return result;
		}
	
	/**
	 * 添加回答评论
	 */
	@RequestMapping("/ajax/addComment")
	@ResponseBody
	public Result addComment(HttpSession session,HttpServletRequest request){
		Result result = new Result();
		Edu_User  user=	(Edu_User) session.getAttribute("login_success");
		Edu_Questions_Comment comment = new Edu_Questions_Comment();
		Edu_Questions questions = new Edu_Questions();
		int id=Integer.parseInt(request.getParameter("questionsComment.questionId"));
		String content=request.getParameter("questionsComment.content");
		questions.setId(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date add_time = null;
		try {
			add_time = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    comment.setEdu_User(user);
	    comment.setEdu_Questions(questions);
	    comment.setContent(content);
	    comment.setIsBest(0);
	    comment.setReplyCount(0);
	    comment.setPraiseCount(0);
	    comment.setAddTime(add_time);
	    comment.setCommentId(0);
	    edu_Questions_CommentService.save(comment);
	    System.out.println(id);
//	    edu_Questions_CommentService.updatehf(id);
	    edu_QuestionsService.updatehfs(id);
	    Boolean b=true;
	    result.setSuccess(b);
		return result;
	}
	
	@RequestMapping("/ajax/list")
	public ModelAndView list(HttpServletRequest request){
		int id=Integer.parseInt(request.getParameter("questionsComment.questionId"));
		ModelAndView mv=new ModelAndView();
		List<Edu_Questions_Comment> comments1 = edu_Questions_CommentService.getById2(id);
		List<Edu_Questions_Comment> comments2 = edu_Questions_CommentService.getById3(id);
		mv.addObject("comments1", comments1);
		mv.addObject("comments2", comments2);
		mv.setViewName("/web/questionscomment/questionscomment-ajax-list");
		return mv;
	}
	
	
	/**
	 * 添加回答评论的评论(子评论)
	 */
	@RequestMapping("/ajax/addReply")
	@ResponseBody
	public Result addReply(HttpServletRequest request,HttpSession session){
		System.out.println("123123");
		Result result = new Result();
		Edu_User  user=	(Edu_User) session.getAttribute("login_success");
		Edu_Questions_Comment comment = new Edu_Questions_Comment();
		Edu_Questions questions = new Edu_Questions();
		int CommentId=Integer.parseInt(request.getParameter("questionsComment.commentId"));
		questions.setId(0);	
		comment.setEdu_User(user);
		comment.setEdu_Questions(questions);
		comment.setContent(request.getParameter("questionsComment.content"));
		comment.setIsBest(0);
		comment.setReplyCount(0);
		comment.setPraiseCount(0);
		comment.setAddTime(new Date());
		comment.setCommentId(CommentId);
		edu_Questions_CommentService.save(comment);
		edu_Questions_CommentService.updatehf(CommentId);
		Boolean b=true;
		result.setSuccess(b);
		return result;
	}
	
	/**
	*根据问答回复id  获取子评论 
	*/
	@RequestMapping("/ajax/getCommentById/{commentId}")
	@ResponseBody
	public ModelAndView getCommentById(@PathVariable("commentId")int commentId){
		System.out.println("123"+commentId);
		ModelAndView mv = new ModelAndView();
		List<Edu_Questions_Comment> comments = edu_Questions_CommentService.getListById(commentId);
		System.out.println(comments);
		mv.addObject("comments", comments);
		mv.setViewName("web/questionscomment/questionscomment-ajax-listreply");
		return mv;
	}
}
