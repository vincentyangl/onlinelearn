<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script type="text/javascript" src="/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
</head>
<style type="text/css">
#ca {
	width: 150px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	-o-text-overflow: ellipsis;
	-icab-text-overflow: ellipsis;
	-khtml-text-overflow: ellipsis;
	-moz-text-overflow: ellipsis;
	-webkit-text-overflow: ellipsis;
}
</style>

<body>
	<section class="layui-larry-box">
	<div class="larry-personal">
		<div class="layui-tab">
			<form action="/admin/teacher/teacherList">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input value="${map.qname }" placeholder="请输入姓名关键字"
								class="layui-input search_input" type="text" name="qname">
						</div>
						开始时间:
						<div class="layui-input-inline">
							<input value="${map.startTime }" class="layui-input search_input" type="text"
								name="startTime" onclick="WdatePicker()">
						</div>
						结束时间:
						<div class="layui-input-inline">
							<input value="${map.endTime }" class="layui-input search_input" type="text"
								name="endTime" onclick="WdatePicker()">
						</div>
						<input type="submit" class="btn btn-primary" value="查询" />
					</div>
					</blockquote>
			</form>
			<!-- 操作日志 -->
			<div class="layui-form news_list">
				<table class="layui-table">
					<colgroup>
						<col width="5%">
						<col width="8%">
						<col width="8%">
						<col width="19%">
						<col width="30%">
						<col width="12%">
						<col width="5%">
						<col width="13%">
					</colgroup>
					<thead>
						<tr>
							<th>ID</th>
							<th>名称</th>
							<th>头衔</th>
							<th>资历</th>
							<th>简介</th>
							<th>添加时间</th>
							<th>排序</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody class="news_content">
						<c:forEach items="${list }" var="l" varStatus="stat">
							<tr>
								<td>${stat.index+1 }</td>
								<td>${l.name }</td>
								<c:if test="${l.isStar==1 }">
									<td>高级讲师</td>
								</c:if>
								<c:if test="${l.isStar==2 }">
									<td>首席讲师</td>
								</c:if>
								<td><div id="ca" title="${l.education }">${l.education }</div></td>
								<td><div id="ca" title="${l.career }">${l.career }</div></td>
								<td><fmt:formatDate value="${l.createTime }" type="date"
										pattern="yyyy-MM-dd" /></td>
								<td>${l.sort }</td>
								<td><a href="/admin/teacher/getById/${l.id}"
									class="layui-btn layui-btn-mini"><i
										class="iconfont icon-edit"></i> 编辑</a> <a
									href="/admin/teacher/delete/${l.id }"
									class="layui-btn layui-btn-danger" data-id="13"><i
										class="layui-icon"></i> 删除</a></td>
							</tr>
						</c:forEach>
						<tr><td align="center" colspan="8">一共${page.pages }页
						<a href="/admin/teacher/teacherList/${l.id }?page=${page.firstPage}">首页</a>
						<a href="/admin/teacher/teacherList/${l.id }?page=${page.prePage}">上一页</a>
						<a href="/admin/teacher/teacherList/${l.id }?page=${page.nextPage}">下一页</a>
						<a href="/admin/teacher/teacherList/${l.id }?page=${page.lastPage}">尾页</a>
						</td></tr>
					</tbody>
				</table>
			</div>
			</div>
	</div>
	</section>
</body>
</html>