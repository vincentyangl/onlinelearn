package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Permissions;
import com.bean.Role;
import com.bean.User;
import com.service.PermissionsService;
import com.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private PermissionsService permissionsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/toLogin")
	public String toLogn() {
		System.out.println("000");
		return "/back/login/login";
	}
	
	@RequestMapping("/main")
	public String main() {
		System.out.println("121");
		return "/back/main/main";
	}
	
	@RequestMapping("/personalInfo")
	public String personalInfo() {
		return "/back/admin/personalInfo";
	}
	
	@RequestMapping("/changepwd")
	public String changepwd() {
		return "/back/admin/changepwd";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("user_name") String user_name,
			@RequestParam("user_password") String user_password) {
		ModelAndView mv = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		 if (!currentUser.isAuthenticated()) {
//			     System.out.println(13213);
	        	//���û����������װΪ UsernamePasswordToken ����
	            UsernamePasswordToken token = new UsernamePasswordToken(user_name, user_password);
	            System.out.println("uuuu");
	            //RememberMe
	            token.setRememberMe(true);
	            try {
	            	//����subject��login ������½
	                currentUser.login(token);
	            } 
	            //������֤ʱ�쳣�ĸ���
	            catch (AuthenticationException ae) {
	            	System.out.println("login failed��"+ae.getMessage());
	            	mv.setViewName("/back/login/login");
	            	return mv;
	            }
	        }
		 mv.addObject("permissions", getPermissionsMenu());
		 mv.setViewName("/back/index/index");
		return mv;
	}
	
	public List<Permissions> getPermissionsMenu() {
		Map map = new HashMap<>();
		map.put("per_menu", 1);
		map.put("pId", -1);
		List<Permissions> permissions = permissionsService.listAll(map);
        for (Permissions permissions2 : permissions) {
			System.out.println(permissions2.getName()+"=====");
			for (Permissions permissions3 : permissions2.getPers()) {
				System.out.println(permissions3.getName()+"--------");
			}
		}
		return permissions;
	}
	
	@RequestMapping("/userList")
	public ModelAndView userList() {
		ModelAndView mv = new ModelAndView();
		List<User> users = userService.listAll(new HashMap<>());
		mv.addObject("users", users);
		mv.setViewName("/back/admin/userList");
		return mv;
	}
	
	@RequestMapping("/userDelete/{user_id}")
	public String userDelete(@PathVariable("user_id") Integer user_id) {
		userService.delete(user_id);
		return "redirect:/userList";
	}
	
	@RequestMapping("/toUserAdd")
	public String toUserAdd() {
		return "/back/admin/userAdd";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(User user,Role role) {
		user.setRole(role);
		String result = getEncryptionPwd(user);
		user.setUser_password(result);
		userService.save(user);
		return "redirect:/userList";
	}
	
	//���������
	public String getEncryptionPwd(User user) {
		String hashAlgorithName="MD5";
		String pass=user.getUser_password();
		Object salt=ByteSource.Util.bytes(user.getUser_name());
		int count=1024;
		Object result=new SimpleHash(hashAlgorithName, pass,salt,count);
		return result.toString();
	}
	
	@RequestMapping("/toUserUpdate/{user_id}")
	public String toUserUpdate(@PathVariable("user_id") Integer user_id,Model model) {
		Map map = new HashMap<>();
		map.put("user_id", user_id);
		User user = userService.listAll(map).get(0);
		model.addAttribute("user", user);
		return "/back/admin/userUpdate";
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdate(User user,Role role) {
		user.setRole(role);
		String result = getEncryptionPwd(user);
		user.setUser_password(result);
		userService.update(user);
		return "redirect:/userList";
	}
	
}
