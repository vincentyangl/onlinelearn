package com.controller.back;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_website_images_type;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_website_images_typeService;

@Controller
@RequestMapping("/admin/imagetype")
public class Edu_website_imgesTypeController { //图片类型管理

	@Autowired
	private Edu_website_images_typeService edu_website_images_typeService;

	@RequestMapping("/getList")
	public ModelAndView getList(@RequestParam(required=true,defaultValue="1") Integer page) {
		PageHelper.startPage(page,10);
		ModelAndView mv=new ModelAndView();
		List<Edu_website_images_type> list=edu_website_images_typeService.listAll();
		PageInfo<Edu_website_images_type>pageInfo=new PageInfo<>(list);
		mv.addObject("page", pageInfo);
		mv.addObject("list", list);
		mv.setViewName("/back/imgesType/imgesTypeindex");
		return mv;
	}

	@RequestMapping("/jump")
	public String jump() {

		return "/back/imgesType/imagesTypeSave";
	}

	@RequestMapping("/save/{type_name}")
	public String option(@PathVariable("type_name") String type_name, Edu_website_images_type edu_website_images_type,HttpServletRequest request) {

		//		System.out.println(type_name);
		edu_website_images_type.setType_name(type_name);
		edu_website_images_typeService.save(edu_website_images_type);  
		return "redirect:/admin/imagetype/getList";
	}

	@RequestMapping("/delete/{type_id}")
	public String delete(@PathVariable("type_id") int type_id) {
		edu_website_images_typeService.delete(type_id);
		return "redirect:/admin/imagetype/getList";
	}

	@RequestMapping("/getById/{type_id}")
	public ModelAndView getById(@PathVariable("type_id") int type_id ,@RequestParam(required=true,defaultValue="1") Integer page) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,10);
		List<Edu_website_images_type> list=edu_website_images_typeService.listAll();
		PageInfo<Edu_website_images_type>pageInfo=new PageInfo<>(list);
		Edu_website_images_type type= edu_website_images_typeService.getById(type_id);
		int k=0;
		mv.addObject("k", k);
		mv.addObject("type", type);
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);
		mv.setViewName("/back/imgesType/imgesTypeindex");
		return mv;
	}

	@RequestMapping("/update")
	public String update(Edu_website_images_type edu_website_images_type) {
		//		System.out.println("update");
		edu_website_images_typeService.update(edu_website_images_type);
		return "redirect:/admin/imagetype/getList";
	}


}
