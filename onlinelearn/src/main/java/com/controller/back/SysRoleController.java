package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SysFunction;
import com.bean.SysRole;
import com.bean.SysUser;
import com.service.SysFunctionService;
import com.service.SysRoleService;
import com.service.SysUserService;

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
	
}
