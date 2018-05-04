<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%     String path=request.getContextPath();  
String basePath=request.getScheme()+"://"+request.getServerName()+":" +request.getServerPort()+path+"/"; %>
<base href="<%=basePath%>"> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>专业信息</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"  href="/ztree/css/zTreeStyle/zTreeStyle.css" />
<link rel="stylesheet" type="text/css"  href="/common/bootstrap/css/bootstrap.css" media="all">
<script src="/ztree/js/jquery-1.4.4.min.js" type="text/javascript"  charset="utf-8"></script>
<script type="text/javascript" src="/js/jquery.js"></script>
<script src="/ztree/js/jquery.ztree.core.js" type="text/javascript"  charset="utf-8"></script>
<script src="/ztree/js/jquery.ztree.excheck.js" type="text/javascript"  charset="utf-8"></script>
<script src="/ztree/js/jquery.ztree.exedit.js" type="text/javascript"  charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="/common/bootstrap/js/bootstrap.js"></script>
<style type="text/css">
  #myTree {
	width: 100%;
	height: 100%;
}
table{
    margin: 10px auto;
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
			enable : true,
			idKey: "id",  //设置启用简单数据格式时id对应的属性名称      
			pidKey: "pId", //设置启用简单数据格式时parentId对应的属性名称
			rootPId : "0"  //根节点
		}
	},
	callback : {
		beforeClick : zTreeBeforeClick
	}
};

var zNodes = ${sysSubjects};

var code;

function setCheck() {
	var zTree = $.fn.zTree.getZTreeObj("myTree"), 
	        py = $("#py").attr("checked") ? "p" : "", 
			sy = $("#sy").attr("checked") ? "s" : "", 
			pn = $("#pn").attr("checked") ? "p" : "", 
			sn = $("#sn").attr("checked") ? "s" : "", 
			type = {"Y" : py + sy,"N" : pn + sn};
	        zTree.setting.check.chkboxType = type;
	showCode('setting.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "'+ type.N + '" };');
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

function toaddSubject() {
	if (id == -1) {
		alert("请选择在哪个板块下添加专业");
	}
	if (id != -1) {
		 $("#myModal").modal("show");
	}
}

function addSubject(){
	var qname= $("#subjectName").val();
	if(qname==null||qname.trim().length==0){
		alert("不能为空!");
	}else{
		$("#parent_id").val(id);
		document.forms[0].action="/admin/subject/subjectAdd";
		document.forms[0].submit();
	}
}

function checkAllNodeOff(){//默认全部不勾选  
    var zTree = $.fn.zTree.getZTreeObj("myTree");  
    zTree.checkAllNodes(false);  
}  


	





</script>
</head>
<body>

<h3>专业管理</h3>
<div>
<table width="800" >
   <tr>
	   <td>
           <div class="zTreeDemoBackground ">
		        <ul id="myTree" class="ztree"></ul>
	       </div>
	       <input type="checkbox" id="py" class="checkbox first" checked style="display:none;" />    
           <input type="checkbox" id="sy" class="checkbox first" checked style="display:none;"/>    
           <input type="checkbox" id="pn" class="checkbox first" checked style="display:none;"/>    
           <input type="checkbox" id="sn" class="checkbox first" checked style="display:none;"/>
       </td>
   </tr>
</table>
</div>
	<div>
	    <button type="button" onclick="toaddSubject()" class="btn btn-default">添加专业</button>
	</div>
	


<!-- 添加专业 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加专业</h4>
      </div>
      <div class="modal-body">

					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">专业名称:</label>
							<div class="col-sm-9">
							    <input type="hidden" class="form-control"  id="parent_id"  name="parent_id">
								<input type="text" class="form-control"  id="subjectName"  name="subjectName">
							</div>
						</div>
					</form>

				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary"  onclick="addSubject()">确定</button>
      </div>
    </div>
  </div>
</div>



</body>
</html>