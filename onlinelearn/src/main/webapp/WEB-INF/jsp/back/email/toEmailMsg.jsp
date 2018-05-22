
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat"%>  
<%@page import="java.util.*"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮件发送</title>

    <meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	


<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		
		<script src="/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="/common/larry/layui/layui.js"></script>	
<script type="text/javascript">


function cz() { 
    	  $("#email").val("");              
    	  $("#title").val(""); 
    	  $("#myEditor").val("");
    	  $("#content").val(""); 
    	  $("#time").val(""); 
    	  
	} 
	
<%  
Date d = new Date();  
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
String now = df.format(d);  
%>  
<%--     当前时间:<%=now %>  --%>
/* $(function() {
	$("#btns").click(function() {
			var content = UM.getEditor('myEditor').getContentTxt();
			$("#tx").val(content);
			$("#form1").submit();
		});
}) */

  function btn () {
	    var c="是否要发送邮件？";
	    if (confirm(c)==true) {
	    	return true;
	    } else{
	    	return false;
	    }
	}
	
   function fun1() {
		var checklist = document.getElementsByName("subcheck");
		if (document.getElementById("checkbox").checked) {
			for (var i=0;i<checklist.length;i++) {
				checklist[i].checked = 1;
			}
		} else{
			for (var j=0;j<checklist.length;j++) {
				checklist[j].checked = 0;
			}
		}
	}
   
   
	var a=[];
	$(function(){
		$("#confirm").click(function() {
			var email = document.getElementsByName("subcheck");
			for(var i=0;i<email.length;i++) {
				if (email[i].checked) {
					a.push(email[i].value);
				}
			}
			var b ="";
			for(var i =0;i<a.length;i++) {
				if (b.trim().length==0) {
					b = a[i]+";";
				}else{
				b+=a[i]+";";
				}
			}
			$("#email").text(b);
			
		})
	})
	
	
	
	
	
</script>

<script type="text/javascript">
	function renderForm(){
		 layui.use('form', function(){
		 var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
		 form.render();
		 });
		 }
	   $(document).ready(function(){
		   $.post("/admin/role/roleList",function(msg){
			   for(i=0;i<msg.length;i++){
				 $("#roleId").append("<option value='"+msg[i].roleId+"'>"+msg[i].roleName+"</option>");
			   }
			   renderForm();
		   });
	   });
	</script>

 

</head>

<body>

     
     <!-- 选择联系人 -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" align="center" id="myModalLabel">邮件发送联系人</h3>
      </div>
      <div class="modal-body">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob"
							id="tb">
							<tr>
								<td><input type="checkbox" id="checkbox" name="checkbox"
									onclick="fun1()"></td>
								<td>姓名</td>
								<td>邮箱</td>
							</tr>
							<c:forEach items="${list}" var="a">
								<tr>
									<td><input type="checkbox" name="subcheck"
										value="${a.email}"></td>
									<td>${a.userName}</td>
									<td>${a.email}</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="2">一共<input type="text" value="${page.pages}"
									style="width: 25px; text-align: center;" />页 <a
									href="/admin/email/toEmailMsg?page=${page.firstPage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>第一页</a> <a
									href="/admin/email/toEmailMsg?page=${page.prePage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>上一页</a> <a
									href="/admin/email/toEmailMsg?page=${page.nextPage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>下一页</a> <a
									href="/admin/email/toEmailMsg?page=${page.lastPage}"
									class="layui-btn layui-btn-small"><i
										class="iconfont icon-shanchu1"></i>最后页</a></td>
							</tr>
						</table>

						
      </div>
      <div class="modal-footer">
      <div class="col-sm-8">
        <button type="button" class="btn btn-default" id="down" data-dismiss="modal">关闭</button>
        <button type="reset"  class="btn btn-default" onclick="cz()">重置</button>
        <button type="button" class="btn btn-default" id="confirm" data-dismiss="modal" >确定</button>
        </div>
      </div>
   
    </div>
  </div>
</div>
     
 
      

<section class="layui-larry-box">
<form  class="layui-form" action="/admin/email/saveEmail" method="post" >
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>发送邮件</span>
		</header>
		<div class="larry-personal-body clearfix">
		
<!-- 	enctype="multipart/form-data"	id="form1" -->


                    <table  id="tab1">
					<tr height="50px">
						<td id="t1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加联系人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td id="t2">
							<textarea  name="email" id="email" rows="8" cols="50"  autocomplete="off"  class="layui-input "  lay-verify="email" style="width:408px;height:30px;" placeholder="请选输入对方邮箱,多个请用(;)分号隔开" title="请选输入对方邮箱,多个请用(;)分号隔开"></textarea>
						</td>
							<td>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal3">导入联系人</button>

						</td>
					</tr>
			
				</table>
				<div class="layui-form-item">
					<label class="layui-form-label" >邮&nbsp;件&nbsp;标&nbsp;题</label>
					<div class="layui-input-block"> 
					<input type="hidden"    name="userId" id="userId" value="1" class="layui-input "  style="width:500px;" >
						<input type="text"  name="title" id="title"   placeholder="请输入标题" autocomplete="off"  class="layui-input "  lay-verify="title"  style="width:500px;" >
					</div>
				</div>

