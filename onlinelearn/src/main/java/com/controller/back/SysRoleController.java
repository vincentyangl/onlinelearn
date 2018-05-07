package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SysFunction;
import com.bean.SysRole;
import com.bean.SysUser;
import com.service.SysFunctionService;
import com.service.SysRoleService;
import com.service.SysUserService;
import com.util.JsonUtils;

@Controller
@RequestMapping("/admin/role")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysFunctionService sysFunctionService;
	
	@RequestMapping("/roleList")
	@ResponseBody
	public List<SysRole> roleList() {
		List<SysRole> sysRole = sysRoleService.listAll();
		return sysRole;
	}
	
	@RequestMapping("/getList")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		List<SysRole> sysRoles = sysRoleService.listAll();
		mv.setViewName("/back/role/roleList");
		mv.addObject("sysRoles", sysRoles);
		return mv;
	}
	
	@RequestMapping("/toRoleAdd")
	public String toRoleAdd() {
		return "/back/role/roleAdd";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAdd(SysRole sysRole) {
		sysRoleService.save(sysRole);
		return "redirect:/admin/role/getList";
	}
	
	@RequestMapping("/toRoleDelete")
	@ResponseBody
	public boolean toRoleDelete(int roleId) {
		boolean b = false;
		Map map = new HashMap<>();
		map.put("roleId", roleId);
		List<SysUser> users = sysUserService.listAll(map);
		if (users.size()==0) {
			b = true;
		}else {
			b = false;
			return b;
		}
		List<SysFunction> permissions = sysFunctionService.getSysFunctionByRoleId(roleId);
		if (permissions.size()==0) {
			b = true;
		}else {
			b = false;
		}
		return b;
	}
	
	@ResponseBody
	@RequestMapping("/getById")
	public List<SysFunction> getById(HttpServletRequest request) {
		int roleId = Integer.valueOf(request.getParameter("roleId"));
		SysRole sysRole = sysRoleService.getById(roleId);
		List<SysFunction> sfs = sysRole.getSysFunctions(); 
		return sfs;
	}
	
	@RequestMapping("/updateRole")
	public String updateRole(SysRole sysRole) {
		sysRoleService.update(sysRole);
		return "redirect:/admin/permissions/ztreeList/2";
	}
	
	@RequestMapping("/addRole")
	public String addRole(SysRole sysRole) {
		sysRoleService.save(sysRole);
		return "redirect:/admin/permissions/ztreeList/2";
	}
	
	@RequestMapping("/deleteRole/{roleId}")
	public String deleteRole(@PathVariable("roleId") int roleId) {
		sysRoleService.deleteAllFunctionIdByRoleId(roleId);
		sysRoleService.delete(roleId);
		return "redirect:/admin/permissions/ztreeList/2";
	}
	
	@RequestMapping("/roleAuthorize/{roleId}/{functionIds}")
	public String roleAuthorize(@PathVariable("roleId") int roleId,@PathVariable("functionIds") int functionIds[]) {
		List<SysFunction> sysFunctions = sysFunctionService.getSysFunctionByRoleId(roleId);
		if (sysFunctions.size()!=0) {
			sysRoleService.deleteAllFunctionIdByRoleId(roleId);
		}
		for (int i : functionIds) {
			sysRoleService.addFunctionIdByRoleId(roleId, i);
		}
		return "redirect:/admin/permissions/ztreeList/2";
	}
	
}
