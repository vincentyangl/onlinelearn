package com.controller.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.EduTeacher;
import com.bean.PageCourseBean;
import com.bean.QueryCourse;
import com.bean.SysSubject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EduCourseService;
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
	
	@RequestMapping("/course")
	public ModelAndView courseList(@ModelAttribute("queryCourse") QueryCourse queryCourse,@RequestParam(required=true,defaultValue="1")Integer currentPage) {
		
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map.put("parent_id", 0);
		//��ѯרҵ
		List<SysSubject> subjectList = sysSubjectService.listAll(map);
		//��ѯ��ʦ
		List<EduTeacher> teacherList = eduTeacherService.listAll(map);
		//��ѯ��רҵ
		List<SysSubject> sonSubjectList = null;
		if (ObjectUtils.isNotNull(queryCourse.getSubjectId())) {
			SysSubject subject = sysSubjectService.getById(queryCourse.getSubjectId());
			if (subject.getParent_id()==0) {
				sonSubjectList = sysSubjectService.getChildNode(queryCourse.getSubjectId());
			}else {
				sonSubjectList = sysSubjectService.getChildNode(subject.getParent_id());
				mv.addObject("subjectParentId", subject.getParent_id());//����id
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
		//ֻ��ѯ�ϼܵ�
		map.put("is_avaliable", 1);
		//��ҳ
		PageHelper.startPage(currentPage, 12);
		//��ѯ�γ�
		List<EduCourse> eduCourses = eduCourseService.listAll(map);
		//��ҳת��
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
		mv.setViewName("web/course/courses-list");
		return mv;
	}
	
	
}
