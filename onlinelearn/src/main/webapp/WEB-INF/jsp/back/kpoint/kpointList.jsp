<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>节点管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<!-- <link rel="stylesheet" type="text/css" href="/ztree/css/demo.css" /> -->
<link rel="stylesheet" type="text/css"
	href="/ztree/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<script src="/ztree/js/jquery-1.4.4.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script src="/ztree/js/jquery.ztree.core.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/ztree/js/jquery.ztree.excheck.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/ztree/js/jquery.ztree.exedit.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="/common/bootstrap/js/bootstrap.js"></script>
<style>
#myTree {
	width: 100%;
	height: 100%;
}

.zTreeDemoBackground {
	margin-left: 500px;
}
</style>
<script type="text/javascript">
	var id = -1;
	var name;
	var setting = {
		check : {
			enable : true
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : zTreeBeforeClick
		}
	};

	var zNodes = ${sysFunctions};

	var code;

	function setCheck() {
		var zTree = $.fn.zTree.getZTreeObj("myTree"), py = $("#py").attr(
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
		var rootNode = {id:0,name:"所有管理",pId:null,open:true};
		zNodes.push(rootNode);
		$.fn.zTree.init($("#myTree"), setting, zNodes);
		setCheck();
		$("#py").bind("change", setCheck);
		$("#sy").bind("change", setCheck);
		$("#pn").bind("change", setCheck);
		$("#sn").bind("change", setCheck);
	});

	function zTreeBeforeClick(treeId, treeNode, clickFlag) {
		id = treeNode.id;
		name = treeNode.name;
	};

	function toAdd() {
		if (id == -1) {
			alert("请选择添加板块");
		}
		if (id != -1) {
			 $("#myModal").modal("show");
		}
	}
	
	function add(){
		var qname= $("#name").val();
		if(qname==null||qname.trim().length==0){
			alert("不能为空!");
		}else{
			$("#pId").val(id);
			document.forms[0].action="/admin/permissions/addPermissions";
			document.forms[0].submit();
		}
	}
	
	
	
</script>
</head>
<body>

	

	<div class="zTreeDemoBackground ">
		<ul id="myTree" class="ztree"></ul>
	</div>
    <div>
		<a href="#" class="btn btn-default " onclick="toAdd()">添加</a>
	</div>

<table>
   <tr>
       <td width="10%" bgcolor="#CCCC66" valign="top"><br>
           <div align="center" style="font-weight:bold">菜单栏</div><br>
           <ul id="tree" class="tree" style="width:180px; overflow:auto;"></ul>
        </td>
        <td width="90%" bgcolor="#D3D3D3" valign="top">
            <iframe src="/admin/kpoint/kpointEdit"  id="otherpage" width="100%" height="900" scrolling="auto" frameborder="0"></iframe>
         </td>
    </tr>
</table>

</body>
</html>