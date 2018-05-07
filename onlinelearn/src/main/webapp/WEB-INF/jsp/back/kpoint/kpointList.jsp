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
        edit: {  
            enable: true,  
            editNameSelectAll:true,  
        },
		data : {
			simpleData : {
				enable : true
			},
			keep:{  
                parent:true,  
                leaf:true  
            }
		},
		callback : {
			beforeRemove:beforeRemove,//点击删除时触发，用来提示用户是否确定删除  
			onRemove:onRemove,//删除节点后触发，用户后台操作
			onClick: returnPage,  //跳转界面
			beforeClick : zTreeBeforeClick
		}
	};

	var zNodes = ${eduKpoints};

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
		 /* var rootNode = {id:0,name:"根节点",pId:null,open:true}; 
		zNodes.push(rootNode);*/
		$.fn.zTree.init($("#myTree"), setting, zNodes);
		setCheck();
		$("#py").bind("change", setCheck);
		$("#sy").bind("change", setCheck);
		$("#pn").bind("change", setCheck);
		$("#sn").bind("change", setCheck);
	});

	function beforeRemove(e,treeId,treeNode){  
        return confirm("你确定要删除吗？");  
    }  
	
    function onRemove(e,treeId,treeNode){  
        if(treeNode.isParent){  
            var childNodes = zTree.removeChildNodes(treeNode);  
            var paramsArray = new Array();  
            for(var i = 0; i < childNodes.length; i++){  
                paramsArray.push(childNodes[i].id);  
            }  
            alert("删除父节点的id为："+treeNode.id+"\r\n他的孩子节点有："+paramsArray.join(","));  
            return;  
        }  
        alert("你点击要删除的节点的名称为："+treeNode.name+"\r\n"+"节点id为："+treeNode.id);  
    }  
	
	 function returnPage(event, treeId, treeNode) {
         $("#otherpage").attr("src","/admin/kpoint/toKpointEdit/"+treeNode.id);
     }
	 
	 function zTreeBeforeClick(treeId, treeNode, clickFlag) {
			id = treeNode.id;
			name = treeNode.name;
		};

	function toAdd() {
		if (id == -1) {
			alert("请选择哪个节点下添加");
		}
		if (id != -1) {
			$("#otherpage").attr("src","/admin/kpoint/toKpointAdd/"+id);
		}
	}
	
	
	
	
	
</script>
</head>
<body>

	


<table width="100%">
   <tr>
       <td width="20%" bgcolor="white" valign="top"><br>
           <div align="left" style="font-weight:bold">菜单栏</div><br>
           <ul id="myTree" class="ztree"  height="500"></ul>
           <a href="#" class="btn btn-default " onclick="toAdd()">添加</a>
        </td>
        <td width="80%" bgcolor="white" valign="top">
            <iframe src="/admin/kpoint/toBlank"  id="otherpage" width="100%" height="900" scrolling="auto" frameborder="0"></iframe>
         </td>
    </tr>
</table>

</body>
</html>