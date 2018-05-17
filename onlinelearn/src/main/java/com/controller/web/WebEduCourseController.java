package com.controller.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduComment;
import com.bean.EduCourse;
import com.bean.EduCourseFavorites;
import com.bean.EduKpoint;
import com.bean.EduTeacher;
import com.bean.Edu_User;
import com.bean.PageCourseBean;
import com.bean.QueryCourse;
import com.bean.SysSubject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EduCommentService;
import com.service.EduCourseFavoritesService;
import com.service.EduCourseService;
import com.service.EduKpointService;
import com.service.EduTeacherService;
import com.service.SysSubjectService;
import com.util.ObjectUtils;

@Controller
@RequestMapping("/front")
public class WebEduCourseController {

	@Autowired
	private SysSubjectService sysSubjectService;
	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private EduCourseService eduCourseService;
	@Autowired
	private EduKpointService eduKpointService;
	@Autowired
	private EduCourseFavoritesService eduCourseFavoritesService;
	
	@RequestMapping("/course")
	public ModelAndView courseList(@ModelAttribute("queryCourse") QueryCourse queryCourse,@RequestParam(required=true,defaultValue="1")Integer currentPage) {
		
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map.put("parent_id", 0);
		//查询专业
		List<SysSubject> subjectList = sysSubjectService.listAll(map);
		//查询老师
		List<EduTeacher> teacherList = eduTeacherService.listAll(map);
		//查询子专业
		List<SysSubject> sonSubjectList = null;
		if (ObjectUtils.isNotNull(queryCourse.getSubjectId())) {
			SysSubject subject = sysSubjectService.getById(queryCourse.getSubjectId());
			if (subject.getParent_id()==0) {
				sonSubjectList = sysSubjectService.getChildNode(queryCourse.getSubjectId());
			}else {
				sonSubjectList = sysSubjectService.getChildNode(subject.getParent_id());
				mv.addObject("subjectParentId", subject.getParent_id());//父级id
			}
			map.put("subjectId", queryCourse.getSubjectId());
		}
		mv.addObject("sonSubjectList", sonSubjectList);
		if (ObjectUtils.isNotNull(queryCourse.getTeacherId())) {
			map.put("teacherId", queryCourse.getTeacherId());
		}
		if (ObjectUtils.isNotNull(queryCourse.getPageViewCount())) {
			map.put("pageViewCount", queryCourse.getPageViewCount());
		}
		if (ObjectUtils.isNotNull(queryCourse.getAddTime())) {
			map.put("addTime", queryCourse.getAddTime());
		}
		if (ObjectUtils.isNotNull(queryCourse.getCurrentPrice())) {
			map.put("currentPrice", queryCourse.getCurrentPrice());
		}
		if (queryCourse.getCourseName()!=null&&queryCourse.getCourseName().trim().length()!=0) {
			map.put("qname", queryCourse.getCourseName());
		}
		//只查询上架的
		map.put("is_avaliable", 1);
		//分页
		PageHelper.startPage(currentPage, 12);
		//查询课程
		List<EduCourse> eduCourses = eduCourseService.listAll(map);
		//分页转换
		PageInfo<EduCourse> info = new PageInfo<>(eduCourses);
		PageCourseBean page = new PageCourseBean();
		page.setCurrentPage(info.getPageNum());
		page.setPageSize(info.getPageSize());
		page.setTotalPageSize(info.getPages());
		page.setTotalResultSize(info.getTotal());
		mv.addObject("subjectList", subjectList);
		mv.addObject("page", page);
		mv.addObject("teacherList", teacherList);
		mv.addObject("queryCourse", queryCourse);
		mv.addObject("courseList", eduCourses);
		mv.setViewName("/web/course/courses-list");
		return mv;
	}
	
	@RequestMapping("/couinfo/{course_id}")
	public ModelAndView couinfo(@PathVariable("course_id") int course_id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/web/course/course-infor");
		EduCourse course = eduCourseService.getById(course_id);
		List<EduTeacher> teacherList = eduTeacherService.getTeacherBySubjectId(course.getSysSubject().getSubjectId());
		List<EduKpoint> parentKpointList = eduKpointService.getByCourseId(course_id);
		boolean isFavorites = false;
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		if (ObjectUtils.isNotNull(user)) {
			Map map = new HashMap<>();
			map.put("courseId", course_id);
			map.put("userId", user.getUserId());
			List<EduCourseFavorites> favoriteList = eduCourseFavoritesService.listAll(map);
			if (favoriteList.size()>0) {
				isFavorites=true;
			}
		}
		mv.addObject("isFavorites", isFavorites);
		mv.addObject("course", course);
		mv.addObject("teacherList", teacherList);
		mv.addObject("parentKpointList", parentKpointList);
		return mv;
	}
	
	@RequestMapping("/play/{course_id}")
	public ModelAndView play(@PathVariable("course_id") int course_id,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/web/course/player-video");
		EduCourse course = eduCourseService.getById(course_id);
		List<EduTeacher> teacherList = eduTeacherService.getTeacherBySubjectId(course.getSysSubject().getSubjectId());
		List<EduKpoint> parentKpointList = eduKpointService.getByCourseId(course_id);
		mv.addObject("course", course);
		mv.addObject("teacherList", teacherList);
		mv.addObject("parentKpointList", parentKpointList);
		return mv;
	}
	
	@RequestMapping("/ajax/getKopintHtml")
	public String getKopintHtml(Model model, HttpServletRequest request,@RequestParam("kpointId") int kpointId, HttpServletResponse response) {
		System.out.println(kpointId+"节点id");
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out=response.getWriter();
			EduKpoint courseKpoint= eduKpointService.getById(kpointId);
			// 当传入数据不正确时直接返回
			if (ObjectUtils.isNull(courseKpoint)) {
				out.println("<script>var noCover=true; dialog dialog('提示','参数错误！',1);</script>");
				return null;
			}
			//获取课程
			EduCourse course = eduCourseService.getById(courseKpoint.getCourseId());
			if (course==null) {
				return "/web/course/videocode";
			}
			model.addAttribute("courseKpoint",courseKpoint);
			model.addAttribute("course",course);
				// 视频url
			String videourl = courseKpoint.getVideoUrl();
			System.out.println("视频url"+videourl);
				// 播放类型
			String videotype = courseKpoint.getVideoType();
				// 放入数据
			model.addAttribute("videourl", videourl);
			model.addAttribute("videotype", videotype);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/web/course/videocode";
	}
	
}
