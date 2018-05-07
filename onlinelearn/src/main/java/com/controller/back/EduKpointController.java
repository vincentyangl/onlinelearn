package com.controller.back;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduKpoint;
import com.bean.EduTeacher;
import com.service.EduKpointService;
import com.service.EduTeacherService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/kpoint")
public class EduKpointController {

	@Autowired
	private EduKpointService eduKpointService;
	@Autowired
	private EduTeacherService eduTeacherService;
	
	@RequestMapping("/kpointList/{course_id}")
	public ModelAndView kpointList(@PathVariable("course_id") Integer course_id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/back/kpoint/kpointList");
		List<EduKpoint> eduKpoints = eduKpointService.getByCourseId(course_id);
		String json = JsonUtils.objectToJson(eduKpoints);
		mv.addObject("eduKpoints", json);
		return mv;
	}
	
	@RequestMapping("/toKpointEdit/{id}")
	public ModelAndView toKpointEdit(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		EduKpoint p = eduKpointService.getById(id);
		mv.addObject("p", p);
		mv.setViewName("/back/kpoint/kpointEdit");
		return mv;
	}
	
	@RequestMapping("/kpointEdit")
	public String kpointEdit(Model model,EduKpoint eduKpoint,HttpServletRequest request,@RequestParam("videoUrl1")MultipartFile videoUrl1) {
		EduKpoint ek = eduKpointService.getById(eduKpoint.getId());
		ek.setName(eduKpoint.getName());
		if (ek.getKpointType()==1) {
			if (ek.getFileType().equals("TXT")) {
				ek.setContent(eduKpoint.getContent());
			}
			if (ek.getFileType().equals("VIDEO")) {
				ek.setSort(eduKpoint.getSort());
				ek.setPlayTime(eduKpoint.getPlayTime());
				System.out.println(eduKpoint.getIsFree()+"==========="+request.getParameter("tid"));
				ek.setIsFree(eduKpoint.getIsFree());
				EduTeacher eduTeacher = new EduTeacher();
				eduTeacher.setId(Integer.valueOf(request.getParameter("tid")));
				ek.setEduTeacher(eduTeacher);
			}
			String url = videoUrl1.getOriginalFilename();
			if (url!=null&&url.trim().length()!=0) {
				//upload文件夹的路径
				String path = request.getRealPath("/upload/text/");
				File newUrl = new File(path, url);
				try {
					//将客户端上传的文件复制到服务器中
					videoUrl1.transferTo(newUrl);
					ek.setVideoUrl(url);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		eduKpointService.update(ek);
		model.addAttribute("courseId",ek.getCourseId());
		return "/back/kpoint/success";
//		return "redirect:/admin/kpoint/kpointList/"+ek.getCourseId();
	}
	
	@RequestMapping("/kpointCatalogEdit")
	public String kpointCatalogEdit(Model model,EduKpoint eduKpoint) {
		EduKpoint ek = eduKpointService.getById(eduKpoint.getId());
		ek.setName(eduKpoint.getName());
		ek.setSort(eduKpoint.getSort());
		eduKpointService.update(ek);
		model.addAttribute("courseId",ek.getCourseId());
		return "/back/kpoint/success";
	}
	
	@RequestMapping("/toBlank")
	public String toBlank() {
		return "/back/kpoint/blank";
	}
	
	@RequestMapping("/toKpointAdd/{id}")
	public ModelAndView toKpointAdd(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		List<EduTeacher> ts = eduTeacherService.listAll(new HashMap<>());
		mv.addObject("ts", ts);
		mv.setViewName("/back/kpoint/kpointAdd");
		return mv;
	}
	
}
