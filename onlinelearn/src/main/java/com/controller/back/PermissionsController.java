package com.controller.back;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.Permissions;
import com.service.PermissionsService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/permissions")
public class PermissionsController {

	@Autowired
	private PermissionsService permissionsService;
	
	@RequestMapping("/ztreeList")
	public String ztreeList(HttpServletRequest request) {
		List<Permissions> permissions = permissionsService.listAll(new HashMap<>());
		String json = JsonUtils.objectToJson(permissions);
		request.setAttribute("permissions", json);
//		System.out.println(json);
		return "/back/permissions/permissionsList";
	}
	
	@RequestMapping("/addPermissions")
	public String addPermissions(Permissions per) {
		permissionsService.save(per);
		return "redirect:/ztreeList";
	}
	
	@RequestMapping("/updatePermissions")
	public String updatePermissions(Permissions per) {
		permissionsService.updateName(per);
		return "redirect:/ztreeList";
	}
	
	@RequestMapping("/isDelete")
	@ResponseBody
	public List<Permissions> isDelete(int id) {
//		System.out.println("3333");
		List<Permissions> permissions = permissionsService.getChildNode(id);
		return permissions;
	}
	
	@RequestMapping("/deletePermissions/{id}")
	public String deletePermissions(@PathVariable("id") int id) {
		permissionsService.delete(id);
		return "redirect:/ztreeList";
	}
	
}
