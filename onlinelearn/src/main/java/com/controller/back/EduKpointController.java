package com.controller.back;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.EduKpoint;
import com.bean.EduTeacher;
import com.service.EduKpointService;
import com.service.EduTeacherService;
import com.util.JsonUtils;
import com.util.ObjectUtils;

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
		mv.addObject("course_id", course_id);
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
				ek.setContent(eduKpoint.getContent());
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
	
	@RequestMapping("/toKpointAdd/{id}/{courseId}")
	public ModelAndView toKpointAdd(@PathVariable("id") int id,@PathVariable("courseId") int courseId) {
		ModelAndView mv = new ModelAndView();
		int pId = 0;
		if (id==-1) {
			pId = 0;
		}else {
			pId = id;
		}
		List<EduTeacher> ts = eduTeacherService.listAll(new HashMap<>());
		mv.addObject("ts", ts);
		mv.addObject("courseId", courseId);
		mv.addObject("pId", pId);
		mv.addObject("mid", id);
		mv.setViewName("/back/kpoint/kpointAdd");
		return mv;
	}
	
	@RequestMapping("/storeVideo")
	@ResponseBody
	public String storeVideo(@RequestParam("uploadfile")MultipartFile file,HttpServletRequest request) {
		System.out.println("00===================");
		String pathRoot = request.getSession().getServletContext().getRealPath("upload/video"); 
		 String filename=file.getOriginalFilename();  
		 if(!file.isEmpty()){  
			 //生成uuid作为文件名称  
			 String uuid = UUID.randomUUID().toString().replaceAll("-",""); 
			 filename=uuid+filename.substring(filename.lastIndexOf("."));
			 System.out.println("filename:"+filename);
			 File newfile=new File(pathRoot,filename);
			 try {
				 if(!newfile.exists()){
					 newfile.createNewFile();
				 }
				 file.transferTo(newfile);
			 } catch (Exception e) {
				 e.printStackTrace();
			 }  
		 }  
		return filename;
	}
	
	@RequestMapping("/kpointVideoEdit")
	public String kpointVideoEdit(Model model,EduKpoint eduKpoint,HttpServletRequest request) {
		EduKpoint ek = eduKpointService.getById(eduKpoint.getId());
		String videourl2 = request.getParameter("videourl2");
		if (ObjectUtils.isNotNull(videourl2)) {
			ek.setVideoUrl("/upload/video/"+videourl2);
		}
		ek.setName(eduKpoint.getName());
		ek.setSort(eduKpoint.getSort());
		ek.setPlayTime(eduKpoint.getPlayTime());
		System.out.println(eduKpoint.getIsFree()+"==========="+request.getParameter("tid"));
		ek.setIsFree(eduKpoint.getIsFree());
		EduTeacher eduTeacher = new EduTeacher();
		eduTeacher.setId(Integer.valueOf(request.getParameter("tid")));
		ek.setEduTeacher(eduTeacher);
		eduKpointService.update(ek);
		model.addAttribute("courseId",ek.getCourseId());
		return "/back/kpoint/success";
	}
	
	@RequestMapping("/kpointAdd")
	public String kpointAdd(EduKpoint eduKpoint,Model model) {
		eduKpointService.save(eduKpoint);
		model.addAttribute("courseId",eduKpoint.getCourseId());
		return "/back/kpoint/success";
	}
	
	@RequestMapping("/kpointDelete/{id}/{courseId}")
	public String kpointDelete(@PathVariable("id") int id,@PathVariable("courseId") int courseId,Model model) {
		model.addAttribute("courseId",courseId);
		eduKpointService.delete(id);
		return "/back/kpoint/success";
	}
	
}
