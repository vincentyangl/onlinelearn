<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答列表</title>
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
	<form action="/admin/equestions/edlist" method="post">
			
		<div class="layui-inline">
			
			<label class="layui-inline">标题:</label>
				<div class="layui-input-inline">
					<input type="text" name="title" value="${title }" placeholder="标题" class="layui-input search_input"> 
				</div>
				
				<label class="layui-inline">问答标签:</label>
			<div class="layui-input-inline">
				<select class="layui-input" name="type" id="type">
					<option value="0">--全部--</option>
					<option value="1">课程问答</option>
					<option value="2">学习分享</option>
				</select>
			</div>
			<div class="layui-inline">
				<input type="submit" value="查询" class="layui-btn search_btn" />
				
			</div>

		</div>

		<!-- 操作日志 -->
		<div class="layui-form news_list">
			<table class="layui-table">
				<colgroup>
					<col width="5%">
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
							<th>${t.title}</th>
							<c:if test="${t.type==1}">
								<th>课程问答</th>
							</c:if>
							<c:if test="${t.type==2}">
								<th>学习分享</th>
							</c:if>
							<c:if test="${t.status==0}">
								<th>是</th>
							</c:if>
							<c:if test="${t.status==1}">
								<th>否</th>
							</c:if>
							<th>${t.replyCount }</th>
							<th>${t.browseCount }</th>
							<th>${t.praiseCount }</th>
							<th>${t.addTime }</th>
							<th>
							<a href="/admin/equestions/eddelete?id=${t.id }" class="layui-btn layui-btn-danger layui-btn-mini news_del">删除</a>
							<a href="/admin/equestions/edgetById?id=${t.id }" class="layui-btn layui-btn-danger layui-btn-mini news_del">修改</a> 
							<a href="/admin/eqcomment/eqclistpl?id=${t.id }" class="layui-btn layui-btn-mini news_edit">查看回复</a>
							</th>
						</tr>
					</c:forEach>
						
						<tr>
			<td align="center" colspan="9">一共${page.pages }页
			<a href="/admin/equestions/edlist/${t.id }?page=${page.firstPage}">首页</a>
			<a href="/admin/equestions/edlist/${t.id }?page=${page.prePage}">上一页</a>
			<a href="/admin/equestions/edlist/${t.id }?page=${page.nextPage}">下一页</a>
			<a href="/admin/equestions/edlist/${t.id }?page=${page.lastPage}">尾页</a>
			</td>
			</tr>
						
				</thead>
			</table>
		</div>
	</form>
</body>
</html>