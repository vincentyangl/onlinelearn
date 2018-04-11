<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答标签</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="common/bootstrap/css/bootstrap.css" media="all">
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
	<form action="/equestions/edlist" method="post">

		<!-- 	<div class="col-md-4 col-md-offset-4"> -->
		<!-- 		<div class="layui-inline"> -->
		<!-- 			<div class="layui-input-inline"> -->
		<%-- 				<input type="text" name="order_code" value="${name}" placeholder="请输入订单编号" --%>
		<!-- 					class="layui-input search_input"> -->
		<!-- 			</div> -->
		<!-- 			<input type="submit" value="查询" class="layui-btn search_btn" /><br /> -->
		<!-- 		</div> -->

		<!-- 	</div> -->

		<!-- 操作日志 -->
		<div class="layui-form news_list">
			<table class="layui-table">
				<colgroup>
					<col width="5">
					<col width="15%">
					<col width="35%">
					<col width="5%">
					<col width="5%">
					<col width="5%">
					<col width="5%">
					<col width="5%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>ID</th>
						<th>发表人</th>
						<th>问答标题</th>
						<th>类型</th>
						<th>是否采纳</th>
						<th>回复数</th>
						<th>浏览数</th>
						<th>点赞数</th>
						<th>添加时间</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${list }" var="t">
						<tr>
							<th>${t.id }</th>
							<th>${t.edu_User.email }</th>
							<th>${t.titie }</th>
							<c:if test="${t.type==1}"><th>课程问答</th></c:if>
							<c:if test="${t.type==2}"><th>学习分享</th></c:if>
							<c:if test="${t.status==0}"><th>是</th></c:if>
							<c:if test="${t.status==1}"><th>否</th></c:if>
							<th>${t.replyCount }</th>
							<th>${t.browseCount }</th>
							<th>${t.praiseCount }</th>
							<th>${t.addTime }</th>
							<th>
							<a href="/admin/equestions/eddelete?id=${t.id }" class="layui-btn layui-btn-danger layui-btn-mini news_del" >删除</a> 
							<a href="" class="layui-btn layui-btn-mini news_edit">修改</a>
							<a href="" class="layui-btn layui-btn-danger layui-btn-mini news_del" >回复</a>
							</th>
						</tr>
					</c:forEach>

				</thead>
			</table>
		</div>
	</form>
</body>
</html>