package com.controller.web;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EduMsgReceive;
import com.bean.EduMsgSystem;
import com.bean.Edu_Questions;
import com.bean.Edu_Questions_Comment;
import com.bean.Edu_User;
import com.service.EduMsgReceiveService;
import com.service.Edu_QuestionsService;
import com.service.Edu_Questions_CommentService;
import com.service.Edu_UserService;
import com.tools.Encryption;
import com.tools.Result;
import com.util.JsonUtils;
@Controller
@RequestMapping("/uc")
public class LPersonalCenterController {

	@Autowired
	private EduMsgReceiveService eduMsgReceiveService;
	
	@Autowired
	private Edu_QuestionsService questionsService;
	
	@Autowired
	private Edu_Questions_CommentService commentService;
	
	@Autowired
	private Edu_UserService userService;
	
	@RequestMapping("/myquestions/list")//我的提问
	public String myquestionslist(HttpSession session,Model model){//questionsList 需要存
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		List<Edu_Questions> myQuestions = questionsService.myQuestions(user.getUserId());
		model.addAttribute("questionsList",myQuestions);
		return "web/ucenter/questions-mylist";
	}
	@RequestMapping("/myrepquestions/list")//我的回答
	public String myrepquestionslist(HttpSession session,Model model){
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		List<Edu_Questions_Comment> myQuestionsComment = commentService.myQuestionsComment(user.getUserId());
		model.addAttribute("questionsList",myQuestionsComment);
		return "web/ucenter/questions-myreplist";
	}
	@RequestMapping("/initUpdateUser")//我的资料  0基本资料 1个人头像 2密码设置
	public String initUpdateUser(@RequestParam("type") int type,HttpSession session,Model model){
		if(type == 0){
			model.addAttribute("index", 0);
			
		}else if(type == 1){
			model.addAttribute("index", 1);
		}else{
			model.addAttribute("index", 2);
		}
		Edu_User user = (Edu_User) session.getAttribute("login_success");
		model.addAttribute("user",user);
		return "web/ucenter/user-info";
	}
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(Edu_User user,HttpSession session,HttpServletResponse response){
		Edu_User loginUser = (Edu_User) session.getAttribute("login_success");
		user.setUserId(loginUser.getUserId());
		Result result=new Result();
		result.setSuccess(true);
		userService.updateMyinformation(user);
		Edu_User byId = userService.getById(loginUser.getUserId());
		session.setAttribute("login_success", byId);
		System.out.println(JsonUtils.objectToJson(result));
		try{
			result.setSuccess(false);
			return JsonUtils.objectToJson(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return JsonUtils.objectToJson(result);
	}
	@RequestMapping("/updatePwd")
	@ResponseBody
	public Result updatePwd(String nowPassword,String newPassword,String confirmPwd,HttpSession session,HttpServletResponse response){
		Edu_User loginUser = (Edu_User) session.getAttribute("login_success");
		Result result=new Result();
		String pwd = Encryption.encryptionByMD5(loginUser.getEmail(), nowPassword);
		System.out.println(pwd);
		System.out.println(loginUser.getPassword());
		if(!loginUser.getPassword().equals(pwd)){
			result.setMessage("1");
			result.setSuccess(false);
			return result;
		}else if(newPassword!=confirmPwd&&!newPassword.equals(confirmPwd)){
			result.setMessage("2");
			result.setSuccess(false);
			return result;
		}else{
			String newpwd = Encryption.encryptionByMD5(loginUser.getEmail(), confirmPwd);
			loginUser.setPassword(newpwd);
			userService.update(loginUser);
			result.setSuccess(true);
			session.setAttribute("login_success", null);
			return result;
		}
	}
	
	@RequestMapping("/letter")//我的消息
	public String ucletter(HttpSession session,Model model){
		List<EduMsgSystem> systemMsg = eduMsgReceiveService.systemMsg();
		model.addAttribute("queryLetterList",systemMsg);
		return "web/ucenter/uc_letter_inbox";
	}
	@RequestMapping("/ajax/delLetterInbox")//删除消息
	@ResponseBody
	public Result delLetterInbox(int id){
		eduMsgReceiveService.deleteSystemMsg(id);
		Result result=new Result();
		result.setMessage("success");
		return result;
	}
	@RequestMapping("/updateImg")
	@ResponseBody
	public Result updateImg(@RequestParam(value="file",required = false)MultipartFile file,HttpServletRequest request,HttpSession session){
		Edu_User loginUser = (Edu_User) session.getAttribute("login_success");
		Result result=new Result();
		if(file != null&&StringUtils.hasText(file.getOriginalFilename())) {
            //上传文件路径
            String path = request.getRealPath("/images/upload/user/");
            //上传文件名
            String filename = file.getOriginalFilename();
            System.out.println("666"+filename);
            if(filename==null||"".equals(filename)){
            	result.setSuccess(false);
            	result.setMessage("2");
            }
            String a[]=filename.split("\\.");
            if(!a[1].equalsIgnoreCase("BMP")||!a[1].equalsIgnoreCase("JPEG")||!a[1].equalsIgnoreCase("PSD")||!a[1].equalsIgnoreCase("PCX")
            		||!a[1].equalsIgnoreCase("PNG")||!a[1].equalsIgnoreCase("DXF")||!a[1].equalsIgnoreCase("CDR")
            		||!a[1].equalsIgnoreCase("ICO")
            		){
            	result.setSuccess(false);
            	result.setMessage("1");
            }
            File filepath = new File(path,filename);         
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            try {
				file.transferTo(new File(path + File.separator + filename));
			} catch (Exception e) {
				e.printStackTrace();
			} 
            loginUser.setPicImg("/images/upload/user/"+filename);
            userService.updatepic(loginUser);
            result.setSuccess(true);
		}
		return result;
	}
}
