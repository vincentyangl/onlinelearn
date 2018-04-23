<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>课程添加</title>
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
<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function renderForm(){
		 layui.use('form', function(){
		 var form = layui.form();//高版本建议把括号去掉，有的低版本，需要加()
		 form.render();
		 });
		 }
	   $(document).ready(function(){
		   $.post("/admin/subject/getSubjectList/2",function(msg){
			   for(i=0;i<msg.length;i++){
				 $("#parent_id").append("<option value='"+msg[i].subjectId+"'>"+msg[i].subjectName+"</option>");
			   }
			   renderForm();
		   });
	   });
	   
	   form.on('select(pageFilter)', function(data){
		   console.log(data);
		   renderForm();
		 }); 
	
	   
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span id="sp1">添加课程</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="/admin/user/userAdd"
					method="post">
					<div class="layui-form-item">
						<label class="layui-form-label ">课程名称:</label>
						<div class="layui-input-block">
							<input type="text" name="course_name" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">专业分类:</label>
						<div class="layui-input-inline">
							<select class="layui-input" lay-filter="pageFilter" width="150"
								name="parent_id" id="parent_id">
								<option value="-1" selected="selected">请选择</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select class="layui-input" width="150" name="subject_id"
								id="subject_id">
								<option value="-1" selected="selected">请选择</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态:</label>
						<div class="layui-input-block">
							<select class="layui-input" width="150" name="is_avaliable" id="is_avaliable">
								<option value="1" selected="selected">上架</option>
								<option value="2">下架</option>
								<option value="3">删除</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">总课时:</label>
						<div class="layui-input-block">
							<input type="text" name="lession_num" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程原价格:</label>
						<div class="layui-input-block">
							<input type="text" name="source_price" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程销售价格:</label>
						<div class="layui-input-block">
							<input type="text" name="current_price" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">有效期类型:</label>
						<div class="layui-input-block">
							<select class="layui-input" width="150" name="loseType" id="loseType">
								<option value="0" >到期时间</option>
								<option value="1" selected="selected">按天数</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">按天数:</label>
						<div class="layui-input-block">
							<input type="text" name="lose_time" autocomplete="off" class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">有效结束时间:</label>
						<div class="layui-input-block">
							<input type="date" name="end_time" autocomplete="off" class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">添加教师:</label>
						<div class="layui-input-block">
							<select class="layui-input" width="150" name="loseType" id="loseType">
								<option value="0" >到期时间</option>
								<option value="1" selected="selected">按天数</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">邮箱:</label>
						<div class="layui-input-block">
							<input type="text" name="email" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">电话号:</label>
						<div class="layui-input-block">
							<input type="text" name="tel" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" type="submit">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
</body>
</html>