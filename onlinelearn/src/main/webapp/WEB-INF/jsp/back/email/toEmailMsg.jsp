
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

<!-- <meta name="renderer" content="webkit"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
<!-- <meta name="viewport" -->
<!-- 	content="width=device-width, initial-scale=1, maximum-scale=1"> -->
<!-- <meta name="apple-mobile-web-app-status-bar-style" content="black"> -->
<!-- <meta name="apple-mobile-web-app-capable" content="yes"> -->
<!-- <meta name="format-detection" content="telephone=no"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="/common/layui/css/layui.css" media="all"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="/common/bootstrap/css/bootstrap.css" media="all"> -->
<!-- <link rel="stylesheet" type="text/css" href="/common/global.css" -->
<!-- 	media="all"> -->
<!-- <link rel="stylesheet" type="text/css" href="/css/personal.css" -->
<!-- 	media="all"> -->
<!--  <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script>  -->
<!--  <script type="text/javascript" src="/js/jquery.tips.js"></script>  -->

<!-- <link href="/js/utf8-jsp/themes/default/css/umeditor.css" -->
<!-- 	type="text/css" rel="stylesheet"> -->
<!-- <script type="text/javascript" src="/js/jquery.min.js"></script> -->
<!-- <script language="javascript" type="text/javascript" -->
<!-- 	src="/js/My97DatePicker/WdatePicker.js"></script> -->
<!-- <script type="text/javascript" charset="utf-8" -->
<!-- 	src="/js/utf8-jsp/umeditor.config.js"></script> -->
<!-- <script type="text/javascript" charset="utf-8" -->
<!-- 	src="/js/utf8-jsp/umeditor.min.js"></script> -->
<!-- <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script> -->

<!-- 	<meta name="renderer" content="webkit">	 -->
<!-- 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	 -->
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	 -->
<!-- 	<meta name="apple-mobile-web-app-status-bar-style" content="black">	 -->
<!-- 	<meta name="apple-mobile-web-app-capable" content="yes">	 -->
<!-- 	<meta name="format-detection" content="telephone=no">	 -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all"> -->
<!--     <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script> -->
<!--     <script type="text/javascript" src="../../../js/jquery.tips.js"></script> -->
<!--     	<link href="/js/utf8-jsp/themes/default/css/umeditor.css" -->
<!-- 	type="text/css" rel="stylesheet"> -->

<script src="/js/jquery-3.0.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>




<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">

<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  
   <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
		<script src="/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
<script>

$(function(){
	$("#div1").hide();
	$("#tx").hide();
	$("#tid").change(function(){
		var type=$(this).val();
		if(type=='1'){
			$("#div1").hide();
		}else{
			$("#div1").show();
		}
	});
	
	$("#btn").click(function(){
		
		var content= UM.getEditor('myEditor').getContentTxt();
		$("#tx").val(content);
		$("#form1").submit();
	});
});

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

// function btn() {
// 	   var time=$("#time").val();
// 	   alert(time+""+now);
// 	   if(time<now){
// 		   alert("选择时间小于当前时间！")
// 	   }else{
// 		   var content= UM.getEditor('myEditor').getContentTxt();
// 			$("#tx").val(content);
// // 			$("#form1").submit();
//            document.forms[0].action="/admin/email/saveEmail";
//            document.forms[0].submit();
// 	   }
	
// }
var a="";
   function email1() {
	  
	   var emailVar=$("#tid1").val();
	   if(emailVar==0){
		   alert("请选择联系人!")
	   }else{
// 		   a=a+emailVar+";"
		   $("#email").val(emailVar);
	   }
	
}
	
</script>
<style type="text/css">
/* body {font-family:Microsoft YaHei; */
/*       font-size:18px; */
/* } */
</style>
</head>

<body>

     
     <!-- 选择联系人 -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" align="center" id="myModalLabel">修邮件发送联系人</h3>
      </div>
      <div class="modal-body">
         
         
        <form class="form-horizontal" method="post">
						
<!-- 							<div class="modal-footer"> -->
<!-- 							<div class="form-group"> -->
<!-- 								<label for="inputEmail3" class="col-sm-3 modal-title" style=" font-family:Arial,Verdana,Sans-serif; font-weight: normal;font-size:16px;" >输&nbsp;&nbsp;入&nbsp;&nbsp;名&nbsp;&nbsp;称</label> -->
<!-- <!--                                  <h6 class="modal-title" align="left" id="myModalLabel">修改密码</h6> --> 
<!-- 								<div class="col-sm-9"> -->
<!-- <!-- 								    <input  type="hidden" class="form-control zh" id="type_id" name="type_id" > --> 
<!-- 									<input  type="text" class="form-control zh" id="type_name" name="type_name" value=""> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							</div> -->
                          <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                        
                              <tr>
                                   <td></td>
                                  <td>联系人</td>
                                
                              </tr>
                          <c:forEach items="${list}" var="l" varStatus="statu">
                              <tr>
                              <div class="checkbox" align="center">
                              <label>
                               <input type="checkbox" value="${l.email}">${l.userName}
                               </label>
                               </div>
                              </tr>
                          </c:forEach>
                     </table>
                                       

							 
		</form>
						
      </div>
      <div class="modal-footer">
      <div class="col-sm-8">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="reset"  class="btn btn-default" onclick="cz()">重置</button>
        <button type="button" class="btn btn-default"onclick="upd()">确定</button>
        </div>
      </div>
   
    </div>
  </div>
