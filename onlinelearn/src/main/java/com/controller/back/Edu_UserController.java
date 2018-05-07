package com.controller.back;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_User;
import com.bean.Edu_class;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_UserService;
//import com.service.Edu_classService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Controller
@RequestMapping("/admin/student")
public class Edu_UserController {
	
	@Autowired
	private Edu_UserService edu_UserService;
//	@Autowired
//	private Edu_classService edu_classService;
	
	@RequestMapping("/Edu_userAll")
	public ModelAndView listAll(@RequestParam(required=true,defaultValue="1")Integer page, HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		Map map=new HashMap<>();
		PageHelper.startPage(page,10);
		map=initMAP(request, map);
		List<Edu_User> list=edu_UserService.listAll(map);
		PageInfo<Edu_User> pageInfo=new PageInfo<>(list);
//		List<Edu_class>type=edu_classService.listAll();
//		mv.addObject("type", type);
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);
		mv.setViewName("/back/student/student");
		return mv;
	}
	
	public Map initMAP(HttpServletRequest request,Map map) {
		String qname=request.getParameter("qname");
		String id=request.getParameter("id");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String isAvalible=request.getParameter("isAvalible");
//		System.out.println("isAvalible:"+isAvalible+"id:"+id);
		 if (id==null) {
//			 request.setAttribute("id", id);
			 id="-1";
		}
		 if (isAvalible==null) {
//			request.setAttribute("isAvalible", isAvalible);
			 isAvalible="-1";
		}
		
		map.put("id", id);
		map.put("qname", qname);
		map.put("start", start);
		map.put("end", end);
		map.put("isAvalible", isAvalible);
		return map;
	}
	
	@RequestMapping("/getById{userId}")
	public String getById1(@PathVariable ("userId") int userId,HttpServletRequest request){
	    Edu_User edu_User= edu_UserService.getById(userId);
		request.setAttribute("edu_User", edu_User);
		return "redirect:Edu_userAll";
	}
	
	@RequestMapping("/update")//修改密码
	public String update(Edu_User edu_User){
//		System.out.println("update:"+edu_User.getPassword());
//		System.out.println("id:"+edu_User.getUserId());
		edu_UserService.update(edu_User);
		return "redirect:Edu_userAll";
	}
	
	@RequestMapping("/toupdate/{userId}/{isAvalible}")//修改状态
	public String toupdate(@PathVariable ("userId") int userId,@PathVariable ("isAvalible") int isAvalible) {
		Edu_User edu_user=new Edu_User();
		edu_user.setUserId(userId);
		if (isAvalible==0) {
			isAvalible=1;
			edu_user.setIsAvalible(isAvalible);
		}else if (isAvalible==1) {
			isAvalible=0;
			edu_user.setIsAvalible(isAvalible);
		} 
		edu_UserService.toupdate(edu_user);
		return "redirect:/admin/student/Edu_userAll";
	}
	
	
	@RequestMapping("/eugetById")
	public ModelAndView getById(int id){
		ModelAndView mv =new ModelAndView();
		Edu_User edu_User=edu_UserService.getById(id);
		mv.setViewName("euupdate");
		mv.addObject("edu_User", edu_User);
		return mv;
	}
	
	@RequestMapping("/toBatchOpen")
	public String toBatchOpen() {
		return "/back/student/toBatchOpen";
	}
	
	@RequestMapping("/parseExcel")//excel批量注入
	public String parseExcel(@RequestParam("file")MultipartFile file)throws Exception{
		//创建输入流  	
//		InputStream stream =file.getInputStream(); 
		InputStream stream=file.getInputStream();
		//获取Excel文件对象  
		Workbook  rwb = Workbook.getWorkbook(stream);  
		//获取文件的指定工作表 默认的第一个  
		Sheet sheet = rwb.getSheet(0);    
		//行数(表头的目录不需要，从1开始)  
//		List<Edu_User> list=new ArrayList<Edu_User>();
//		System.out.println(sheet.getRows());
//		System.out.println(sheet.getColumns());
		for(int i=2; i<sheet.getRows(); i++){  
			//创建一个数组 用来存储每一列的值  
			String[] str = new String[sheet.getColumns()];  
			Cell cell = null;  
			//列数  
              Edu_User user =new Edu_User();
			for(int j=0; j<sheet.getColumns(); j++){  
				//获取第i行，第j列的值  
				cell = sheet.getCell(j,i);      
				str[j] = cell.getContents();  
				System.out.print(str[j]+" ");
//				if (str[j]==null||str[j].equals("")) {
//					break;
//				}
				if(j==0){
					user.setMobile(str[j]);
				}
				if(j==1){
					user.setEmail(str[j]);
				}
				if(j==2){
					user.setPassword(str[j]);
				}if(j==3){
					user.setUserName(str[j]);
				}
				if(j==4){
					user.setShowName(str[j]);
				}
				if(j==5){
					if (str[j].equals('男')) {
						user.setSex(1);
					}else {
						user.setSex(0);
					}
				}
				if(j==6){
					user.setAge(Integer.valueOf(str[j]));
				}
				if(j==7){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					user.setCreateTime(sdf.parse(str[j]));
				}
				if(j==8){
					if (str[j].equals("正常")) {
						user.setIsAvalible(1);
					}else {
						user.setIsAvalible(0);
					}
				}
				if(j==9){
					user.setPicImg(str[j]);
				}
				if(j==10){
					user.setBannerUrl(str[j]);
				}
			} 
			user.setLastSystemTime(new Date());
			System.out.println("user:"+user);
			edu_UserService.save(user);
//			list.add(user);
			
//			if(fillTime!=null && !(fillTime.equals(""))){     
//	            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");    
//	            java.util.Date date = format1.parse(fillTime);    
//	            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
//	            String sdate=format2.format(date);        
//	        Timestamp fTimestamp=Timestamp.valueOf(sdate);    
//	    }  
		}  
		return "redirect:/admin/student/Edu_userAll";
	}
	
}
