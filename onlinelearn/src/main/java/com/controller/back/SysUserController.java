package com.controller.back;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.bean.EduCourse;
import com.bean.SysFunction;
import com.bean.SysRole;
import com.bean.SysUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.SysFunctionService;
import com.service.SysUserService;
import com.util.ObjectUtils;

@Controller
@RequestMapping("/admin/user")
public class SysUserController {

	@Autowired
	private SysFunctionService sysFunctionService;
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/toLogin")
	public String toLogn() {
		return "/back/login/login";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "/back/main/main";
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("sysFunctions", getSysFunctionMenu());
		SysUser sysUser = (SysUser) session.getAttribute("sysUser");
		mv.addObject("sysUser", sysUser);
		mv.setViewName("/back/index/index");
		return mv;
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
	public ModelAndView login(@RequestParam("loginName") String loginName,
			@RequestParam("loginPwd") String loginPwd,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Subject currentUser = SecurityUtils.getSubject();
		 if (!currentUser.isAuthenticated()) {
			     System.out.println("登陆成功！");
	        	//把用户名和密码封装为 UsernamePasswordToken 对象
	            UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPwd);
	            System.out.println("uuuu");
	            //RememberMe
	            token.setRememberMe(true);
	            try {
	            	//调用subject的login 方法登陆
	                currentUser.login(token);
	            } 
	            //所有认证时异常的父类
	            catch (AuthenticationException ae) {
	            	//打印错误信息
	            	ae.printStackTrace();
	            	System.out.println("login failed！");
	            	mv.setViewName("/back/login/login");
	            	return mv;
	            }
	        }
		 Map map = new HashMap<>();
		 map.put("loginName", loginName);
		 SysUser sysUser = sysUserService.listAll(map).get(0);
		 session.setAttribute("sysUser", sysUser);
		 mv.addObject("sysFunctions", getSysFunctionMenu());
		 mv.addObject("sysUser", sysUser);
		 mv.setViewName("/back/index/index");
		return mv;
	}
	
	public List<SysFunction> getSysFunctionMenu() {
		Map map = new HashMap<>();
		map.put("functionType", 1);
		map.put("pId", 0);
		List<SysFunction> sysFunctions = sysFunctionService.listAll(map);
        for (SysFunction sysFunctions2 : sysFunctions) {
			System.out.println(sysFunctions2.getName()+"=====");
			for (SysFunction sysFunctions3 : sysFunctions2.getSysFunctions()) {
				System.out.println(sysFunctions3.getName()+"--------");
			}
		}
		return sysFunctions;
	}
	
	@RequestMapping("/userDelete/{userId}")
	public String userDelete(@PathVariable("userId") Integer userId) {
		sysUserService.delete(userId);
		return "redirect:/admin/user/userList";
	}
	
	@RequestMapping("/toUserAdd")
	public String toUserAdd() {
		return "/back/admin/userAdd";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(SysUser sysUser,SysRole sysRole) {
		sysUser.setSysRole(sysRole);
		String result = getEncryptionPwd(sysUser);
		sysUser.setLoginPwd(result);
		sysUserService.save(sysUser);
		return "redirect:/admin/user/userList";
	}
	
	//给密码加密
	public String getEncryptionPwd(SysUser sysUser) {
		String hashAlgorithName="MD5";
		String pass=sysUser.getLoginPwd();
		Object salt=ByteSource.Util.bytes(sysUser.getLoginName());
		int count=1024;
		Object result=new SimpleHash(hashAlgorithName, pass,salt,count);
		return result.toString();
	}
	
	@RequestMapping("/toUserUpdate/{userId}")
	public String toUserUpdate(@PathVariable("userId") Integer userId,Model model) {
		Map map = new HashMap<>();
		map.put("userId", userId);
		SysUser sysUser = sysUserService.listAll(map).get(0);
		model.addAttribute("sysUser", sysUser);
		return "/back/admin/userUpdate";
	}
	
	@RequestMapping("/userUpdate")
	public String userUpdate(SysUser sysUser,SysRole sysRole) {
		sysUser.setSysRole(sysRole);
/*		String result = getEncryptionPwd(sysUser);
		sysUser.setLoginPwd(result);*/
		sysUserService.update(sysUser);
		return "redirect:/admin/user/userList";
	}
	
	@RequestMapping("/userList")
	public ModelAndView getSysUserByNameAndRoleId(@RequestParam(required=true,defaultValue="1")Integer currentPage,
			 String qname, Integer roleId) {
		ModelAndView mv = new ModelAndView();
		PageHelper.startPage(currentPage, 8);
		Map map = new HashMap<>();
		if (qname!=null&&qname.trim().length()!=0) {
			map.put("qname", qname);
		}
		if (ObjectUtils.isNotNull(roleId)) {
			map.put("rid", roleId);
		}
		List<SysUser> users = sysUserService.listAll(map);
		PageInfo<SysUser> info = new PageInfo<>(users);
		mv.addObject("info", info);
		mv.addObject("users", users);
		mv.addObject("qname", qname);
		mv.addObject("roleId", roleId);
		mv.setViewName("/back/admin/userList");
		return mv;
	}
	
	@RequestMapping("/toChangePwd/{userId}")
	public String toChangePwd(@PathVariable("userId") Integer userId,Model model) {
		SysUser u = sysUserService.getById(userId);
		model.addAttribute("u", u);
		return "/back/admin/changepwd";
	}
	
	@RequestMapping("/changePwd")
	public String changePwd(SysUser sysUser) {
		String result = getEncryptionPwd(sysUser);
		sysUser.setLoginPwd(result);
		sysUserService.updatePwd(sysUser);
		return "redirect:/admin/user/userList";
	}
	
}
