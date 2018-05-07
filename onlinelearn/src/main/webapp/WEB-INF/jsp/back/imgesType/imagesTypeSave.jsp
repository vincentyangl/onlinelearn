<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>发送邮件</title>
		<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css"  media="all" >
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css"  media="all">
	<link rel="stylesheet" type="text/css" href="/common/global.css"  media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css"  media="all">
	<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
	<script  language="javascript" src="/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
	
	 <link rel="stylesheet" type="text/css" href="/css/bootstrap.css" />
		<script src="/js/jquery-3.0.0.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/css/bootstrap-table.css" />
		<script src="/js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="/js/bootstrap-table-zh-CN.min.js" type="text/javascript" charset="utf-8"></script>
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
    	  
    	  $("#type_name").val("");
    	  $("#biaoti").val("");
    	  $("#neirong").val("");
		
	}
      
      function save() {
    	  var type_name=$("#type_name").val();
// 		  document.forms[0].action="/admin/imagetype/save";
// 		  document.forms[0].submit();
// 		  alert("save");
		  window.location.href="/admin/imagetype/save?type_name="+type_name;
	}

  
</script>

</head>
<body>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h3 class="modal-title" align="center" id="myModalLabel">添加图片类型</h3>
      </div>
      <div class="modal-body">
         
         
        <form class="form-horizontal" method="post">
						
							<div class="modal-footer">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-3 modal-title" style=" font-family:Arial,Verdana,Sans-serif; font-weight: normal;font-size:16px;" >输&nbsp;&nbsp;入&nbsp;&nbsp;名&nbsp;&nbsp;称</label>
<!--                                  <h6 class="modal-title" align="left" id="myModalLabel">****</h6> -->
								<div class="col-sm-9">
								    <input  type="hidden" class="form-control zh" id="type_id" name="type_id" >
									<input placeholder="请输入需要添加的图片类型" type="text" class="form-control zh" id="type_name" name="type_name" value="">
								</div>
							</div>
							</div>
							
							   </form>
						
      </div>
      <div class="modal-footer">
      <div class="col-sm-8">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="reset" class="btn btn-default" onclick="cz()">重置</button>
        <button type="button" class="btn btn-default"onclick="save()">添加</button>
        </div>
      </div>
   
    </div>
  </div>
</div>



<section class="layui-larry-box">
	<div class="larry-personal">
	    <div class="layui-tab">
            <blockquote class="layui-elem-quote news_search">
            
		        <form action="" method="post" >

						<div class="layui-inline">
						
                            <div class="layui-inline">
<!--                                 <a class="layui-btn search_btn" data-toggle="modal" data-target="#myModal2">添加类型</a> -->
                                <button type="button" class="layui-btn search_btn" data-toggle="modal" data-target="#myModal2">添加类型</button>
		                   </div>
						</div>
		</form>
	</blockquote>
		</div>
	</div>
</section>



<!-- <section class="layui-larry-box"> -->
<!-- 	<div class="larry-personal"> -->
<!-- 		<header class="larry-personal-tit"> -->
<!-- 			<span>新建类型</span> -->
<!-- 		</header> -->
<!-- 		<div class="larry-personal-body clearfix"> -->
<!-- 		<form action="/admin/imge/upload" method="post" enctype="multipart/form-data"> -->
<!-- 			<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label">图片标题</label> -->
<!-- 					<div class="layui-input-block">   -->
<!-- 						<input type="text"  name="title"  class="layui-input " autocomplete="off" style="width:250px;"> -->
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				<div class="layui-form-item"> -->
<!-- 					<label class="layui-form-label" >图片描述</label> -->
<!-- 					<div class="layui-input-block">  -->
						
<!-- 						<input type="text" name="describes"  class="layui-input " style="width:250px;" > -->
						
<!-- 					</div> -->
<!-- 				</div> -->
				
<!-- 				<div class="layui-form-item"> -->
<!-- 					<div class="layui-input-block"> -->
<!-- 					<button type="submit" class="layui-btn" >添加</button> -->
<!-- 					<button type="reset" class="layui-btn" onclick="cz()">重置</button> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 		</div> -->
<!-- </form> -->
<!-- </section> -->


</body>
</html>