<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<%-- <%     String path=request.getContextPath();  
String basePath=request.getScheme()+"://"+request.getServerName()+":" +request.getServerPort()+path+"/"; %>
<base href="<%=basePath%>"> --%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>学员管理</title>
	
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css"  media="all" >
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css"  media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css"  media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css"  media="all">
	<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	
	
	 <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
		<script src="/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="/locale/bootstrap-table-zh-CN.js" type="text/javascript" charset="utf-8"></script>
	
		
	    
	
	
	<script type="text/javascript">
	  function listP() {
		document.forms[0].action="/admin/student/Edu_userAll";
		document.forms[0].submit();
	//window.location.href="/shop/index/listProduct";
	}
	  
	  function option(){
		  document.forms[0].action="/index/option";
		  document.forms[0].submit();
	  }
// 	  $(document).ready(function(){
// 			$("#list").click(function(){
// 				document.forms[0].action="/shop/index/listProduct";
// 				document.forms[0].submit();
// 		})
// 	})
// function timeStamp2String(time) {
// 			var datetime = new Date();
// 			datetime.setTime(time);
// 			var year = datetime.getFullYear();
// 			var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
// 			var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
// 			var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
// 			var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
// 			var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
// 			return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
// 		}

	
	</script>
	<style type="text/css">
	   
	   #fonts{
	    font-family:Arial,Verdana,Sans-serif;
	    font-weight: normal;
	    font-size:18px;
	   }
	  
	</style>
</head>
<body>

<section class="layui-larry-box">
	<div class="larry-personal">
	    <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">
            
		<form action="" method="post" >

						<div class="layui-inline">
						
							<div class="layui-input-inline">
								<input placeholder="请输入关键字" name="qname" value="${qname }"
									class="layui-input search_input" type="text">
							</div>
							<div class="layui-input-inline">
								<input class="layui-input search_input" type="date">
							</div>
							<div class="layui-input-inline">
								<input class="layui-input search_input" type="date">
							</div>
							<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">学员班级</label> 
								<select id="id" name="id" class="form-control">
									<option value="-1">--请选择--</option>
									<c:forEach items="${type}" var="t">
<%-- 										<c:if test="${t.ptid>3}"> --%>
											<option value="${t.id }">${t.cname }</option>
<%-- 										</c:if> --%>

									</c:forEach>
								</select>
							</div>
							<a class="layui-btn search_btn" onclick="listP()">查询</a>
							<!-- 		    <a href="#" class="layui-btn" onclick="listP()">查询</a> -->
						</div>
						
						
		<div class="layui-inline">
<!-- 			<a href="/index/productAdd" data-url="" class="layui-btn layui-btn-normal newsAdd_btn">添加文章</a> -->
               <a class="layui-btn search_btn" onclick="option()">商品添加</a>
		</div>
		
		
		<!-- Modal -->      
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" align="center" id="myModalLabel">修改密码</h3>
<!--          -->
      </div>
      <div class="modal-body">
         
         
        <form class="form-horizontal" id="ff">
						
							
							<div class="modal-footer">
							
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 modal-title" style=" font-family:Arial,Verdana,Sans-serif; font-weight: normal;font-size:16px;" >输&nbsp;&nbsp;入&nbsp;&nbsp;密&nbsp;&nbsp;码</label>
<!--                                  <h6 class="modal-title" align="left" id="myModalLabel">修改密码</h6> -->
								<div class="col-sm-9">
									<input placeholder="密码至少在6位以上" type="text" class="form-control zh" id="eename" name="ename" value="">
								</div>
							</div>
							</div>
							
							<div class="modal-footer">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 control-label" style=" font-family:Arial,Verdana,Sans-serif; font-weight: normal;font-size:16px;">再次确认密码 </label>
								<div class="col-sm-9">
									<input placeholder="保持和上次密码输入一致" type="text" class="form-control zh" id="bbirth" name="birth" value="">
								</div>
							</div>
							</div>
							
							<!-- <div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">员工邮箱</label>
								<div class="col-sm-10">
									<input type="email" class="form-control zh" id="eemail" name="email" value="">
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">员工性别</label>
								<div class="col-sm-10">
									 <label>
                                  <input type="radio" class="hoo" name="sex" id="ssex" checked="checked" value="男">男
                                        </label>
							
								
									 <label>
                                  <input type="radio" class="hh" name="sex" id="ssex" value="女">女
                                        </label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">员工部门</label>
								<div class="col-sm-10">
									<select class="form-control zz" id="ddid"name="did"></select>
								</div>
							</div> -->
						</form>
      </div>
      <div class="modal-footer">
      <div class="col-sm-8">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="reset" class="btn btn-default" onclick="cz()">重置</button>
        <button type="button" class="btn btn-default"onclick="add()">修改</button>
        </div>
      </div>
    </div>
  </div>
