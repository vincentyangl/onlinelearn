<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文章修改</title>

<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" haref="/css/personal.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

</head>
<body>



	<form class="layui-form" action=""
		method="post" enctype="multipart/form-data">

		<div class="layui-form-item">
			<label class="layui-form-label"></label>
			<div class="layui-input-block">
				<input class="layui-input newsName" lay-verify="required"
					type="hidden" name="articleId" value="${edu_Article.articleId }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">标题:</label>
			<div class="layui-input-block">
				<input class="layui-input newsName" lay-verify="required"
					type="text" name="title" value="${edu_Article.title }">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">摘要:</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea" name="summary">${edu_Article.summary }</textarea>
			</div>
		</div>

		<div class="layui-inline">
			<label class="layui-form-label">作者:</label>
			<div class="layui-input-block">
				<input class="layui-input newsAuthor" lay-verify="required"
					name="author" value="${edu_Article.author }" type="text">
			</div>
		</div>

		<div class="layui-item">
			<label class="layui-form-label">来源:</label>
			<div class="layui-input-block">
				<input class="layui-input newsAuthor" lay-verify="required"
					name="source" value="${edu_Article.source }" type="text">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">头像</label>
			<div class="layui-input-block">
				<img alt="头像图片" src="${edu_Article.imageUrl }" name="imageUrl"
					id="blah" style="height: 200px; width: 200px" /><input type="file"
					name="file" id="file">
					<input type="hidden" name="hidden" value="${edu_Article.imageUrl }">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">内容:</label>
			<div class="layui-input-block">
				<script type="text/plain" id="myEditor"
					style="width:1000px;height:240px;">${edu_Article_Content.content}</script>
				<div class="clear"></div>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">排序值:</label>
			<div class="layui-input-inline">
				<input class="layui-input newsAuthor" lay-verify="required"
					name="sort" value="${edu_Article.sort }" type="text">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<input type="button" onclick="getContent()" class="layui-btn" lay-filter="addNews"
					value="修改" />
			</div>
		</div>
		<input type="hidden" name="content" id="content" value="${edu_Article_Content.content }">
	</form>

	<script type="text/javascript">
	function getContent() {
		var arr = UM.getEditor('myEditor').getContent();
		$("#content").val(arr);
		document.forms[0].action = "/admin/earticle/update";
		document.forms[0].submit();
	}
	
		layui.use([ 'form', 'upload' ], function() {
			var form = layui.form();
		});

		//  图片显示
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#file").change(function() {
			readURL(this);
		});
	</script>
	<script type="text/javascript">
		var ue = UM.getEditor('myEditor');
	</script>
</body>
</html>