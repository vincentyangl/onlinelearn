
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



    <link rel="stylesheet" href="/layui/css/layui.css"> 

	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
	<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
    <script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    
  <script src="/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
  <script src="/layui/layui.js"></script>
  <script src="/layui/lay/dest/layui.all.js"></script> 
       
		<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
		 
		 <script type="text/javascript" src="/js/jquery.min.js"></script>
         <script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
         
         <link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
         <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
         <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
         <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
		 
		 
<script type="text/javascript">
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
<%--     当前时间:<%=now %>  --%>
$(function() {
	$("#btns").click(function() {
			var content = UM.getEditor('myEditor').getContentTxt();
			$("#tx").val(content);
			$("#form1").submit();
		});
})

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
	
	layui.use(['form', 'layedit', 'laydate'], function(){
 var form = layui.form
 ,layer = layui.layer
 ,layedit = layui.layedit
 ,laydate = layui.laydate;
 //自定义验证规则
 form.verify({
	 email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对'],
	 email: function(value){
	     if(value.trim().length ==0){
	      return '邮箱不能为空';
	     }
	    }
	 ,
    title: function(value){
     if(value.length < 5){
      return '标题至少得5个字符';
     }
    }
 , content: function(value){
     if(value.length < 4){
      return '内容请输入至少4个字符';
     }
    }
    
    
 });
 var arr = UM.getEditor('myEditor').getContentTxt();
	$("#content").val(arr);
// 	$("#form1").submit();
 //创建一个编辑器
 layedit.build('myEditor');
 //监听提交
 form.on('submit(demo1)', function(data){
  layer.alert(JSON.stringify(data.field), {
   title: '最终的提交信息'
  });
  return false;
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
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>发送邮件</span>
		</header>
		<div class="larry-personal-body clearfix">
		
		

<form action="/admin/email/saveEmail" method="post"  >


                    <table  id="tab1">
					<tr height="50px">
						<td id="t1">&nbsp;&nbsp;&nbsp;添加联系人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td id="t2">
							<textarea onblur="fun()" name="email" id="email" rows="8" cols="50"  autocomplete="off"  lay-verify="email" style="width:408px;height:30px;" placeholder="请选输入对方邮箱,多个请用(;)分号隔开" title="请选输入对方邮箱,多个请用(;)分号隔开"></textarea>
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
						<input type="text"  name="title" id="title"  class="layui-input " placeholder="请输入标题" autocomplete="off" lay-verify="title"  style="width:500px;" >
					</div>
				</div>

<!-- 				<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label">内容</label> -->
<!-- 					<div class="layui-input-block"> -->
<!-- 						<script type="text/plain" id="myEditor" -->
<!-- 							style="width:500px;height:240px;"> -->
                        <!--  </script> -->
<!-- 						<textarea id="tx" cols="50" rows="10" name="content" -->
<!-- 							style="width: 600px" id="content" lay-verify="content"></textarea> -->
<!-- 						<br> -->
<!-- 					</div> -->
<!-- 				</div> -->

<!-- 				<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label">内容</label> -->
<!-- 					<div class="layui-input-block"> -->
<!-- 						<script type="text/plain" id="myEditor" autocomplete="off" -->
<!-- 							style="width:585px;height:240px;"></script> -->
<!-- 						<div class="clear"></div> -->
<!-- 					</div> -->
<!-- 				</div> -->

				<div class="layui-form-item">
					<label class="layui-form-label">内容</label>
					<div class="layui-input-block">
						<script type="text/plain" id="myEditor" style="width:500px;height:240px;"></script>
						<textarea id="tx" cols="50" rows="10" name="content" 
							style="width: 600px" id="content" lay-verify="content"></textarea>
						<div class="clear"></div>
					</div>
				</div>



				<div class="layui-input-inline  ">
                                   <label class="layui-form-label layui-col-md9">方式</label>
                        <div class="layui-input-block" style="width: 500px;">
								<select name="type" id="tid" class="form-control ">
    							<option value="1">普通发送</option>
                                <option value="2">定时发送</option>
								</select>
						</div>
				</div>
				
				<div class="layui-form-item" id="div1">
					<label class="layui-form-label" >时间</label>
					<div class="layui-input-block">
						<input type="text" name="time" id="time"  class="layui-input " style="width:500px;" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /><br>
					</div>
				</div>
				

				
				<div class="layui-form-item">
					<div class="layui-input-block"> 
							<button class="layui-btn" lay-filter="demo1" lay-submit="" > 发送
<!-- 					id="btn" onclick="javascript:return btn()" id="btns"			<i class="layui-icon" >&#xe608;</i>  -->
							</button>
							<button type="reset" class="layui-btn" onclick="cz()">重置</button>
							<a href="/admin/email/test">跳转</a>
					</div>
				</div>
		</div>
		<input type="hidden" name="content" id="content" value="">
</form>
	

</section>
</body>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
		var ue = UM.getEditor('myEditor');
	</script>
  
</html>