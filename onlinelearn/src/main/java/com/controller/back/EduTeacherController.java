package com.controller.back;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduTeacher;
import com.bean.SysSubject;
import com.service.EduTeacherService;
import com.service.SysSubjectService;

@Controller
public class EduTeacherController {

	
	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/admin/teacher/teacherList")
	public ModelAndView listAll(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap<>();
		map = getMap(request,map);
		List<EduTeacher> list = eduTeacherService.listAll(map);
		mv.addObject("list", list);
		mv.setViewName("/back/teacher/teacherList");
		return mv;
	}
	public Map getMap(HttpServletRequest request,Map map){
		String qname=request.getParameter("qname");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		System.out.println(qname);
		map.put("qname", qname);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		if (qname!=null) {
			request.setAttribute("qname", qname);
		}
		if (startTime!=null) {
			request.setAttribute("startTime", startTime);
		}
		if (endTime!=null) {
			request.setAttribute("endTime", endTime);
		}
		return map;
	}
	@RequestMapping("/admin/teacher/delete/{id}")
	public String delete(@PathVariable("id")int id){
		eduTeacherService.delete(id);
		return "redirect:/admin/teacher/teacherList";
	}
	@RequestMapping("/admin/teacher/update")
	public String update(@RequestParam("file")MultipartFile file, EduTeacher eduTeacher, HttpServletRequest request){
		String path = request.getRealPath("/images/upload/teacher/20150915");
		String fileName = file.getOriginalFilename();
		String newPath = path+fileName;
		File newfile = new File(path,fileName);
		Date date = new Date();
		try {
			file.transferTo(newfile);
			eduTeacher.setPicPath(newPath);
			eduTeacher.setUpdateTime(date);
			eduTeacherService.update(eduTeacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/teacher/teacherList";
	}
	@RequestMapping(value="/admin/teacher/save",method=RequestMethod.POST)
	public String addTeacher(@RequestParam("file")MultipartFile file, EduTeacher eduTeacher, HttpServletRequest request) {
		String path = request.getRealPath("/images/upload/teacher/20150915");
		String fileName = file.getOriginalFilename();
		String newPath = path+fileName;
		File newfile = new File(path,fileName);
		Date date = new Date();
		try {
			file.transferTo(newfile);
			eduTeacher.setPicPath(newPath);
			eduTeacher.setCreateTime(date);
			System.out.println(eduTeacher.getName());
			eduTeacherService.save(eduTeacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/teacher/teacherList";
	}
	@RequestMapping("/admin/teacher/getById/{id}")
	public ModelAndView getById(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		EduTeacher eduTeacher = eduTeacherService.getById(id);
		List<SysSubject> lsit = sysSubjectService.listAll(new HashMap());
		mv.addObject("list", lsit);
		System.out.println(lsit);
		mv.addObject("e", eduTeacher);
		mv.setViewName("/back/teacher/teacherEdit");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("getTeacherBySubjectId/{subjectId}")
	public List<EduTeacher> getTeacherBySubjectId(@PathVariable("subjectId") Integer subjectId) {
		List<EduTeacher> ets = eduTeacherService.getTeacherBySubjectId(subjectId);
		return ets;
	}
}