</div>

		
		
<!-- 		<div class="layui-inline"> -->
<!-- 			<a class="layui-btn recommend" style="background-color:#5FB878">推荐文章</a> -->
<!-- 		</div> -->
<!-- 		<div class="layui-inline"> -->
<!-- 			<a class="layui-btn audit_btn">审核文章</a> -->
<!-- 		</div> -->
<!-- 		<div class="layui-inline"> -->
<!-- 			<a class="layui-btn layui-btn-danger batchDel">批量删除</a> -->
<!-- 		</div> -->
<!-- 		<div class="layui-inline"> -->
<!-- 			<div class="layui-form-mid layui-word-aux">本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div> -->
<!-- 		</div> -->
		</form>
	</blockquote>
            
		    <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
		         <!-- 操作日志 -->
                <div class="layui-tab-item layui-field-box layui-show">
                     <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                          <thead>
                              <tr>
                                 
                                  <th></th>
                                  <th>邮箱</th>
                                  <th>手机号</th>
                                   <th>用户名</th>
                                  <th>昵称</th>
                                  <th>班级</th>
                                  <th>性别</th>
                                  <th>年龄</th>
                                  <th>注册时间</th>
                                   <th>状态</th>
                                  <th>操作</th>
                              </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${list }" var="l" varStatus="statu">
                              <tr>
                                <td><input type="hidden" value="${l.userId}"></td>
                                <td>${l.email}</td>
                                <td>${l.mobile}</td>
                                <td>${l.userName}</td>
                                <td>${l.showName}</td>
                                <td>${l.id.cname}</td>
                                <c:if test="${l.sex==1}"><td>男</td></c:if>
                                <c:if test="${l.sex==0}"><td>女</td></c:if>
                                <td>${l.age}</td>
                                <td><fmt:formatDate
										value="${l.createTime}" type="date"
										pattern="yyyy-MM-dd hh:mm:ss" /></td>
                                
                                <c:if test="${l.isAvalible==1}"> <td> 正常  </td></c:if>
                                <c:if test="${l.isAvalible==0}"> <td> 冻结  </td></c:if>
                                <td>
<!--                                 class="btn btn-primary btn-lg" -->
                                <button type="button"  class="btn btn-default"  data-toggle="modal" data-target="#myModal2">修改密码</button>
<%--                                 <a href="/index/deleteProduct/${p.pid}" class="btn btn-default ">修改密码</a> --%>
                                    <a href="/index/toUpdate/${p.pid}" class="btn btn-default">冻结</a></td>
                              </tr>
                          </c:forEach>
                          </tbody>
                     </table>
                     
                      <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                      <tr><td>
                                           总页数:${page.pages}  当前页为:${page.pageNum}
                      <a href="/index/listProduct?page=${page.firstPage}">第一页</a>
                        <a href="/index/listProduct?page=${page.prePage}">上一页</a>
                          <a href="/index/listProduct?page=${page.nextPage}">下一页</a>
                            <a href="/index/listProduct?page=${page.lastPage}">最后页</a>
                      </td></tr>
                      
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
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
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