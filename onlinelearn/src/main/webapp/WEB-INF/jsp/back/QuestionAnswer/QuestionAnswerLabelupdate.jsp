<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答列表</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<script src="js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" href="/bootstrap-table.css" />
<script src="bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
<script src="locale/bootstrap-table-zh-CN.js" type="text/javascript"
	charset="utf-8"></script>

</head>
<body>

	<form class="form-horizontal" action="/admin/equestions/edupdate" method="post">
	<a href="/admin/equestions/edlist" class="btn btn-primary btn-lg active" role="button">返回</a>
	<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label"></label>
			<div class="col-sm-4">
			<input type="hidden" class="form-control"   value="${edu_Questions.id}" name="id" id="id" />
<%-- 				<input type="text" class="form-control"   value="${shop_Member.member_id}" name="member_id" id="member_id" disabled="disabled"/> --%>
			</div>
		</div>
	
		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">问答标题:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" 
					name="title" value="${edu_Questions.title }"/>
			</div>
		</div>

		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">发表人昵称:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="showName" value="${edu_Questions.edu_User.showName }">
			</div>
		</div>

		
		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">发表人邮箱:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="email" value="${edu_Questions.edu_User.email }">
			</div>
		</div>

		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">问答分类:</label>
			<div class="col-sm-4">
			<c:if test="${edu_Questions.type==1 }"><input type="text" class="form-control" 
					name="type" value="课程问答" disabled="disabled"></c:if>
			<c:if test="${edu_Questions.type==2 }"><input type="text" class="form-control" 
					name="type" value="学习分享" disabled="disabled"></c:if>
				
			</div>
		</div>


		<%-- <div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">问答采纳:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="status" value="${edu_Questions.status }">
			</div>
		</div>
 --%>
		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">回复数:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="replyCount" value="${edu_Questions.replyCount }">
			</div>
		</div>

		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">点赞数:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="praiseCount" value="${edu_Questions.praiseCount }">
			</div>
		</div>

		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">浏览数:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="browseCount" value="${edu_Questions.browseCount }">
			</div>
		</div>
		
		<div class="form-group">
			<label for="inputtext" class="col-sm-2 control-label">添加时间:</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" disabled="disabled"
					name="addTime" value="${edu_Questions.addTime }" pattern="YYYY-MM-dd HH:mm:ss">
					<%-- <fmt:formatDate value="${edu_Questions.addTime }" type="date"
								pattern="YYYY-MM-dd HH:mm:ss" /> --%>
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-default">确定</button>
			</div>
		</div>
	</form>

</body>
</html>