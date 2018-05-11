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
<link rel="stylesheet" href="/ztree/css/demo.css" type="text/css">
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
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		},
		view : {
			dblClickExpand : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : onClick,
			onCheck : onCheck
		}
	};

	var zNodes = ${sysSubjects};

	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.checkNode(treeNode, !treeNode.checked, null, true);
		return false;
	}
	var v = "";
	var a = 0;
	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"), nodes = zTree
				.getCheckedNodes(true), v = "";
		for (var i = 0, l = nodes.length; i < l; i++) {
			v += nodes[i].name + ",";
		}
		for (var i = 0, l = nodes.length; i < l; i++) {
			a = nodes[i].id;
		}
		if (v.length > 0)
			v = v.substring(0, v.length - 1);
		var cityObj = $("#citySel");
		cityObj.attr("value", v);
		$("#id").val(a);
	}

	function showMenu() {
		var cityObj = $("#citySel");
		var cityOffset = $("#citySel").offset();
		$("#menuContent").css({
			left : cityOffset.left + "px",
			top : cityOffset.top + cityObj.outerHeight() + "px"
		}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "citySel"
				|| event.target.id == "menuContent" || $(event.target).parents(
				"#menuContent").length > 0)) {
			hideMenu();
		}
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</SCRIPT>

</head>
<body>

	<div class="container">
		<div class="form-horizontal">
			<form action="/admin/teacher/save" method="post"
				enctype="multipart/form-data">
				<input type="hidden" id="id" name="subjectId" value="" />
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师名称</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="name" id="name"
							placeholder="讲师名" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="is_star" class="col-sm-2 control-label">讲师专业</label>
					<div class="content_wrap">
						<div class="zTreeDemoBackground left">
							<ul class="list">
								<li class="title"><input id="citySel" type="text" readonly
									value="" style="width: 120px;" onclick="showMenu();" /></li>
							</ul>
						</div>
					</div>
					<div id="menuContent" class="menuContent"
						style="display: none; position: absolute;">
						<ul id="treeDemo" class="ztree"
							style="margin-top: 0; width: 180px; height: 300px;"></ul>
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
							name="file" value="" onchange="checkImgType(this)">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"></label>
					<div class="col-sm-4">
						<input type="submit" class="btn btn-info" value="添加" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" class="btn btn-default" value="重置" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	/* function toAdd(){
		var fileName =document.getElementsByName("file");
		if (fileName == "NodeList") {
			alert("请上传图片");
		}else{
			document.forms[0].action="/admin/teacher/save";
			document.forms[0].submit();
		}
	} */
		function checkImgType(ths) {
			if (ths.value == "") {
				alert("请上传图片");
				return false;
			} else {
				if (!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(ths.value)) {
					alert("图片类型必须是.gif,jpeg,jpg,png中的一种");
					ths.value = "";
					return false;
				}
			}
			return true;
		}

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