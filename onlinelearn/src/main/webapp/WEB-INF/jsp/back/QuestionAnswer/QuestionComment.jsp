<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
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
<form action="" method="post">
<a href="/admin/equestions/edlist" class="btn btn-primary btn-lg active" role="button">返回</a>
<!-- <a href="/admin/eqcomment/eqclist" class="btn btn-primary btn-lg active" role="button">问答回复列表</a> -->
<div class="layui-form news_list">
			<table class="layui-table">
				<colgroup>
					<col width="20%">
					<col width="60%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th>ID</th>
						<th>评论内容</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${lists }" var="tt">
						<tr>
							<th>${tt.id }</th>
							<th>${tt.content }</th>
							<th>
							<c:if test="${tt.isBest==0 }"><a href="/admin/eqcomment/eqcupdate?id=${tt.id }&isBest=${tt.isBest}&QUESTION_ID.id=${tt.edu_Questions.id}" class="layui-btn layui-btn-danger layui-btn-mini news_del" >设为最佳答案</a></c:if>
							<c:if test="${tt.isBest==1 }"><a href="/admin/eqcomment/eqcupdate?id=${tt.id }&isBest=${tt.isBest}&QUESTION_ID.id=${tt.edu_Questions.id}" class="layui-btn layui-btn-danger layui-btn-mini news_del">取消最佳答案</a></c:if>
							<a href="" class="layui-btn layui-btn-danger layui-btn-mini news_del">回复</a>
							</th>
						</tr>
					</c:forEach>
						
<!-- 						<tr> -->
<%-- 			<td align="center" colspan="9">一共${page.pages }页 --%>
<%-- 			<a href="/admin/equestions/edlist/${t.id }?page=${page.firstPage}">首页</a> --%>
<%-- 			<a href="/admin/equestions/edlist/${t.id }?page=${page.prePage}">上一页</a> --%>
<%-- 			<a href="/admin/equestions/edlist/${t.id }?page=${page.nextPage}">下一页</a> --%>
<%-- 			<a href="/admin/equestions/edlist/${t.id }?page=${page.lastPage}">尾页</a> --%>
<!-- 			</td> -->
<!-- 			</tr> -->
						
				</thead>
			</table>
			</div>
</form>
</body>
</html>