<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%     String path=request.getContextPath();  
String basePath=request.getScheme()+"://"+request.getServerName()+":" +request.getServerPort()+path+"/"; %>
<base href="<%=basePath%>"> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>图片类型管理</title>

<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script language="javascript" src="/js/My97DatePicker/WdatePicker.js"
	type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript"
	charset="utf-8"></script>





<script type="text/javascript">

// $(function () {
//  	if(${k}==0){
//  		$("#myModal").modal("show");
//  	}
// });

	  
	  function list() {//查询
			document.forms[0].action="/admin/imge/imagesPage";
			document.forms[0].submit();
		}
	  
	  function up(type_id){ //修改密码按钮
		  $("#myModal3").modal("hide");
		  $("#type_id").val(type_id);
// 		  window.location.href="/admin/imagetype/getById/"+type_id;
             
	  }
	  
//	      $("#type_id").val(id);
//	      $("#type_name2").val(name)
//	      alert($("#type_id").val(id));
//	      alert($("#type_name2").val(name));
	  
	  function cz() {
		  
		  $("#type_name").val("");
		  $("#type_name2").val("");
		
	}  
 
 function jump() {
	 document.forms[0].action="/admin/imagetype/jump";
     document.forms[0].submit();
}
	  
 
 function save() {
	 alert("save");
	  var type_name=$("#type_name2").val();
//	  document.forms[0].action="/admin/imagetype/save";
//	  document.forms[0].submit();
//	  alert("save");
	  window.location.href="/admin/imagetype/save/"+type_name;
}

	
	  
	  function upd(){ //修改
          var type_id=$("#type_id").val();
		  var type_name=$("#type_name").val();
		  if(type_name.trim().length == 0){
			  alert("输入的修改类型不能为空!")
		  }else{
				  window.location.href="/admin/imagetype/update?type_id="+type_id+"&type_name="+type_name; 
		  }
	  }


	
	</script>
<style type="text/css">
#fonts {
	font-family: Arial, Verdana, Sans-serif;
	font-weight: normal;
	font-size: 18px;
}
</style>
</head>
<body>
	<!-- 修改图片类型 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" align="center" id="myModalLabel">修改图片类型</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" method="post">
						<div class="modal-footer">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 modal-title"
									style="font-family: Arial, Verdana, Sans-serif; font-weight: normal; font-size: 16px;">输&nbsp;&nbsp;入&nbsp;&nbsp;名&nbsp;&nbsp;称</label>
								<!--                                  <h6 class="modal-title" align="left" id="myModalLabel">修改密码</h6> -->
								<div class="col-sm-9">
									<input type="hidden" class="form-control zh" id="type_id"
										name="type_id" value="${type.type_id }"> <input
										type="text" class="form-control zh" id="type_name"
										name="type_name" value="${type.type_name }">
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-sm-8">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="reset" class="btn btn-default" onclick="cz()">重置</button>
						<button type="button" class="btn btn-default" onclick="upd()">修改</button>
					</div>
				</div>

			</div>
		</div>
	</div>



	<!-- 添加类型 -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" align="center" id="myModalLabel">添加图片类型</h3>
				</div>
				<div class="modal-body">


					<form class="form-horizontal" method="post">

						<div class="modal-footer">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 modal-title"
									style="font-family: Arial, Verdana, Sans-serif; font-weight: normal; font-size: 16px;">输&nbsp;&nbsp;入&nbsp;&nbsp;名&nbsp;&nbsp;称</label>
								<!--                                  <h6 class="modal-title" align="left" id="myModalLabel">****</h6> -->
								<div class="col-sm-9">
									<input type="hidden" class="form-control zh" id="type_id"
										name="type_id"> <input placeholder="请输入需要添加的图片类型"
										type="text" class="form-control zh" id="type_name2"
										name="type_name2" value="">
								</div>
							</div>
						</div>

					</form>

				</div>
				<div class="modal-footer">
					<div class="col-sm-8">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="reset" class="btn btn-default" onclick="cz()">重置</button>
						<button type="button" class="btn btn-default" onclick="save()">添加</button>
					</div>
				</div>

			</div>
		</div>
	</div>



	<section class="layui-larry-box">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">

					<form action="" method="post">

						<div class="layui-inline">

							<div class="layui-inline">
								<!--                                 <a class="layui-btn search_btn" href="/back/imgesType/imagesTypeSave">添加类型</a> -->
								<!--                                 <button type="button" class="layui-btn search_btn" onclick="jump()">添加类型</button> -->
								<button type="button" class="layui-btn search_btn"
									data-toggle="modal" data-target="#myModal2">添加类型</button>
							</div>
						</div>

					</form>
				</blockquote>

				<div
					class="layui-tab-content larry-personal-body clearfix mylog-info-box">
					<!-- 操作日志 -->
					<div class="layui-tab-item layui-field-box layui-show">
						<table class="layui-table table-hover" lay-even="" lay-skin="nob">

							<thead>
								<tr>
									<th width="25%" align="center">序号</th>
									<th width="25%" align="center">ID</th>
									<th width="25%" align="center">类型名称</th>
									<th width="25%" align="center">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="p" varStatus="statu">
									<tr>
										<td>${statu.index+1}</td>
										<td>${p.type_id }</td>
										<td>${p.type_name}</td>
										<td><a href="/admin/imagetype/getById//${p.type_id}"
											class="btn btn-default">修改</a> <%--<button type="button"  class="btn btn-default" data-toggle="modal" data-target="#myModal3" onclick="up(${p.type_id })">修改</button> --%>
											<a href="/admin/imagetype/delete/${p.type_id}"
											class="btn btn-default">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

						<table class="layui-table table-hover" lay-even="" lay-skin="nob">
							<tr>

								<td><c:if test="${page.isFirstPage==true }">
										<a>首页</a>
									</c:if> <c:if test="${page.isFirstPage==false }">
										<a href="/admin/imagetype/getList?page=${page.firstPage }">首页</a>
									</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.hasPreviousPage==true }">
										<a href="/admin/imagetype/getList?page=${page.prePage }">上一页</a>
									</c:if> <c:if test="${page.hasPreviousPage==false }">
										<a>上一页</a>
									</c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									每页${page.pageSize }条
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.pageNum }/${page.pages }
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.hasNextPage==true }">
										<a href="/admin/imagetype/getList?page=${page.nextPage }">下一页</a>
									</c:if> <c:if test="${page.hasNextPage==false }">
										<a>下一页</a>
									</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
										test="${page.isLastPage==false }">
										<a href="/admin/imagetype/getList?page=${page.lastPage }">末页</a>
									</c:if> <c:if test="${page.isLastPage==true }">
										<a>末页</a>
									</c:if></td>
							</tr>
						</table>


						<!--                      <div class="larry-table-page clearfix"> -->
						<!--                           <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a> -->
						<!-- 				          <div id="page" class="page"></div> -->
						<!-- 			         </div> -->
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
									<td><input type="checkbox"></td>
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
		</div>
	</section>

	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['jquery','layer','element','laypage'],function(){
	      window.jQuery = window.$ = layui.jquery;
	      window.layer = layui.layer;
          var element = layui.element(),
              laypage = layui.laypage;

            
          laypage({
					cont: 'page',
					pages: 10 //总页数
						,
					groups: 5 //连续显示分页数
						,
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
						}
					}
				});

          laypage({
					cont: 'page2',
					pages: 10 //总页数
						,
					groups: 5 //连续显示分页数
						,
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
						}
					}
				});
    });
</script>
</body>
</html>