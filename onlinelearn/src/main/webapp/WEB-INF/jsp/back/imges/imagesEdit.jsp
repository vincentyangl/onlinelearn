<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>编辑图片</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
    <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src="../../../js/jquery.tips.js"></script>
    	<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/css/bootstrap.min.css" />
<script src="/js/jquery-3.0.0.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap-table.min.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
	
<link rel="stylesheet" type="text/css" href="/css/main.css" />
<link rel="stylesheet" type="text/css" href="/css/jquery.bigcolorpicker.css" />
<script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.bigcolorpicker.min.js"></script>
    
    <style type="text/css">
    #img1{
     width="40" height="40";
    }
    #img2{
     width="20" height="20"
    }
    
    </style>

<script type="text/javascript">
//   var e=^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$;
//   var em= ^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$;
//   var reg1 = /^0?1[3|4|5|8][0-9]\d{8}$/;
  
      function cz() {
    	  $("#color").val("");
    	  $("#biaoti").val("");
    	  $("#neirong").val("");
		
	}
      

  
    
</script>

</head>
<body>
<section class="layui-larry-box">
	<div class="larry-personal">
		<header class="larry-personal-tit">
			<span>编辑图片</span>
		</header>
		<div class="larry-personal-body clearfix">
<!-- 		 enctype="multipart/form-data" -->
		<form action="" method="post" enctype="multipart/form-data">
			<div class="layui-form-item">
					<label class="layui-form-label">图片标题</label>
					<div class="layui-input-block"> 
					<input type="hidden" id="imge_id" name="imge_id"  class="layui-input " value="${list.imge_id}" autocomplete="off" style="width:300px;"> 
						<input type="text" id="title" name="title"  class="layui-input " value="${list.title}" autocomplete="off" style="width:300px;">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" >图片描述</label>
					<div class="layui-input-block"> 
						
						<input type="text" id="describes" name="describes"  class="layui-input " value="${list.describes}" style="width:300px;" >
					</div>
				</div>
				
<!-- 				<div class="layui-form-item "> -->
<!-- 					<label class="layui-form-label">图片类型</label> -->
<!-- 					<div class="layui-input-block"> -->
<!-- 						<select  name="type_ids" id="type_ids" > -->
<!-- <!-- 						class="form-control" --> 
<%-- 						<c:forEach items="${type}" var="t"> --%>
<%-- 							<option value="${t.type_id}" >${t.type_name}</option> --%>
<%-- 							</c:forEach> --%>
<!-- 						</select> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
					<div class="layui-input-inline  ">
<!-- 								<label class="sr-only" for="exampleInputEmail3">图片类型</label>  -->
                                   <label class="layui-form-label layui-col-md9">图片类型</label>
                        <div class="layui-input-block" style="width: 300px;">
								<select id="type_id" name="type_id" class="form-control ">
<!-- 									<option value="-1">--请选择类型--</option> -->
									<c:forEach items="${type}" var="t">
											<option value="${t.type_id }">${t.type_name }</option>
									</c:forEach>
								</select>
						</div>
							</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" >跳转链接</label>
					<div class="layui-input-block">
					   <input type="text" id="link_address" name="link_address"  class="layui-input " value="${list.link_address}" style="width:300px;" >
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" >排序</label>
					<div class="layui-input-block">
					<input type="text"  id="series_number" name="series_number"  class="layui-input " value="${list.series_number}" style="width:300px;" >
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" >图片</label>
					<div class="layui-input-block">
					    <image id="blah1" src="${list.image_url}" style="width:300px; height:150px;" />
						<input type="file" name="file1" id="file1"  /><br>
						<input type="hidden" name="hiddens" id="" value="${list.image_url}" />
					</div>
				</div>
<!-- 				<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label">略缩图片</label> -->
<!-- 					<div class="layui-input-block"> -->
<%-- 						<input type="file" name="preview_url" id="img2" value="${list.preview_url}" /><br> --%>
<!-- 					</div> -->
<!-- 				</div> -->
				
				<div class="layui-form-item">
					<label class="layui-form-label" >背景色</label>
					<div class="layui-input-block">
					<input type="text" id="color" name="color"  class="layui-input " value="${list.color}" style="width:300px;" >
					<div></div>
					<input id="btn" class="layui-btn " type="button" value="选色" style="width:300px;" />
					</div>
				</div>

				
				<div class="layui-form-item">
					<div class="layui-input-block">
<!-- 					 <button type="submit" class="layui-btn" >确认修改</button> -->
<!--                      <button type="button" class="layui-btn" onclick="up()">确认修改</button> -->
<!--                      <a class="layui-btn search_btn" onclick="up()"  >确认修改</a> -->
							<button class="layui-btn" onclick="up()" >
								<i class="layui-icon" >&#xe608;</i> 确认修改
							</button>
							<button type="reset" class="layui-btn" onclick="cz()">重置</button>
					</div>
				</div>
		</div>
</form>
</section>
<script type="text/javascript">
function up() {
	   document.forms[0].action="/admin/imge/toupdate";
	   document.forms[0].submit();
}
function readURL1(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#blah1').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}

$("#file1").change(function() {
	readURL1(this);
});
$(function(){
	$("#btn").bigColorpicker("color");
});

//function up() {
// var imge_id=$("#imge_id").val();
// var title=$("#title").val();
// var describes=$("#describes").val();
// var type_id=$("#type_id").val();
// var link_address=$("#link_address").val();
// var series_number=$("#series_number").val();
// var img1=$("#img1").val();
// var img2=$("#img2").val(); 
// var color=$("#color").val();
// alert(imge_id);
//// 		document.forms[0].action="/admin/imge/toupdate";
//// 		  document.forms[0].submit();
//// 		  alert("跳转修改！");
// window.location.href="/admin/imge/toupdate?imge_id="+imge_id+"&title="+title+"&describes="+describes+"&type_id="+type_id+"&link_address="+link_address+"&series_number="+series_number+"&img1="+img1+"&img2="+img2+"&color="+color; 
//}
</script>

</body>
</html>