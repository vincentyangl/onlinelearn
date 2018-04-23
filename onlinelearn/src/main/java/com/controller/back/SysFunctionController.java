package com.controller.back;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SysFunction;
import com.service.SysFunctionService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/permissions")
public class SysFunctionController {

	@Autowired
	private SysFunctionService sysFunctionService;
	
	@RequestMapping("/ztreeList/{state}")
	public ModelAndView ztreeList(@PathVariable("state") Integer state, HttpServletRequest request) {
		List<SysFunction> sysFunctions = sysFunctionService.listAll(new HashMap<>());
		String json = JsonUtils.objectToJson(sysFunctions);
		request.setAttribute("sysFunctions", json);
		ModelAndView mv = new ModelAndView();
		if (state==1) {
			mv.setViewName("/back/permissions/permissionsList");
		}
		if (state==2) {
			mv.setViewName("/back/role/roleList");
		}
		return mv;
	}
	
	@RequestMapping("/addPermissions")
	public String addPermissions(SysFunction sysFunction) {
		sysFunctionService.save(sysFunction);
		return "redirect:/admin/permissions/ztreeList";
	}
	
	@RequestMapping("/updatePermissions")
	public String updatePermissions(SysFunction sysFunction) {
		sysFunctionService.updateName(sysFunction);
		return "redirect:/admin/permissions/ztreeList";
	}
	
	@RequestMapping("/isDelete")
	@ResponseBody
	public List<SysFunction> isDelete(int id) {
		System.out.println("3333");
		List<SysFunction> sysFunctions = sysFunctionService.getChildNode(id);
		return sysFunctions;
	}
	
	@ResponseBody
	@RequestMapping("/deletePermissions/{id}")
	public String deletePermissions(@PathVariable("id") int id) {
		sysFunctionService.delete(id);
		return "redirect:/admin/permissions/ztreeList";
	}
	
}
