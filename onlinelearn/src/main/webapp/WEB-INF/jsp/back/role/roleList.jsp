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
<title>个人信息</title>
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
</style>
<script type="text/javascript">
var nodes;

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
		onCheck : onCheck
	}
};

var zNodes = ${sysFunctions};

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
function onCheck(e,treeId,treeNode){    
	var treeObj=$.fn.zTree.getZTreeObj("myTree"),    
	nodes=treeObj.getCheckedNodes(true),    
	v="";    
	for(var i=0;i<nodes.length;i++){    
	    v+=nodes[i].name + ",";    
	   // alert(nodes[i].id); //获取选中节点的值   
	    }   
	 } 
$(document).ready(function(){
	$.post("/admin/role/roleList",function(msg){
		 for(i=0;i<msg.length;i++){
			   $("#roleId").append("<option value='"+msg[i].roleId+"'>"+msg[i].roleName+"</option>");
		   }
	});
});

function checkAllNodeOff(){//默认全部不勾选  
    var zTree = $.fn.zTree.getZTreeObj("myTree");  
    zTree.checkAllNodes(false);  
}  

function roleChange(){
	checkAllNodeOff();
	var zTree = $.fn.zTree.getZTreeObj("myTree"); 
	var roleId = $("#roleId").val();
	if(roleId==-1){
		alert("请选择角色");
		return false;
	}
	$.ajax({
		url:"/admin/role/getById",
		data:{roleId:roleId},
		async:true,
		dataType:"json",
		success:function(msg){
			if(msg!=null){
				for(i=0;i<msg.length;i++){
					var node = zTree.getNodeByParam("id", msg[i].id);   
					zTree.checkNode(node,true,true,false);
				}
			}
		}
	});
}

function toUpdateRoleName(){
	$("#updateModal").modal("show");
	var rid = $("#roleId option:selected").val();
	$("#rid").val(rid);
	var rname=$("#roleId option:selected").text();
	$("#rname").val(rname);
}
	
function updateRoleName(){
	document.forms[0].action="/admin/role/updateRole";
	document.forms[0].submit();
} 

function toaddRole(){
	$("#myModal").modal("show");
}

function addRole(){
	var roleName = $("#roleName").val();
	if(roleName==null||roleName.trim().length==0){
		alert("角色名称不能为空!");
	}else{
		document.forms[1].action="/admin/role/addRole";
		document.forms[1].submit();
	}
}

function deleteRole(){
	var roleId = $("#roleId").val();
	if(roleId==-1){
		alert("请选择角色！");
	}else{
		window.location.href="/admin/role/deleteRole/"+roleId;
	}
}
//给角色授权
function roleAuthorize(){
	var roleId = $("#roleId").val();
	if(roleId==-1){
		alert("请选择角色！");
	}else{
		var treeObj=$.fn.zTree.getZTreeObj("myTree");   
		var addNodes=treeObj.getCheckedNodes(true); 
		if(addNodes.length==0){
			alert("赋予权限个数不能为0");
		}else{
			var functionIds = new Array();
			for(var i=0;i<addNodes.length;i++){    
				functionIds[i] = addNodes[i].id;
		    } 
			window.location.href="/admin/role/roleAuthorize/"+roleId+"/"+functionIds;
		}
	}
}

</script>
</head>
<body>

<h3>角色管理</h3>
<div>
<table width="800" >
   <tr>
       <td>
           <select class="form-control" name="roleId" onchange="roleChange()" id="roleId">
                <option value="-1">请选择</option>
			</select>
	   </td>
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
	    <button type="button" onclick="toUpdateRoleName()" class="btn btn-default">修改角色名称</button>
	    <button type="button" onclick="toaddRole()" class="btn btn-default">添加角色</button>
	    <a href="#" onclick=" roleAuthorize()" class="btn btn-default">保存</a>
	    <a  href="#" onclick="deleteRole()" class="btn btn-default">删除选中角色</a>
	</div>
	
	<!-- 修改角色名称  -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改角色名称</h4>
      </div>
      <div class="modal-body">

					<form class="form-horizontal" action="" method="POST">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">角色名称:</label>
							<div class="col-sm-9">
							    <input type="hidden" class="form-control" id="rid"  name="roleId">
								<input type="text" class="form-control" id="rname"  name="roleName">
							</div>
						</div>
					</form>

				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary"  onclick="updateRoleName()">确定</button>
      </div>
    </div>
  </div>
</div>
	

<!-- 添加角色 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加角色</h4>
      </div>
      <div class="modal-body">

					<form class="form-horizontal">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">角色名称:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control"  id="roleName"  name="roleName">
							</div>
						</div>
					</form>

				</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary"  onclick="addRole()">确定</button>
      </div>
    </div>
  </div>
</div>



</body>
</html>