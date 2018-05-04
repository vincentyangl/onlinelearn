<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加教师</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" href="/ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.excheck.js"></script>
<SCRIPT type="text/javascript">
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		}
	};

	var zNodes=${json};
	
	var code;

	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), py = $("#py").attr(
				"checked") ? "p" : "", sy = $("#sy").attr("checked") ? "s" : "", pn = $(
				"#pn").attr("checked") ? "p" : "", sn = $("#sn")
				.attr("checked") ? "s" : "", type = {
			"Y" : py + sy,
			"N" : pn + sn
		};
		zTree.setting.check.chkboxType = type;
		showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "'
				+ type.N + '" };');
	}
	function showCode(str) {
		if (!code)
			code = $("#code");
		code.empty();
		code.append("<li>" + str + "</li>");
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		setCheck();
		$("#py").bind("change", setCheck);
		$("#sy").bind("change", setCheck);
		$("#pn").bind("change", setCheck);
		$("#sn").bind("change", setCheck);
	});
</SCRIPT>

</head>
<body>

	<div class="container">
		<div class="form-horizontal">
			<form action="/admin/teacher/save" method="post"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师名称</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="name" id="name"
							placeholder="讲师名" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="is_star" class="col-sm-2 control-label">讲师专业</label>
					<div class="col-sm-3">
						<ul id="treeDemo" class="ztree"></ul>
					</div>
				</div>
				<div class="form-group">
					<label for="is_star" class="col-sm-2 control-label">讲师头衔</label>
					<div class="col-sm-3">
						<select class="form-control" name="isStar" class="star">
							<option value="1">高级讲师</option>
							<option value="2">首席讲师</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师排序</label>
					<div class="col-sm-3">
						<input type="text" id="sort" name="sort" class="form-control"
							placeholder="排序" value="" />
					</div>
				</div>
				<div class="form-group">
					<label for="education" class="col-sm-2 control-label">讲师资历</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="education"
							id="education" placeholder="资历" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师简介</label>
					<div class="col-sm-5">
						<textarea name="career" class="form-control" rows="3" id="career"
							value=""></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="pic_path" class="col-sm-2 control-label">讲师头像</label>
					<div class="col-sm-4">
						<span><img name="img" id="img" src=""
							style="width: 260px; height: 300px;"></span> <input type="file"
							name="file" value="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"></label>
					<div class="col-sm-4">
						<input type="submit" class="btn btn-info" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" onclick="nullTeacher()"
							class="btn btn-default" value="重置" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		document.getElementById('file').onchange = function() {
			var imgFile = this.files[0];
			var fr = new FileReader();
			fr.onload = function() {
				document.getElementById("img").style.display = "block";
				document.getElementsByTagName('img')[0].src = fr.result;
			};
			fr.readAsDataURL(imgFile);
		}
	</script>
</body>
</html>