<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章列表</title>
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
<form action="/admin/earticle/ealist" method="post">
			<div class="col-md-4 col-md-offset-4">
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="title" value="${name}" placeholder="标题"
							class="layui-input search_input">
					</div>
					
						<label class="layui-inline">文章类型:</label>
			<div class="layui-input-inline">
				<select class="layui-input" name="articleType" id="articleType">
					<option value="0">--全部--</option>
					<option value="2">文章</option>
				</select>
			</div>
			
					<input type="submit" value="查询" class="layui-btn search_btn" /><br />
				</div>

			</div>

		<!-- 操作日志 -->
		<div class="layui-form news_list">
			<table class="layui-table">
				<colgroup>
					<col width="5%">
					<col width="20%">
					<col width="10%">
					
					<col width="10%">
					<col width="25%">
					<col width="20%">
					
					<col width="10%">
				</colgroup>
				
					<tr>
						<th>ID</th>
						<th>标题</th>
						<th>作者</th>
						<th>来源</th>
						
						<th>创建时间</th>
						<th>发布时间</th>
						
						<th>操作</th>
					</tr>
					<c:forEach items="${list }" var="tt" >
						<tr>
							<th>${tt.articleId }</th>
							<th>${tt.title }</th>
							<th>${tt.author }</th>
							<th>${tt.source }</th>
							
							<th>
							<fmt:formatDate value="${tt.createTime }" type="date" pattern="YYYY-MM-dd HH:mm:ss"/>
							</th>
							<th>
							<fmt:formatDate value="${tt.publishTime }" type="date" pattern="YYYY-MM-dd HH:mm:ss"/>
							</th>
							
							<th>
							<a href="/admin/earticle/eadelete?articleId=${tt.articleId }" class="layui-btn layui-btn-danger layui-btn-mini news_del" >删除</a> 
							<a href="/admin/earticle/eagetById?articleId=${tt.articleId }" class="layui-btn layui-btn-mini news_edit">修改</a>
							</th>
						</tr>
				</c:forEach>

			<tr>
			<td align="center" colspan="9">一共${page.pages }页
			<a href="/admin/earticle/ealist/${tt.articleId }?page=${page.firstPage}">首页</a>
			<a href="/admin/earticle/ealist/${tt.articleId }?page=${page.prePage}">上一页</a>
			<a href="/admin/earticle/ealist/${tt.articleId }?page=${page.nextPage}">下一页</a>
			<a href="/admin/earticle/ealist/${tt.articleId }?page=${page.lastPage}">尾页</a>
			</td>
			</tr>
			</table>
		</div>
	</form>
</body>
</html>