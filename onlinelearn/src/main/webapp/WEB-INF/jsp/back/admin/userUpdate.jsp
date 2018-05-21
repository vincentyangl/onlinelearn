<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>商品添加</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css">
	   
	</style>
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
			   $("#roleId").val("${sysUser.sysRole.roleId}");
			   renderForm();
		   });
	   });
	</script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span id="sp1">修改用户</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix">
			<form class="layui-form col-lg-6" action="/admin/user/userUpdate" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label ">登录名:</label>
					<div class="layui-input-block">  
						<input type="text" id="loginName" name="loginName"  value="${sysUser.loginName }" autocomplete="off"  class="layui-input "  readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label ">昵称:</label>
					<div class="layui-input-block">  
					    <input type="hidden" name="userId"  value="${sysUser.userId }" >
						<input type="text" id="userName" name="userName"  value="${sysUser.userName }" autocomplete="off"  class="layui-input "  lay-verify="userName">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱:</label>
					<div class="layui-input-block">  
						<input type="email" name="email" value="${sysUser.email }"  autocomplete="off"  class="layui-input "  lay-verify="email">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">电话:</label>
					<div class="layui-input-block">  
						<input type="text" name="tel" value="${sysUser.tel }"   autocomplete="off"  class="layui-input "   lay-verify="tel">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">角色:</label>
					<div class="layui-input-block">  
						<select class="layui-input"  width="150" name="roleId"  id="roleId"  lay-filter="role">
		    	   <option value="-1" selected="selected">请选择</option>
		    	</select>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn"  lay-submit="" lay-filter="demo1"  >立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="/common/larry/layui/layui.js"></script>
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
		  userName: function(value){
	      if(value.length < 5){
		        return '昵称至少得5个字符啊';
		      }
	      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
	          return '用户名不能有特殊字符';
	        }
	        if(/(^\_)|(\__)|(\_+$)/.test(value)){
	          return '用户名首尾不能出现下划线\'_\'';
	        }
	        if(/^\d+\d+\d$/.test(value)){
	          return '用户名不能全为数字';
	        }
		    }
	    ,tel: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位数字,且格式正确！']
	    ,email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
	  });
	  
	  var b = true;
	  
	  form.on('select(role)', function(data){
		  console.log(data.value); //得到被选中的值
		  if(data.value==-1){
			  b = false;
		  }
		});
	  
	  //监听提交
	  form.on('submit(demo1)', function(data){
		  var b = true;
		  if(data.field.roleId==-1){
			  layer.alert("请选择角色!");
			  b = false;
		  }
		  return b;
	  });
	});
	
</script>
</body>
</html>