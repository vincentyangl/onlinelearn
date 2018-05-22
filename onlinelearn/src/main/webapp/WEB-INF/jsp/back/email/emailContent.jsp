<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查看邮件信息</title>
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
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
	
	<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>查看</span>
		</header>
		<div class="larry-personal-body clearfix">
		
			<form  action="" method="post">
			<input type="text"  name="id" value="${list.id}" hidden="hidden"/>
			<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">操作人</label>
					<div class="layui-input-block">
						<input type="text" name="userId"  class="layui-input " value="${list.userId.loginName}" style="width:585px;" autocomplete="off" disabled="disabled">
					</div>
				</div>
				<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">邮箱标题</label>
					<div class="layui-input-block"> 
						<input type="text" name="title"  class="layui-input" value="${list.title}" style="width:585px;" autocomplete="off" disabled="disabled">
					</div>
				</div>
				<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-block">
						<fmt:formatDate value="${list.create_time}" type="date" pattern="yyyy-MM-dd hh:mm:ss" />
					</div>
				</div>
				
				<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">收件人</label>
					<div class="layui-input-block"> 
						<input type="text" name="userId"  class="layui-input " value="${list.email}" style="width:585px;" autocomplete="off" disabled="disabled">
					</div>
				</div>
				
				<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">类型</label>
					<div class="layui-input-block"> 
						<c:if test="${list.type==1}">
							<input type="text" name="type"  class="layui-input " value="普通" style="width:585px;"  autocomplete="off" disabled="disabled">
						</c:if>
						<c:if test="${list.type==2}">
							<input type="text" name="type"  class="layui-input " value="定时" style="width:585px;"  autocomplete="off" disabled="disabled">
						</c:if>
					</div>
				</div>
				
				<div  class="layui-form-item col-lg-5">
					<label class="layui-form-label">是否发送</label>
					<div class="layui-input-block"> 
						<c:if test="${list.status==1}">
							<input type="text" name="status"  class="layui-input " value="已发送" style="width:585px;"  autocomplete="off" disabled="disabled">
						</c:if>
						<c:if test="${list.status==2}">
							<input type="text" name="status"  class="layui-input " value="未发送" style="width:585px;"  autocomplete="off" disabled="disabled">
						</c:if>
					</div>
				</div>
				
<!-- 				<div  class="layui-form-item col-lg-5"> -->
<!-- 					<label class="layui-form-label">邮箱正文</label> -->
<!-- 					<div class="layui-input-block">  -->
<%-- 						<textarea cols="100" rows="10" autocomplete="off" >${list.content}</textarea> --%>
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div class="layui-form-item">
			<label class="layui-form-label">内容</label>
			<div class="layui-input-block">
				<script type="text/plain" id="myEditor" autocomplete="off"
					style="width:585px;height:240px;">${list.content}</script>
				<div class="clear"></div>
			</div>
		</div>
					
				
				<div class="layui-form-item">
					<div class="col-sm-9">
						<a href="/admin/email/sendEmailList">
						<button type="button"  style="margin-left:300px;" class="layui-btn" lay-submit="" lay-filter="demo1">返回</button>
					</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript">
		var ue = UM.getEditor('myEditor');
	</script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
<script>     
    laydate({         
        elem: '#data',    //选择input的id     
        event: 'focus',     //鼠标获得input焦点开始下拉日期控件
        format: 'YYYY-MM-DD', //日期格式
                festival: true, //显示节日
                choose: function(datas){ //选择日期完毕的回调
                   /* alert('得到：'+datas);*/
                }
    }); 
//添加第二个input日期下拉的方法
    laydate({         
        elem: '#txt',         
        event: 'focus'     
    }); 
</script>
</body>
</html>