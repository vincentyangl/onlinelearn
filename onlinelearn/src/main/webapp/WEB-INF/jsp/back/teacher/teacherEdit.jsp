<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师修改</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">

<link rel="stylesheet" href="/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
<link rel="stylesheet" href="/ztree/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript" src="/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/ztree/js/jquery.ztree.excheck.js"></script>

<script type="text/javascript">
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

	var zNodes = $
	{
		sysSubjects
	};

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
</script>
</head>



<body>

	<div class="container">
		<div class="form-horizontal">
			<form action="/admin/teacher/update" method="post"
				enctype="multipart/form-data">
				<input type="hidden" class="form-control" name="id" id="id"
					value="${e.id }"> <input type="hidden" id="id"
					name="subjectId" value="${e.sysSubject.subjectId }" />
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师名称</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="name" id="name"
							placeholder="讲师名" value="${e.name }">
					</div>
				</div>
				<div class="form-group">
					<label for="is_star" class="col-sm-2 control-label">讲师专业</label>
					<div class="">
						<div class="zTreeDemoBackground left">
							<ul class="list">
								<li class="title"><input id="citySel" type="text" readonly
									value="${e.sysSubject.subjectName }" style="width: 120px;"
									onclick="showMenu();" /></li>
							</ul>
						</div>
					</div>
					<div id="menuContent" class="menuContent"
						style="display: none; position: absolute; z-index: 9999">
						<ul id="treeDemo" class="ztree"
							style="margin-top: 0; width: 180px; height: 300px;"></ul>
					</div>
				</div>
				<div class="form-group">
					<label for="is_star" class="col-sm-2 control-label">讲师头衔</label>
					<div class="col-sm-3">
						<select class="form-control" name="isStar" class="star">
							<c:if test="${e.isStar==1 }">
								<option value="1">高级讲师</option>
							</c:if>
							<c:if test="${e.isStar==2 }">
								<option value="2">首席讲师</option>
							</c:if>
							<option value="1">高级讲师</option>
							<option value="2">首席讲师</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师排序</label>
					<div class="col-sm-3">
						<input type="text" id="sort" name="sort" class="form-control"
							placeholder="排序" value="${e.sort }" />
					</div>
				</div>
				<div class="form-group">
					<label for="education" class="col-sm-2 control-label">讲师资历</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" name="education"
							id="education" placeholder="资历" value="${e.education }">
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">讲师简介</label>
					<div class="col-sm-5">
						<textarea name="career" class="form-control" rows="3" id="career"
							value="">${e.career }</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="pic_path" class="col-sm-2 control-label">讲师头像</label>
					<div class="col-sm-4">
						<img name="img" id="img" src="${e.picPath }"
							style="width: 260px; height: 300px;"> <input type="file"
							name="file" value="">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label"></label>
					<div class="col-sm-4">
						<input type="button" onclick="getContent()" class="layui-btn" value="确定" />&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" onclick="nullTeacher()"
							class="layui-btn" value="重置" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function getContent() {
			document.forms[0].action = "/admin/teacher/update";
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

		// 		document.getElementById('file').onchange = function() {
		// 			var imgFile = this.files[0];
		// 			var fr = new FileReader();
		// 			fr.onload = function() {
		// 				document.getElementById("img").style.display = "block";
		// 				document.getElementsByTagName('img')[0].src = fr.result;
		// 			};
		// 			fr.readAsDataURL(imgFile);
		// 		}
	</script>
</body>
</html>