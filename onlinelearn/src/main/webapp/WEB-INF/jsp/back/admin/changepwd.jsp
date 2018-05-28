<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
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
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>修改密码</span>
		</header><!-- /header -->
		<div class="larry-personal-body clearfix changepwd">
			<form class="layui-form col-lg-4" method="post" action="/admin/user/changePwd">
			 	<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-block">  
					    <input type="hidden" name="userId"  value="${u.userId }" />
					  	<input type="text" name="loginName"  autocomplete="off"  class="layui-input layui-disabled" value="${u.loginName }" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="loginPwd"  autocomplete="off"  class="layui-input" value="" placeholder="请输入新密码"  lay-verify="loginPwd">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-block">  
					  	<input type="password" name="loginPwd1"  autocomplete="off"  class="layui-input" value="" placeholder="请输入确认新密码"  lay-verify="loginPwd1">
					</div>
				</div>
				<div class="layui-form-item change-submit">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
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
	  
	 
	  //自定义验证规则
	  form.verify({
	    loginPwd: [/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$/, '密码必须6到16位字母数字组合']
	  });
	  
	  //监听提交
	  form.on('submit(demo1)', function(data){
	    	 if(data.field.loginPwd1 != data.field.loginPwd){
	    	 layer.alert('两次输入的密码不一致!');
	    	 return false;
	    	} 
	    	/*  layer.alert(JSON.stringify(data.field), {
	    	      title: '最终的提交信息'
	    	    }) */
		  return true;
	  });
	});
</script>
</body>
</html>