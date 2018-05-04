package com.controller.back;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduCourse;
import com.bean.SysSubject;
import com.service.EduCourseService;
import com.service.SysSubjectService;

@Controller
@RequestMapping("/admin/course")
public class EduCourseController {

	@Autowired
	private EduCourseService eduCourseService;
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/courseList")
	public ModelAndView courseList() {
		ModelAndView mv = new ModelAndView();
		List<EduCourse> eduCourses = eduCourseService.listAll(new HashMap<>());
		mv.addObject("eduCourses", eduCourses);
		mv.setViewName("/back/course/courseList");
		return mv;
	}
	
	@RequestMapping("/toCourseAdd")
	public String toCourseAdd() {
		return "/back/course/courseAdd";
	}
	
	@RequestMapping("/queryCourseList")
	public ModelAndView queryCourseList(String qname,int is_avaliable,int subjectId,String beginTime,String endTime) {
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		if (qname!=null&&qname.trim().length()!=0) {
			map.put("qname", qname);
		}
		if (is_avaliable!=-1) {
			map.put("is_avaliable", is_avaliable);
		}
		if (subjectId!=-1) {
			map.put("subjectId", subjectId);
		}
		if (beginTime!=null&&beginTime.trim().length()!=0) {
			map.put("beginTime", beginTime);
		}
		if (endTime!=null&&endTime.trim().length()!=0) {
			map.put("endTime", endTime);
		}
		List<EduCourse> eduCourses = eduCourseService.listAll(map);
		mv.addObject("eduCourses", eduCourses);
		mv.setViewName("/back/course/courseList");
		return mv;
	}
	
	@RequestMapping("/courseDelete/{course_id}")
	public String courseDelete(@PathVariable("course_id") int course_id) {
		eduCourseService.delete(course_id);
		return "redirect:/admin/course/courseList";
	}
	
	@RequestMapping("/courseAdd")
	public String courseAdd(EduCourse eduCourse,HttpServletRequest request,@RequestParam("logo1")MultipartFile logo1) {
		String teaids = request.getParameter("teaids");
		String [] teacherIds = teaids.split("-");
		String endTime = request.getParameter("endTime");
		System.out.println(endTime+"==================");
		if (endTime==null||endTime.trim().length()==0) {
			eduCourse.setEnd_time(null);
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date end_time;
			try {
				end_time = sdf.parse(endTime);
				eduCourse.setEnd_time(end_time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		String parent_id = request.getParameter("parent_id");
		String subject_id = request.getParameter("subject_id");
		SysSubject subject =null;
		if (subject_id==null||subject_id.trim().length()==0) {
			subject = sysSubjectService.getById(Integer.valueOf(parent_id));
			eduCourse.setSubject_link(","+parent_id+",");
		}else {
			subject = sysSubjectService.getById(Integer.valueOf(subject_id));
			eduCourse.setSubject_link(","+parent_id+","+subject_id+",");
		}
		eduCourse.setSysSubject(subject);
		String logoName = logo1.getOriginalFilename();
		//upload文件夹的路径
		String path = request.getRealPath("/upload/");
		File newLogo = new File(path, logoName);
		try {
			//将客户端上传的文件复制到服务器中
			logo1.transferTo(newLogo);
			eduCourse.setLogo(logoName);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		eduCourseService.save(eduCourse, teacherIds);
		return "redirect:/admin/course/courseList";
	}
	
	@ResponseBody
	@RequestMapping("/toCourseEdit/{course_id}")
	public ModelAndView toCourseEdit(@PathVariable("course_id") int course_id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/back/course/courseEdit");
		EduCourse course = eduCourseService.getById(course_id);
		mv.addObject("course", course);
		return mv;
	}
	
}