<!-- 				<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label">内容</label> -->
<!-- 					<div class="layui-input-block"> -->
<!-- 						<script type="text/plain" id="myEditor" -->
<!-- 							style="width:500px;height:240px;"> -->
<!--                          </script>  -->
<!-- 						<textarea id="tx" cols="50" rows="10" name="content" -->
<!-- 							style="width: 600px" id="content" lay-verify="content"></textarea> -->
<!-- 						<br> -->
<!-- 					</div> -->
<!-- 				</div> -->
				    
				    <div class="layui-form-item"> 
					<label class="layui-form-label">内容</label>
					<div class="layui-input-block">
<!-- 						<script type="text/plain" id="myEditor" -->
<!-- 							style="width:500px;height:240px;"> -->
                         </script>  
						<textarea  class="layui-textarea layui-hide"  name="content" id="LAY_demo_editor" lay-verify="content"></textarea>
						<br>
					</div>
				</div>
				    
				   

				<div class="layui-form-item">
                                   <label class="layui-form-label">方式</label>
                        <div class="layui-input-block" style="width: 500px;">
								<select name="type" id="tid" >
    							<option value="1">普通发送</option>
                                <option value="2">定时发送</option>
								</select>
						</div>
				</div>
				
				<div class="layui-form-item" id="div1">
					<label class="layui-form-label" >时间</label>
					<div class="layui-input-block">
						<input type="text" name="time" id="time"  class="layui-input "  lay-filter="time"  style="width:500px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /><br>
					</div>
				</div>
				

				
				<div class="layui-form-item">
					<div class="layui-input-block"> 
							<button class="layui-btn" lay-submit="" lay-filter="demo1" > 发送
<!-- 					id="btn" onclick="javascript:return btn()" id="btns"			<i class="layui-icon" >&#xe608;</i>  -->
							</button>
							<button type="reset" class="layui-btn" onclick="cz()">重置</button>
					</div>
				</div>
		</div>
</form>
	

</section>
</body>
<script type="text/javascript">
layui.use(['form', 'layedit', 'laydate'], function(){
	  var form = layui.form
	  ,layer = layui.layer
	  ,layedit = layui.layedit
	  ,laydate = layui.laydate;
	  
	  //创建一个编辑器
	  var editIndex = layedit.build('LAY_demo_editor');
	 
	  //自定义验证规则
	  form.verify({
		        
     		  email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
      ,
          title: function(value){
	      if(value.length < 1){
	        return '标题至少1个字符!';
	      }
	      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
	          return '标题不能有特殊字符';
	        }
	        if(/(^\_)|(\__)|(\_+$)/.test(value)){
	          return '标题首尾不能出现下划线\'_\'';
	        }
// 	        if(/^\d+\d+\d$/.test(value)){
// 	          return '用户名不能全为数字';
// 	        }
	    }
// 	 , content: function(value){
// 	      if(value.length < 1){
// 		        return '内容至少输入1个字符!';
// 		      }
// 	  } 
//  	      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
// 	          return '用户名不能有特殊字符';
// 	        }
// 	        if(/(^\_)|(\__)|(\_+$)/.test(value)){
// 	          return '用户名首尾不能出现下划线\'_\'';
// 	        }
// 	        if(/^\d+\d+\d$/.test(value)){
// 	          return '用户名不能全为数字';
// 	        }
// 		    }
// 	    ,loginPwd: [/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/, '密码必须6到16位字母数字组合']
// 	    ,loginPwd1:function(value){
// 	    	var passwordValue = $('input[name=loginPwd]').val();
// 	    	if(value != passwordValue){
// 	    	return '两次输入的密码不一致!';
// 	    	}
// 	    	}
// 	    ,tel: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位数字,且格式正确！']
	 
	  });
	  
	  //监听提交
	  form.on('submit(demo1)', function(data){
		  alert("验证完成!");
		  var b ;
		  var content = UM.getEditor('myEditor').getContentTxt();
		  if(content.trim().length<1){
			  layer.alert('内容至少输入1个字符!');
			  b=false;
		  }
		  if(data.field.type==2){
			  if(data.field.time==''){
				  layer.alert("请点击输入框选择时间!");
				  b = false;
			  }
		  }
		  return b = true;
	  });
	});
	
</script>



    <!-- 实例化编辑器 -->
     <script type="text/javascript">
     
     $(function(){
    		
    		$("#div1").show();
    		
    		//$("#tx").hide(); 
    		$('#tid').change(function(){
    			var type=$(this).val();
    			if(type=='1'){
    				$("#div1").hide();
    			}else{
    				$("#div1").show();
    			}
    		});  
    	});
     
     function func(){
    	 alert("wqer");
    	 //获取被选中的option标签
    	 var vs = $('select option:selected').val();
    	}

		var ue = UM.getEditor('myEditor');
	</script>
  
</html>