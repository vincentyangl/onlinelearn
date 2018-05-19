package com.controller.back;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_User;
//import com.bean.Edu_class;
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
		PageHelper.startPage(page,10); //分页设置每页显示数
		map=initMAP(request, map);
		List<Edu_User> list=edu_UserService.listAll(map);
		PageInfo<Edu_User> pageInfo=new PageInfo<>(list); //分页把数据存放pageinfo
//		List<Edu_class>type=edu_classService.listAll();
//		mv.addObject("type", type);
		mv.addObject("list", list);
		mv.addObject("page", pageInfo);  //分页界面传参
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
		if (qname!=null) {
			request.setAttribute("qnames", qname);
		}
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
	public String toupdate(@PathVariable ("userId") int userId,
			@PathVariable ("isAvalible") int isAvalible) {
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
		System.out.println("批量");
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
		 
//		List<Edu_User> list=new ArrayList<Edu_User>();
//		System.out.println(sheet.getRows());
//		System.out.println(sheet.getColumns());
		//行数(表头的目录不需要，从1开始) 
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
	//导出excle
//	public String excel(HttpServletResponse response)throws Exception {
//		//创建HSSFWorkbook对象(excel的文档对象)  
//	      HSSFWorkbook wkb = new HSSFWorkbook();  
//	//建立新的sheet对象（excel的表单）  
//	HSSFSheet sheet=wkb.createSheet("学员表");  
//	//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个  
//	HSSFRow row1=sheet.createRow(0);  
//	//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个  
//	HSSFCell cell=row1.createCell(0);  
//	      //设置单元格内容  
//	cell.setCellValue("学员信息一览表");  
//	//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列  
//	sheet.addMergedRegion(new CellRangeAddress(0,0,0,12));  
//	//在sheet里创建第二行  
//	HSSFRow row2=sheet.createRow(1);      
//	      //创建单元格并设置单元格内容  
//	      row2.createCell(0).setCellValue("姓名");  
//	      row2.createCell(1).setCellValue("班级");      
//	      row2.createCell(2).setCellValue("笔试成绩");  
//	row2.createCell(3).setCellValue("机试成绩");      
//	      //在sheet里创建第三行  
//	for(int i=2; i<sheet.getRows(); i++){  }
//	      HSSFRow row3=sheet.createRow(2);  
//	      row3.createCell(0).setCellValue("李明");  
//	      row3.createCell(1).setCellValue("As178");  
//	      row3.createCell(2).setCellValue(87);      
//	      row3.createCell(3).setCellValue(78);      
//	  //.....省略部分代码  
//	  
//	  
//	//输出Excel文件  
//	    OutputStream output=response.getOutputStream();  
//	    response.reset();  
//	    response.setHeader("Content-disposition", "attachment; filename=details.xls");  
//	    response.setContentType("application/msexcel");          
//	    wkb.write(output);  
//	    output.close();  
//	    return "redirect:/admin/student/Edu_userAll"; 
//	}
	
	@RequestMapping("/excel")
	public void excel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map map=new HashMap<>();
		map=initMAP(request, map);
		List<Edu_User> list=edu_UserService.listAll(map);
		////////////////////将ArrayList中的数据写入到本地excel中///////////////////////////          
		//第一步，创建一个workbook对应一个excel文件  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//第二步，在workbook中创建一个sheet对应excel中的sheet  
		HSSFSheet sheet = workbook.createSheet("用户表一");  
		//第三步，在sheet表中添加表头第0行，老版本的poi对sheet的行列有限制  
		HSSFRow row = sheet.createRow(0);  
		//第四步，创建单元格，设置表头  
		HSSFCell cell = row.createCell(0);  
		cell.setCellValue("用户Id");  
		cell = row.createCell(1);  
		cell.setCellValue("手机号");  
		cell=row.createCell(2);  
		cell.setCellValue("邮箱号");  
		cell=row.createCell(3);  
		cell.setCellValue("用户名"); 
		cell=row.createCell(4);  
		cell.setCellValue("昵称"); 
		cell=row.createCell(5);  
		cell.setCellValue("性别"); 
		cell=row.createCell(6);  
		cell.setCellValue("年龄"); 
		cell=row.createCell(7);  
		cell.setCellValue("状态"); 
		//第五步，写入实体数据，实际应用中这些数据从数据库得到,对象封装数据，集合包对象。对象的属性值对应表的每行的值  
		for (int i = 0; i <list.size(); i++)   
		{  
			
			HSSFRow row1 = sheet.createRow(i+1);  
			Edu_User user=list.get(i);  
			//创建单元格设值  
			row1.createCell(0).setCellValue(user.getUserId());  
			row1.createCell(1).setCellValue(user.getMobile());  
			row1.createCell(2).setCellValue(user.getEmail()); 
			row1.createCell(3).setCellValue(user.getUserName()); 
			row1.createCell(4).setCellValue(user.getShowName()); 
			row1.createCell(5).setCellValue(user.getSex()); 
			row1.createCell(6).setCellValue(user.getAge()); 
			row1.createCell(7).setCellValue(user.getIsAvalible()); 
			
		}  
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=user.xls" );
		response.setContentType("Content-Type:application/vnd.ms-excel ");
		workbook.write(output);
		output.close();
	}

	
}
