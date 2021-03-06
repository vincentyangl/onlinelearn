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
	<title>课程信息</title>
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
	<!--  <script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script> -->
	<style type="text/css">
	   .tt{
	      margin: auto
	   }
	</style>
	<script type="text/javascript">
	   $(document).ready(function(){
		   $.post("/admin/subject/getSubjectList/1",function(msg){
			   for(i=0;i<msg.length;i++){
				   $("#subjectId").append("<option value='"+msg[i].subjectId+"'>"+msg[i].subjectName+"</option>");
			   }
			   var subjectId = "${subjectId}";
			   if(subjectId==null||subjectId==''){
				   subjectId = -1;
			   }
			   $("#subjectId").val(subjectId);
		   });
		   var is_avaliable = "${is_avaliable}";
		   if(is_avaliable==null||is_avaliable==''){
			   is_avaliable = -1;
		   }
		   $("#is_avaliable").val(is_avaliable);
	   });
	   function cleanText(){
		   $("#qname").val("");
		   $("#is_avaliable").val("-1");
		   $("#subjectId").val("-1");
		   $("#beginTime").val("");
		   $("#endTime").val("");
	   }
	</script>
</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
	    <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">
		<form action="/admin/course/courseList" method="POST">
		<div class="layui-inline">
		    <label class="layui-inline  tt">课程名称:</label>
		    <div class="layui-input-inline">
		    	<input  placeholder="请输入关键字" id="qname" name="qname"  value="${qname }" class="layui-input search_input"  type="text">
		    </div>
		    <label class="layui-inline tt">状态:</label>
		    <div class="layui-input-inline">
		    	<select class="layui-input"  width="150" name="is_avaliable"  id="is_avaliable">
		    	   <option value="-1" selected="selected">请选择</option>
		    	   <option value="1" >上架</option>
		    	   <option value="2" >下架</option>
		    	   <option value="3" >删除</option>
		    	</select>
		    </div>
		    <label class="layui-inline tt">专业:</label>
		     <div class="layui-input-inline">
		    	<select class="layui-input"  width="150" name="subjectId"  id="subjectId">
		    	   <option value="-1" selected="selected">请选择</option>
		    	</select>
		    </div>
		    <label class="layui-inline tt" >创建时间:</label>
		    <div class="layui-input-inline">
		    	<input  id="beginTime" name="beginTime" value="${ beginTime}" class="layui-input search_input"   type="date">
		    </div>
		    <label class="layui-inline tt">-</label>
		    <div class="layui-input-inline">
		    	<input id="endTime"  name="endTime" value="${ endTime}" class="layui-input search_input"  type="date">
		    </div>
		    <button class="layui-btn search_btn" type="submit">课程查询</button>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-default" onclick="cleanText()">清空</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal newsAdd_btn"  href="/admin/course/toCourseAdd">创建课程</a>
		</div>
		</form>
	</blockquote>
            
		    <div class="layui-tab-content larry-personal-body clearfix mylog-info-box">
		         <!-- 操作日志 -->
                <div class="layui-tab-item layui-field-box layui-show">
                     <table class="layui-table table-hover" lay-even="" lay-skin="nob">
                          <thead>
                              <tr>
                                  <th><input type="checkbox" id="selected-all"></th>
                                  <th>ID</th>
                                  <th>课程名</th>
                                  <th>状态</th>
                                  <th>专业</th>
                                  <th>原价</th>
                                  <th>优惠价</th>
                                  <th>课时</th>
                                  <th>销售量</th>
                                  <th>浏览量</th>
                                  <th>创建时间</th>
                                  <th>有效结束时间</th>
                                  <th>操作</th>
                              </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${eduCourses }" var="ec" varStatus="statu">
                              <tr>
                                <td>
                                   <input type="checkbox"  value="${ec.course_id }">
                                </td>
                                <td>${statu.index+1 }</td>
                                <td>${ec.course_name }</td>
                                <c:if test="${ec.is_avaliable==1 }">
                                   <td>上架</td>
                                </c:if>
                                <c:if test="${ec.is_avaliable==2 }">
                                   <td>下架</td>
                                </c:if>
                                <c:if test="${ec.is_avaliable==3 }">
                                   <td>删除</td>
                                </c:if>
                                <td>${ec.sysSubject.subjectName }</td>
                                <td>${ec.source_price }</td>
                                <td>${ec.current_price }</td>
                                <td>${ec.lession_num }</td>
                                <td>${ec.page_buyCount }</td>
                                <td>${ec.page_viewCount }</td>
                                <td><fmt:formatDate value="${ec.add_time }" pattern="yyyy-MM-dd HH:mm"/></td>
                                <c:if test="${ec.end_time==null||ec.end_time=='' }">
                                    <td>购买后${ec.lose_time }天</td>
                                </c:if>
                                <c:if test="${ec.end_time!=null&&ec.end_time!='' }">
                                    <td><fmt:formatDate value="${ec.end_time }" pattern="yyyy-MM-dd HH:mm"/></td>
                                </c:if>
                                <td>
                                    <a href="/admin/kpoint/kpointList/${ec.course_id }" class="btn btn-default ">章节管理</a>
                                    <a href="/admin/course/courseDelete/${ec.course_id }" class="btn btn-default ">删除</a>
                                    <a href="/admin/course/toCourseEdit/${ec.course_id }" class="btn btn-default">修改</a>
                                </td>
                              </tr>
                              </c:forEach>
                          </tbody>
                     </table>
                     <div class="larry-table-page clearfix">
                          <a href="javascript:;" class="layui-btn layui-btn-small"><i class="iconfont icon-shanchu1"></i>删除</a>
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
					pages: '${info.pages}' , //总页数
					curr: '${info.pageNum}',
					groups: 5 ,    //连续显示分页数
					jump: function(obj, first) {
						//得到了当前页，用于向服务端请求对应数据
						var curr = obj.curr;
						if(!first) {
							//layer.msg('第 '+ obj.curr +' 页');
							document.forms[0].action="/admin/course/courseList?currentPage="+curr;
							document.forms[0].submit();
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