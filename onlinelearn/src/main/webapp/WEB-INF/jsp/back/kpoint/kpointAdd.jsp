<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>节点添加</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
	<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script src="/js/jquery.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<style type="text/css">
   #time1{
      display: none
   }
   body{
      background-color: white;
   }
</style>
<script type="text/javascript">
function renderForm(){
	 layui.use('form', function(){
	 var form = layui.form();//高版本建议把括号去掉，有的低版本，需要加()
	 form.render();
	 });
	 }
	   $(function(){
		   $("#content").css("display","none");
		 
			  
			   
			
		   
	   });
		
		//清空输入框
		function cleanText(){
			$("#course_name").val("");
			$("#parent_id").val("-1");
			$(".op").remove();
			$(".op1").remove();
			$(".op2").remove();
			$(".tli").remove();
			tids.splice(0,tids.length);
			count = 0 ;
			$("#is_avaliable").val("-1");
			$("#lession_num").val("");
			$("#source_price").val("");
			$("#current_price").val("");
			$("#loseType").val("1");
			$("#id").val("-1");
			$("#tea1").remove("li");
			$("#lose_time").val("");
			$("#end_time").val("");
			$("#title").val("");
			$("#logo").val("");
			$("#context").val("");
		}
		
		function toEditKpoint(){
			var kpointType = $("#kpointType").val();
			if(kpointType==0){
				document.forms[0].action="/admin/kpoint/kpointCatalogEdit";
				document.forms[0].submit();
			}
			if(kpointType!=0){
				var fileType = $("#fileType").val();
				if(fileType==("TXT") ){
				    var context= UM.getEditor('myEditor').getContentTxt();
					$("#content").val(context);
					alert($("#content").val());
				}
				document.forms[0].action="/admin/kpoint/kpointEdit";
				document.forms[0].submit();
			}
		}
		
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span id="sp1">添加课程节点</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="#" method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<label class="layui-form-label ">节点名称:</label>
						<div class="layui-input-block">
						<input type="hidden"  name="id"  value="${p.id }" />
						    <input type="hidden"  value="${p.kpointType }" id="kpointType"/>
						    <input type="hidden"  value="${p.fileType }" id="fileType"/>
							<input type="text"  id="name" name="name"  value="${p.name }" autocomplete="off"
								class="layui-input ">
						</div>
					</div>
					
					<c:if test="${p.kpointType==0 }">
						<div class="layui-form-item">
							<label class="layui-form-label">排序:</label>
							<div class="layui-input-block">
								<input type="text"  name="sort" value="${p.sort }" autocomplete="off" class="layui-input ">
							</div>
						</div>
					</c:if>
					<c:if test="${p.kpointType==1 }">
						<div class="layui-form-item">
							<label class="layui-form-label ">文件上传:</label>
							<div class="layui-input-block">
							     <input type="hidden"  value="${p.videoUrl }" name="videoUrl"/>
								<input type="file" id="videoUrl1" name="videoUrl1" autocomplete="off" class="layui-input ">
							</div>
						</div>
						<c:if test="${p.fileType.equals('TXT') }">
							<div class="layui-form-item">
								<label class="layui-form-label ">文本内容:</label>
								<div class="layui-input-block">
									<script type="text/plain" id="myEditor" style="width: 650px; height: 240px;">
                                           <p>${p.content}</p>
                                    </script>
									<textarea rows="5" id="content" name="content" cols="78" class="layui-textarea"></textarea>
								</div>
							</div>
						</c:if>
						<c:if test="${p.fileType.equals('VIDEO') }">
						
							<div class="layui-form-item">
								<label class="layui-form-label">排序:</label>
								<div class="layui-input-block">
									<input type="text" name="sort" value="${p.sort }"
										autocomplete="off" class="layui-input ">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">播放时间:</label>
								<div class="layui-input-block">
									<input type="text" name="playTime" value="${p.playTime }" autocomplete="off" class="layui-input ">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">是否免费:</label>
								<div class="layui-input-block">
									<input type="radio" name="isFree" value="1"  title="是">
                                    <input type="radio" name="isFree" value="2" title="否" >
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label ">视频讲师:</label>
								<div class="layui-input-block">
									<select class="layui-input" width="150"  name="tid" id="tid">
										<option value="-1" selected="selected">请选择</option>
									</select>
								</div>
							</div>
							
						</c:if>
					</c:if>
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" onclick="toEditKpoint()" type="button">确定</button>
							<button type="reset"  onclick="cleanText()" class="layui-btn layui-btn-primary">取消</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="/common/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
	//实例化编辑器
    var um = UM.getEditor('myEditor');
</script>
</body>
</html>