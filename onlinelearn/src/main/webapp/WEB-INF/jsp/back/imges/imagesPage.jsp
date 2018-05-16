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
	<title>图片管理</title>
	
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

	  
	  function list() {//查询
			document.forms[0].action="/admin/imge/imagesPage";
			document.forms[0].submit();
		}
	  
// 	  function u(id){ //修改密码按钮
// 		  $("#myModal2").modal("hide");
// 	      $("#userId").val(id);
		  
// 	  }
	  
	  function cz() {
		  
		  $("#password").val("");
		  $("#password2").val("");
		
	}  
	  
	  function option() {
		  document.forms[0].action="/admin/imge/option";
		  document.forms[0].submit();
	}
	  
// 	  function upd(){ //修改
// // 		  var password=document.getElementById("password");
// // 		  var password2=document.getElementById("password2");
//           var userId=$("#userId").val();
// 		  var password=$("#password").val();
// 		  var password2=$("#password2").val();
// 		  alert(userId);
// 		  if(password.trim().length == 0 && password2.trim().length == 0){
// 			  alert("密码不能为空!")
// 		  }else{
// 			  if(password==password2){
// 				  window.location.href="/admin/student/update?userId="+userId+"&password="+password; 
// 			  }else{
// 				  alert("两次密码输入不一致!");
// 			  }
			  
// 		  }
// 	  }


	
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
								<input placeholder="输入标题查找" name="qname" id="qname" value="${qname}"
									class="layui-input search_input" type="text">
									
							</div>
						
							<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">图片类型</label> 
								<select id="type_id" name="type_id" class="form-control">
									<option value="-1">--请选择类型--</option>
									
									<c:forEach items="${type}" var="t">
											<option value="${t.type_id }">${t.type_name }</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="layui-input-inline">
								<label class="sr-only" for="exampleInputEmail3">状态</label> 
								<select id="shows" name="shows" class="form-control">
									<option value="-1">--请选择状态--</option>
								    <option value="1">显示</option>
								    <option value="0">不显示</option>
<!-- 								isAvalible;   //是否可用 1正常  2冻结 -->
								</select>
							</div>
							
							<button class="layui-btn search_btn" type="submit"  onclick="list()" >查询</button>
<!-- 							<a  class="layui-btn search_btn" onclick="listP()">查询</a> -->
                            <div class="layui-inline">
                                <a class="layui-btn search_btn" onclick="option()">添加图片</a>
		                   </div>
						</div>
						
		</form>
	</blockquote>
            
		    <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
		         <!-- 操作日志 -->
                <div class="layui-tab-item layui-field-box layui-show">
                     <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                        
                            <thead>
                              <tr>
                                  <th>ID</th>
                                  <th>表题</th>
                                  <th>图片路径</th>
                                  <th>连接路径</th>
                                  <th>类型</th>
                                  <th>序列号</th>
                                  <th>图片状态</th>
                                  <th>操作</th>
                              </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${list}" var="p" varStatus="statu">
                              <tr>
                                <td>${p.imge_id }</td>
                                 <td>${p.title}</td>
<%--                                 <c:if test="${p.type==1}"><td>普通</td></c:if> --%>
<%--                                 <c:if test="${p.type==2}"><td>定时</td></c:if> --%>
<%--                                 <c:if test="${p.status==1}"><td>已发送 </td></c:if> --%>
<%--                                 <c:if test="${p.status==2}"><td>未发送</td></c:if> --%>
                                <td><img alt="" src="${p.image_url}" style="width: 45px;height: 45px;" >  </td>
                                <td>${p.link_address}</td>
<%--                                 <td><fmt:formatDate --%>
<%-- 										value="${p.create_time}" type="date" --%>
<%-- 										pattern="yyyy-MM-dd hh:mm:ss" /></td> --%>
<%--                                <td><fmt:formatDate --%>
<%-- 										value="${p.send_time }" type="date" --%>
<%-- 										pattern="yyyy-MM-dd hh:mm:ss" /></td> --%>
                                <td>${p.type_id.type_name}</td>
                                 <td>${p.series_number}</td>
                                 <td>
                               <c:if test="${p.shows==0}">
                      <a href="/admin/imge/toupdate/${p.imge_id}/${p.shows}" class="btn btn-default">隐藏</a>
                               </c:if>
                               <c:if test="${p.shows==1}">
                      <a href="/admin/imge/toupdate/${p.imge_id}/${p.shows}" class="btn btn-default">显示</a>
                               </c:if>
                              </td>
<%--                                  <c:if test="${p.shows==0}"> <td>不显示</td></c:if> --%>
<%--                                  <c:if test="${p.shows==1}"> <td>显示</td></c:if> --%>
                                <td>
                                <a href="/admin/imge/update/${p.imge_id}" class="btn btn-default">修改</a>
                                 <a href="/admin/imge/delete/${p.imge_id}" class="btn btn-default">删除</a>
                                  </td>
                              </tr>
                          </c:forEach>
                          </tbody>
                     </table>
                     
                     
                     
                     
                     
                     
                     
                      <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                      <tr>
                      
                      <td ><c:if test="${page.isFirstPage==true }">
						<a>首页</a>
					</c:if> <c:if test="${page.isFirstPage==false }">
						<a href="/admin/imge/imagesPage?page=${page.firstPage }">首页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasPreviousPage==true }">
						<a href="/admin/imge/imagesPage?page=${page.prePage }">上一页</a>
					</c:if> <c:if test="${page.hasPreviousPage==false }">
						<a>上一页</a>
					</c:if> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					每页${page.pageSize }条
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${page.pageNum }/${page.pages }
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.hasNextPage==true }">
						<a href="/admin/imge/imagesPage?page=${page.nextPage }">下一页</a>
					</c:if> <c:if test="${page.hasNextPage==false }">
						<a>下一页</a>
					</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
						test="${page.isLastPage==false }">
						<a href="/admin/imge/imagesPage?page=${page.lastPage }">末页</a>
					</c:if> <c:if test="${page.isLastPage==true }">
						<a>末页</a>
					</c:if></td>
                             </tr>
                      </table>
                         
<!--                       <td> -->
<%--                       <c:if test="${}">   </c:if> --%>
<%--                                            总页数:${page.pages}  当前页为:${page.pageNum} --%>
<%--                       <a href="/index/listProduct?page=${page.firstPage}">第一页</a> --%>
<%--                         <a href="/index/listProduct?page=${page.prePage}">上一页</a> --%>
<%--                           <a href="/index/listProduct?page=${page.nextPage}">下一页</a> --%>
<%--                             <a href="/index/listProduct?page=${page.lastPage}">最后页</a> --%>
<!--                       </td> -->
                       
                     
                     
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