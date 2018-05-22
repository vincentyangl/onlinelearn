<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答回复列表</title>
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
<form action="/admin/eqcomment/eqclist" method="post">
<blockquote class="layui-elem-quote news_search">
			<div class="layui-inline">
			
			<label class="layui-inline">问答标题:</label>
			<div class="layui-input-inline">
			<input type="text" name="title" value="${title }" placeholder="问答标题"
							class="layui-input search_input">
			</div>			
			
			<label class="layui-inline">是否采纳:</label>
			<div class="layui-input-inline">	
			<select class="layui-input" name="isBest" id="isBest">
					<option value="-1">--全部--</option>
					<option value="0">否</option>
					<option value="1">是</option>
			</select>
			</div>
			<div class="layui-input-inline">
					<input type="submit" value="查询" class="layui-btn search_btn" />
		     </div>

			</div>
</blockquote>
		<!-- 操作日志 -->
		<div class="layui-form news_list">
			<table class="layui-table" style="table-layout: fixed">
				<colgroup>
					<col width="5%">
					<col width="20%">
					<col width="20%">
					<col width="10%">
					<col width="5%">
					<col width="5%">
					<col width="5%">
					<col width="15%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>问答ID</th>
						<th>问答标题</th>
						<th>问答回复</th>
						<th>发表人</th>
						<th>是否采纳</th>
						<th>回复数</th>
						<th>点赞数</th>
						<th>添加时间</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${list }" var="t">
						<tr>
							<th>${t.id }</th>
							<th>${t.edu_Questions.title }</th>
							<th style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis;" title="${t.content }">${t.content }</th>
							<th>${t.edu_User.email }</th>
							<c:if test="${t.isBest==1}"><th>是</th></c:if>
							<c:if test="${t.isBest==0}"><th>否</th></c:if>
							<th>${t.replyCount }</th>
							<th>${t.praiseCount }</th>
							<th>
							<fmt:formatDate value="${t.addTime }" type="date"
								pattern="YYYY-MM-dd HH:mm:ss" />
							</th>
							<th>
							<a href="/admin/eqcomment/eqcdelete?id=${t.id }" class="layui-btn layui-btn-danger layui-btn-mini news_del" >删除</a> <br/>
<!-- 							<a href="" class="layui-btn layui-btn-mini news_edit">修改</a> -->
<%-- 							<a href="/admin/eqcomment/eqclistpl?id=${t.id }" class="layui-btn layui-btn-danger layui-btn-mini news_del" >查看评论</a> --%>
							<c:if test="${t.isBest==0 }">
							<a href="" class="layui-btn layui-btn-mini news_edit" style="display:none">采纳为最佳答案</a>
							</c:if>
							<c:if test="${t.isBest==1 }">
							<a href="" class="btn btn-lg " disabled="disabled" >最佳答案</a>
							</c:if>
														</th>
						</tr>
					</c:forEach>
						
						<tr>
			<td align="center" colspan="9">一共${page.pages }页
			<a href="/admin/eqcomment/eqclist/${t.id  }?page=${page.firstPage}">首页</a>
			<a href="/admin/eqcomment/eqclist/${t.id  }?page=${page.prePage}">上一页</a>
			<a href="/admin/eqcomment/eqclist/${t.id  }?page=${page.nextPage}">下一页</a>
			<a href="/admin/eqcomment/eqclist/${t.id  }?page=${page.lastPage}">尾页</a>
			</td>
			</tr>
				</thead>
			</table>
		</div>
	</form>
</body>
</html>