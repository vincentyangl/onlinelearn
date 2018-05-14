package com.controller.back;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduTeacher;
import com.bean.SysSubject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.Ztree;
import com.service.EduTeacherService;
import com.service.SysSubjectService;
import com.util.JsonUtils;

@Controller
public class EduTeacherController {

	
	@Autowired
	private EduTeacherService eduTeacherService;
	@Autowired
	private SysSubjectService sysSubjectService;
	@RequestMapping("/admin/teacher/teacherList")
	public ModelAndView listAll(HttpServletRequest request,@RequestParam(required=true,defaultValue="1")Integer page,Model md){
		PageHelper.startPage(page, 5);
		ModelAndView mv = new ModelAndView();
		Map map = new HashMap();
		map = getMap(request,map);
		List<EduTeacher> list = eduTeacherService.listAll(map);
		PageInfo<EduTeacher> pageInfo = new PageInfo<EduTeacher>(list);
		mv.addObject("list", list);
		mv.addObject("map", map);
		mv.setViewName("/back/teacher/teacherList");
		mv.addObject("page", pageInfo);
		return mv;
	}
	public Map getMap(HttpServletRequest request,Map map){
		String qname=request.getParameter("qname");
		String startTime=request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		if (qname!=null&&qname.trim().length()>0) {
			request.setAttribute("qname", qname);
			map.put("qname", qname);
		}
		if (startTime!=null&&startTime.trim().length()>0) {
			request.setAttribute("startTime", startTime);
			map.put("startTime", startTime);
		}
		if (endTime!=null&&endTime.trim().length()>0) {
			request.setAttribute("endTime", endTime);
			map.put("endTime", endTime);
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
		int id = Integer.parseInt(request.getParameter("subjectId"));
		SysSubject subject = new SysSubject();
		subject.setSubjectId(id);
		String fileName = file.getOriginalFilename();
		String newPath = path+fileName;
		File newfile = new File(path,fileName);
		Date date = new Date();
		try {
			file.transferTo(newfile);
			eduTeacher.setPicPath(newPath);
			eduTeacher.setUpdateTime(date);
			eduTeacher.setSysSubject(subject);
			eduTeacherService.update(eduTeacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/teacher/teacherList";
	}
	@RequestMapping(value="/admin/teacher/save",method=RequestMethod.POST)
	public String addTeacher(@RequestParam("file")MultipartFile file, EduTeacher eduTeacher, HttpServletRequest request) {
		String path = request.getRealPath("/images/upload/teacher/20150915");
		int id = Integer.parseInt(request.getParameter("subjectId"));
		String fileName = file.getOriginalFilename();
		String newPath = path+fileName;
		SysSubject subject = new SysSubject();
		subject.setSubjectId(id);
		File newfile = new File(path,newPath);
		Date date = new Date();
		try {
			file.transferTo(newfile);
			eduTeacher.setPicPath(newPath);
			eduTeacher.setCreateTime(date);
			eduTeacher.setSysSubject(subject);
			eduTeacherService.save(eduTeacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/teacher/teacherList";
	}
	@RequestMapping("/admin/teacher/getById/{id}")
	public ModelAndView getById(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		List<SysSubject> sysSubjects = sysSubjectService.listAll(new HashMap<>());
		List<Ztree> ztrees = new ArrayList<>();
		for (SysSubject sb : sysSubjects) {
			Ztree ztree = new Ztree();
			ztree.setId(sb.getSubjectId());
			ztree.setpId(sb.getParent_id());
			ztree.setName(sb.getSubjectName());
			ztrees.add(ztree);
		}
		String json = JsonUtils.objectToJson(ztrees);
		mv.addObject("sysSubjects", json);
		EduTeacher eduTeacher = eduTeacherService.getById(id);
		mv.addObject("e", eduTeacher);
		mv.setViewName("/back/teacher/teacherEdit");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/admin/teacher/getTeacherBySubjectId/{subjectId}")
	public List<EduTeacher> getTeacherBySubjectId(@PathVariable("subjectId") Integer subjectId) {
		List<EduTeacher> ets = eduTeacherService.getTeacherBySubjectId(subjectId);
		return ets;
	}
	
	@ResponseBody
	@RequestMapping("/admin/teacher/listTeacher")
	public List<EduTeacher> listTeacher(){
		ModelAndView mv = new ModelAndView();
		List<EduTeacher> list = eduTeacherService.listAll(new HashMap<>());
		mv.addObject("list", list);
		return list;
	}
	
}