</div>
     
 
      
    当前时间:<%=now %> 
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>发送邮件</span>
		</header>
		<div class="larry-personal-body clearfix">
		<form action="/admin/email/saveEmail" method="post" enctype="multipart/form-data" id="form1">
			<div class="layui-form-item layui-row">
					<label class="layui-form-label">收件人邮箱</label>
					<div class="layui-input-block layui-col-md9">
					<input type="hidden" id="imge_id" name="imge_id"  class="layui-input "  autocomplete="off" style="width:300px;"> 
						<input type="text" placeholder="邮箱格式为：*******@qq.com" name="email" id="email"   class="layui-input "  style="width:500px;">
<!-- 					    <input type="text" style="width: 500px" placeholder="邮箱格式为：*******@qq.com" name="email" id="email"/> -->
					</div>
					 
				</div>
			
				
				<div class="layui-input-inline  ">
				<button type="button"  class="btn btn-default" data-toggle="modal" data-target="#myModal3">选择联系人</button>
<!--                                 <label class="layui-form-label layui-col-md9">选择用户</label> -->
<!--                         <div class="layui-input-block" style="width: 500px;">     -->
                                 
<!-- 								<select name="type1" id="tid1" onchange="email1()" class="form-control "> -->
<!-- 								<option value="0" >请选择联系人</option> -->
<%-- 								<c:forEach items="${list}" var="l"> --%>
<%--     							<option value="${l.email}" >${l.userName}</option> --%>
<%--     							</c:forEach> --%>
<!-- 								</select> -->
<!-- 						</div> -->
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" >邮&nbsp;件&nbsp;标&nbsp;题</label>
					<div class="layui-input-block"> 
						<input type="text" name="title" id="title"  class="layui-input "  style="width:500px;" >
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邮件内容</label>
					<div class="layui-input-block">
						<script type="text/plain" id="myEditor"
							style="width:500px;height:240px;">
                        </script>
						<textarea id="tx" cols="50" rows="10" name="content"
							style="width: 600px" id="content"></textarea>
						<br>
					</div>
				</div>

				<div class="layui-input-inline  ">
                                   <label class="layui-form-label layui-col-md9">发送方式</label>
                        <div class="layui-input-block" style="width: 500px;">
								<select name="type" id="tid" class="form-control ">
    							<option value="1">普通发送</option>
                                <option value="2">定时发送</option>
								</select>
						</div>
				</div>
				
				<div class="layui-form-item" id="div1">
					<label class="layui-form-label" >时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间</label>
					<div class="layui-input-block">
						<input type="text" name="time" id="time"  class="layui-input " style="width:500px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /><br>
					</div>
				</div>
				

				
				<div class="layui-form-item">
					<div class="layui-input-block">
							<button class="layui-btn" id="btn" onclick="btn()">
								<i class="layui-icon" >&#xe608;</i> 发送
							</button>
							<button type="reset" class="layui-btn" onclick="cz()">重置</button>
					</div>
				</div>
		</div>
</form>
	

</section>

<!-- <form method="post" action="/admin/email/saveEmail" id="form1">  -->

<!--  收件人邮箱: <input type="text" style="width: 500px" placeholder="邮箱格式为：*******@qq.com" name="email" id="email"/><br/> -->
<!--  <dir></dir> -->
<!-- 邮&nbsp;件&nbsp;表&nbsp;题: <input type="text" style="width: 500px" name="title" id="title"/> -->
<!-- <dir></dir> -->
<!-- <script type="text/plain" id="myEditor" style="width:600px;height:240px;"> -->
    <p></p>
 </script> 
<!-- <textarea id="tx" cols="50" rows="10" name="content" style="width: 600px" id="content"></textarea><br> -->
<!-- 发送方式:<select name="type" id="tid" style="width: 520px"  > -->
<!-- <option value="1">普通发送</option> -->
<!-- <option value="2">定时发送</option> -->
<!-- </select> -->
<!-- <div></div> -->
<!-- <div id="div1"> -->
<!-- 时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间:<input type="text" name="time" id="time" style="width: 520px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> -->
<!-- </div><br> -->
<!-- <!-- <input type="button" style="margin-left:240px;" class="layui-btn col-sm-6" id="btn" value="发送"/> --> 
<!--                       <button type="submit" style="margin-left:240px;" class="layui-btn" id="btn">发送</button>  -->
<!-- 					<button type="reset" style="margin-right:220px;" class="layui-btn col-sm-9" onclick="cz()">重置</button> -->
<!-- </form> -->
</body>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
    //实例化编辑器
    var um = UM.getEditor('myEditor');
    </script>
</html>