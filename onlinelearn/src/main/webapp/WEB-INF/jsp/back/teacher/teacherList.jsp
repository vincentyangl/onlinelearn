<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
</head>
<style type="text/css">  
#ca {  
    width:150px;  
    overflow:hidden;  
    white-space:nowrap;  
    text-overflow:ellipsis;  
    -o-text-overflow:ellipsis;  
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
							<input value="" placeholder="请输入关键字"
								class="layui-input search_input" type="text" name="qname">
						</div>
						<div class="layui-input-inline">
							开始时间: <input value="" class="layui-input search_input"
								type="date" name="startTime">
						</div>
						<div class="layui-input-inline">
							结束时间: <input value="" class="layui-input search_input"
								type="date" name="endTime">
						</div>
						<input type="submit" class="btn btn-info" value="查询" />
					</div>
					<div class="layui-inline">
						<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
					</div>
			</form>
			</blockquote>

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
								<td><fmt:formatDate value="${l.createTime }" type="date" pattern="yyyy-MM-dd hh:mm:ss"/></td>
								<td>${l.sort }</td>
								<td><a href="/admin/teacher/getById/${l.id}"
									class="layui-btn layui-btn-mini"><i
										class="iconfont icon-edit"></i> 编辑</a> <a
									href="/admin/teacher/delete/${l.id }"
									class="layui-btn layui-btn-danger" data-id="13"><i
										class="layui-icon"></i> 删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="larry-table-page clearfix">
					<a href="javascript:;" class="layui-btn layui-btn-small"><i
						class="iconfont icon-shanchu1"></i>删除</a>
					<div id="page" class="page"></div>
				</div>
			</div>
			<!-- 登录日志 -->
			<div class="layui-tab-item layui-field-box">
				<table class="layui-table table-hover" lay-even="" lay-skin="nob">
					<thead>
						<tr>
							<th><input type="checkbox" id="selected-all"></th>
							<th>ID</th>
							<th>管理员账号</th>
							<th>状态</th>
							<th>最后登录时间</th>
							<th>上次登录IP</th>
							<th>登录IP</th>
							<th>IP所在位置</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><</td>
							<td>110</td>
							<td>admin</td>
							<td>后台登录成功</td>
							<td>2016-12-19 14:26:03</td>
							<td>127.0.0.1</td>
							<td>127.0.0.1</td>
							<td>Unknown</td>
						</tr>
					</tbody>
				</table>
				<div class="larry-table-page clearfix">
					<a href="javascript:;" class="layui-btn layui-btn-small"><i
						class="iconfont icon-shanchu1"></i>删除</a>
					<div id="page2" class="page"></div>
				</div>
			</div>
		</div>
	</div>

	</section>
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript" src="js/newslist.js"></script>
	<script type="text/javascript">
		layui.use([ 'jquery', 'layer', 'element', 'laypage' ], function() {
			window.jQuery = window.$ = layui.jquery;
			window.layer = layui.layer;
			var element = layui.element(), laypage = layui.laypage;

			laypage({
				cont : 'page',
				pages : 10 //总页数
				,
				groups : 5 //连续显示分页数
				,
				jump : function(obj, first) {
					//得到了当前页，用于向服务端请求对应数据
					var curr = obj.curr;
					if (!first) {
						//layer.msg('第 '+ obj.curr +' 页');
					}
				}
			});

			laypage({
				cont : 'page2',
				pages : 10 //总页数
				,
				groups : 5 //连续显示分页数
				,
				jump : function(obj, first) {
					//得到了当前页，用于向服务端请求对应数据
					var curr = obj.curr;
					if (!first) {
						//layer.msg('第 '+ obj.curr +' 页');
					}
				}
			});
		});
	</script>

</body>
</html>