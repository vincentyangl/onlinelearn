package com.controller.back;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.impl.QuartzServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_emailsend_history;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_emailsend_historyService;
//import com.util.MyJob;
//import com.util.QuartzManager;
import com.util.MyJob;
import com.util.QuartzManager;

@Controller
@RequestMapping("/admin/email")
public class Edu_emailsend_historyConntroller {//邮件管理
	private static final String JOB_NAME = "动态任务调度";
	private static final String JOB_GROUP_NAME = "动态任务触发器";
	private static final String TRIGGER_NAME = "XLXXCC_JOB_GROUP";
	private static final String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";
	@Autowired
	private Edu_emailsend_historyService edu_emailsend_historyService;
	
    @RequestMapping("/sendEmailList")
	public ModelAndView  list(@RequestParam(required=true,defaultValue="1")Integer page, HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();
		PageHelper.startPage(page,10);
		Map map=new HashMap<>();
		map=initMap(request, map);
		 List<Edu_emailsend_history> list=edu_emailsend_historyService.listAll(map);
		 PageInfo<Edu_emailsend_history>pageInfo=new PageInfo<>(list);
		 mv.addObject("list", list);
		 mv.addObject("page", pageInfo);
		 mv.setViewName("/back/email/emailList");
		return mv;
	}
    
    public Map  initMap(HttpServletRequest request,Map map) {
		 String qname=request.getParameter("qname");
		 String type=request.getParameter("type");
		 String id=request.getParameter("id");
		 String start=request.getParameter("start");
		 String end=request.getParameter("end");
		 
		 if (type==null) {
			type="-1";
		}
		 String status=request.getParameter("status");
		 if (status==null) {
			 status="-1";
		}
		 map.put("qname", qname);
		 map.put("type", type);
		 map.put("status", status);
		 map.put("id", id);
		 map.put("start", start);
		 map.put("end", end);
		
		 return map;
	}
    @RequestMapping("/content/{id}") //查看
    public ModelAndView content(@PathVariable ("id") int id) {
		ModelAndView mv = new ModelAndView(); 
		Edu_emailsend_history list=edu_emailsend_historyService.getById(id);
		System.out.println(id);
		System.out.println("userId:"+list.getUserId());
		System.out.println("getEmail:"+list.getEmail());
		System.out.println(list.getCreate_time());
		 mv.addObject("list", list);
		 mv.setViewName("/back/email/emailContent");
		 return mv;
	}
    
    @RequestMapping("/toEmailMsg")
    public ModelAndView toEmailMsg() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/back/email/toEmailMsg");
		return mv;
	}
    
//	@RequestMapping("/sendemail")
//	public ModelAndView sofong(@RequestParam String name,@RequestParam String biaoti,@RequestParam String neirong){
//		ModelAndView mv=new ModelAndView();
//		System.out.println(name);
//		System.out.println(biaoti);
//		System.out.println(neirong);
//		JavaEmailSender sEmailSender=new JavaEmailSender();
//		try {
//			sEmailSender.sendEmail(name, biaoti, neirong);
//			System.out.println("发送成功！");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		mv.setViewName("redirect:/admin/email/sendEmailList");
//		return mv;
//	}
//	

//	@Scheduled(cron="0 15 20 * * ?")
//	public void test2(){
//		System.out.println("test2 开始执行...");
//	}

//	@Scheduled(cron = "0/20 * * * * ?")//每隔5秒隔行一次 
//	public void test3(){
//		JavaEmailSender sEmailSender=new JavaEmailSender();
//		try {    
//			    908138835    1793278977  908138835
//			sEmailSender.sendEmail("@qq.com", "哈喽", "小可爱！");
//			System.out.println("发送成功！！");
//		} catch (Exception e) {

//			e.printStackTrace();
//		}
//	}
    
    @RequestMapping("/sendEmail")
	public String sendEmail(){
		return "toEmailMsg";
	}
   
	@RequestMapping("/saveEmail")//发送邮件
	public String saveEmail(HttpServletRequest request){
//		Edu_emailsend_history emails=new Edu_emailsend_history();
		String content=request.getParameter("content");
		String type=request.getParameter("type");
		String sendTime=request.getParameter("time");
		String email=request.getParameter("email");
		String title=request.getParameter("title");
		System.out.println("type:"+type);
		System.out.println("content:"+content+"name"+email+"biaoti"+title);
		if(type.equals("1")){
						try{
//							sendEmail(content);
                        sendEmail(content, email, title);
						}catch(Exception e){
							e.printStackTrace();
						}
		}else{
						JobDetail job = JobBuilder.newJob(MyJob.class)
							    .withIdentity("myJob", "group1")
//							    .usingJobData("title","hello123")
							    .usingJobData("title",title)
							    .usingJobData("content",content)
//							    .usingJobData("email","908138835@qq.com")
							    .usingJobData("email",email)
							    .build();
						//对日期进行分割
						String[] dates=sendTime.split(" ");
						String[] date_year=dates[0].split("-");
						String[] date_time=dates[1].split(":");//0 51 15 26 4 ? 2016
						String cons="0 "+date_time[1]+" "+date_time[0]+" "+date_year[2]+" "+date_year[1]+" ?"+" "+date_year[0];
						QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, job,cons); 
	                    
						
		}
		return "redirect:/admin/email/sendEmailList";
//		emails.setEmail(email);
////		emails.setUserId(userId);
//		emails.setTitle(title);
//		emails.setCreate_time(new Date());
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		try {
//			emails.setSend_time(sdf.parse(sendTime) );
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		emails.setContent(content);
//		emails.setType(Integer.parseInt(type));
//		edu_emailsend_historyService.save(emails);
		
	}
    

    //设置邮件属性
	public void sendEmail(String content,String email,String title)throws Exception{

		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// 邮件传输的协议
		props.put("mail.transport.protocol", "smtp");
		// 发送人
		props.put("mail.user", "nanjingpaoyuan@163.com");
		// 连接的邮件服务器
		props.put("mail.host", "smtp.163.com");
		// 访问SMTP服务时需要提供的密码
		//props.put("mail.password", "yang199308140093");
		props.put("mail.password", "huangjie");
//		props.put("mail.password", "");
		// 构建授权信息，用于进行SMTP进行身份验证֤
		Authenticator authenticator=new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(
				props.getProperty("mail.user"));
		message.setFrom(form);

		// 设置收件人
		InternetAddress to = new InternetAddress(email);
		message.setRecipient(RecipientType.TO, to);
		// 设置邮件标题
		message.setSubject(title);
		// 设置邮件的内容体
		message.setContent(content,"text/html;charset=UTF-8");
		// 发送邮件
		Transport.send(message);
	}

    
}
