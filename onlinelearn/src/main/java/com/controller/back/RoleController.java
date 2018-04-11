package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Permissions;
import com.bean.Role;
import com.bean.User;
import com.service.PermissionsService;
import com.service.RoleService;
import com.service.UserService;

@Controller
@RequestMapping("/admin/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionsService permissionsService;
	
	@RequestMapping("/roleList")
	@ResponseBody
	public List<Role> roleList() {
		List<Role> roles = roleService.listAll();
		return roles;
	}
	
	@RequestMapping("/getList")
	public ModelAndView getList() {
		ModelAndView mv = new ModelAndView();
		List<Role> roles = roleService.listAll();
		mv.setViewName("/back/role/roleList");
		mv.addObject("roles", roles);
		return mv;
	}
	
	@RequestMapping("/toRoleAdd")
	public String toRoleAdd() {
		return "/back/role/roleAdd";
	}
	
	@RequestMapping("/roleAdd")
	public String roleAdd(Role role) {
		roleService.save(role);
		return "redirect:/getList";
	}
	
	@RequestMapping("/toRoleDelete")
	@ResponseBody
	public boolean toRoleDelete(int role_id) {
		boolean b = false;
		Map map = new HashMap<>();
		map.put("role_id", role_id);
		List<User> users = userService.listAll(map);
		if (users.size()==0) {
			b = true;
		}else {
			b = false;
			return b;
		}
		List<Permissions> permissions = permissionsService.getPermissionsByRoleId(role_id);
		if (permissions.size()==0) {
			b = true;
		}else {
			b = false;
		}
		return b;
	}
	
}
