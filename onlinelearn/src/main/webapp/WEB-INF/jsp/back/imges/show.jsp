<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片</title>
</head>
<body>
<img alt="" src="/upload/${filename }">
<img alt="" src="/upload/${filename2 }">


<!-- 

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
	
	
<!-- 	<meta name="renderer" content="webkit">	 -->
<!-- 	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	 -->
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	 -->
<!-- 	<meta name="apple-mobile-web-app-status-bar-style" content="black">	 -->
<!-- 	<meta name="apple-mobile-web-app-capable" content="yes">	 -->
<!-- 	<meta name="format-detection" content="telephone=no">	 -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all"> -->
<!-- 	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all"> -->
<!--     <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script> -->
<!--     <script type="text/javascript" src="../../../js/jquery.tips.js"></script> -->
<!--     <style type="text/css"> -->
<!-- /*     #img1{ */ -->
<!-- /*      width="40" height="40"; */ -->
<!-- /*     } */ -->
<!-- /*     #img2{ */ -->
<!-- /*      width="20" height="20" */ -->
<!-- /*     } */ -->
    
<!--     </style> -->



</head>
<style type="text/css">
.input1 {
	width: 500px;
}

table {
	border-collapse: separate;
	border-spacing: 0px 10px;
}

.t1 {
	text-align: center;
}

.t2 {
	padding-left: 200px;
}

input {
	width: 300px;
}

#preview_url {
	height: 180px;
	width: 300px;
}

body {
	background-color: #FAFAFA;
}
</style>

<body>
<form action="/admin/imge/upload" enctype="multipart/form-data"
		method="post">
		<table width="100%">
			<tr>
				<td>图片标题*</td>
				<td><input type="text" name="title" id="title" value="" /></td>
			</tr>
			<tr>
				<td>图片描述*</td>
				<td><input type="text" name="describes" id="describes" value="" /></td>
			</tr>
			<tr>
				<td>图片类型*</td>
				<td>
				<select name="type_ids" id="type_id" >
						<c:forEach items="${type}" var="t">
							<option value="${t.type_id}">${t.type_name}</option>
						</c:forEach>
				</select> <!-- 				<select id="type_id" name="type_ids"> -->
<%-- 						<c:forEach items="${listType }" var="t"> --%>
<%-- 							<option value="${t.type_id}">${t.type_name}</option> --%>
<%-- 						</c:forEach> --%>
<!-- 				</select> -->
				
				</td>
			</tr>
			<tr>
				<td>跳转链接*</td>
				<td><input type="text" name="link_address" id="link_address"
					value="" /></td>
			</tr>
			<tr>
				<td>排序*</td>
				<td><input type="text" name="series_number" id="series_number"
					value="" /></td>
			</tr>
			<tr>
				<td style="width: 100px"><h4>图片:</h4></td>
				<td>
					<table>
						<tr>
							<td><image id="blah1" style="width:300px; height:150px;" /></td>
							<td><input type="file" name="image_url" id="file1"></td>
<!-- 							<td><input type="hidden" name="preview_url" value="" /></td> -->
							<td><font color="red">(请上传宽高为：640*357的图片)</font></td>
						</tr>
					</table>
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td style="width: 100px"><h4>封面图片:</h4></td> -->
<!-- 				<td> -->
<!-- 					<table> -->
<!-- 						<tr> -->
<!-- 							<td><image id="blah2" style="width:300px; height:150px;" /></td> -->
<!-- 							<td><input type="file" name="preview_url" id="file2"></td> -->
<!-- 							<td><font color="red">(请上传宽高为：640*357的图片)</font></td> -->
<!-- 						</tr> -->
<!-- 					</table> -->
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td>背景</td>
				<td><input type="text" name="color"  id="color" value="" placeholder="橘色:#FF4500 橙色:#FF7F00 粉色:#FFAEB9" />
				<input id="btn" type="button" value="选色" /></td>
			</tr>

<!-- 			<div class="form-group"> -->
<!-- 				<label for="inputPassword3" class="col-sm-2 control-label">背景颜色:</label> -->
<!-- 				<div class="col-sm-10"> -->
<!-- 					<input type="text" id="color" /><input id="btn" type="button" -->
<!-- 						value="选色" /> -->
<!-- 				</div> -->
<!-- 			</div> -->

		</table>
		<input type="submit" value="保存" /> 
		<input type="button" value="重置" onclick="resultFun()" />
		<input type="button" value="返回列表" onclick="returnFun()" />
	</form>

 -->


</body>
</html>