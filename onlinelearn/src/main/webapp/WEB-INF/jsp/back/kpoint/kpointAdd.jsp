<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>节点添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
	<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
  <script type="text/javascript" src="/js/jquery.js"></script>
<style type="text/css">
   #time1{
      display: none
   }
   body{
      background-color: white;
   }
   .layui-input-block{
   width:73%
   }
</style>
<script type="text/javascript">

$(function(){
	layui.use('form', function(){
		var form = layui.form; 
		form.render();
		});
})
	 
		
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span id="sp1">添加课程节点</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="/admin/kpoint/kpointAdd" method="post" >
					<div class="layui-form-item">
						<label class="layui-form-label ">节点名称:</label>
						<div class="layui-input-block">
						<input type="hidden"  name="pId"  value="${pId }" />
						    <input type="hidden"  value="${courseId }"  name="courseId" id="courseId"/>
							<input type="text"  id="name" name="name"  autocomplete="off"
								class="layui-input " lay-verify="name">
						</div>
					</div>
					
					<c:if test="${mid==-1 }">
						<div class="layui-form-item">
							<label class="layui-form-label">节点类型:</label>
							<div class="layui-input-block">
								<select class="layui-input" width="150" name="kpointType" id="kpointType">
								       <option value="0" >目录</option>
							    </select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">文件类型:</label>
							<div class="layui-input-block">
								<select class="layui-input"  name="fileType" id="fileType">
									<option value="VIDEO" >视频</option>
								</select>
							</div>
						</div>
					</c:if>
					<c:if test="${mid!=-1 }">
						<div class="layui-form-item">
							<label class="layui-form-label">节点类型:</label>
							<div class="layui-input-block">
								<select class="layui-input" width="150" name="kpointType" id="kpointType">
								       <option value="1" >章节</option>
							    </select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">文件类型:</label>
							<div class="layui-input-block">
								<select class="layui-input"  name="fileType" id="fileType">
										<option value="VIDEO" >视频</option>
										<option value="TXT" >文件</option>
									</select>
							</div>
						</div>
					</c:if>
					
					<div class="layui-form-item">
							<label class="layui-form-label">授课老师:</label>
							<div class="layui-input-block">
								<select class="layui-input"   name="eduTeacher.id" id="teacherId">
								        <option value="-1" >请选择</option>
										<c:forEach items="${ts }" var="t">
										    <option value="${t.id }" >${t.name }</option>
										</c:forEach>
									</select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">排序:</label>
							<div class="layui-input-block">
								<input type="text"  id="sort" name="sort"  autocomplete="off"
								class="layui-input "  lay-verify="sort">
							</div>
						</div>
					    <div class="layui-form-item">
							<label class="layui-form-label">是否免费:</label>
							<div class="layui-input-block">
								<select class="layui-input"   name="isFree" id="isFree">
								        <option value="1" >是</option>
								        <option value="2" >否</option>
								</select>
							</div>
						</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn"  lay-submit="" lay-filter="demo1" >确定</button>
							<button type="reset"   class="layui-btn layui-btn-primary">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="/common/larry/layui/layui.js"></script>
	<script type="text/javascript">
	     
	//表单验证
	layui.use(['form', 'layedit', 'laydate'], function(){
		  var form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  
		  //自定义验证规则
		  form.verify({
			  name: function(value){
		      if(value.length < 3){
		        return '课程章节名至少得3个字符啊';
		      }
		      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		          return '课程章节名不能有特殊字符';
		        }
		    }
		    ,sort: [/^([1-9]\d*|[0]{1,1})$/, '排序只能是自然数']
		  });
		  
		  //监听提交
		  form.on('submit(demo1)', function(data){
			   var  teacherId = $("#teacherId").val();
			   if(teacherId==-1){
				   layer.alert('请选择教师!');
				   return false;
			   }
			  /*  layer.alert(JSON.stringify(data.field), {
			      title: '最终的提交信息'
			    });  */
			  return true;
		  });
		  
		});
	
	</script>
</body>
</html>