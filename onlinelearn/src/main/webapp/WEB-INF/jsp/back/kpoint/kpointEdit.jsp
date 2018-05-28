<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>节点编辑</title>
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
<script src="/static/common/uploadify/ccswfobject.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/common/uploadify/swfobject.js" type="text/javascript" charset="utf-8"></script>
<script src="/static/common/uploadify/jquery.uploadify.v2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
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
   .layui-form{
      width:100%;
      height:100%
   }
    .layui-input-block{
   width:73%
   }
</style>
<script type="text/javascript">
function renderForm(){
	 layui.use('form', function(){
	 var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
	 form.render();
	 });
	 }
	   $(function(){
		   $("#content").css("display","none");
		 
			   var form = layui.form;
			   //各种基于事件的操作
			   $('input:radio[name=isFree]').each(function(i,item){
				   var isFree = "${p.isFree}";
				   if(item.value==isFree){
					   $(item).prop('checked',true); 
				   }
				   renderForm();
			   });
			   
			    $.post("/admin/teacher/listTeacher",function(msg){
	        		$(".op").remove();
		        	for(i=0;i<msg.length;i++){
		        		$("#tid").append("<option class='op' value='"+msg[i].id+"'>"+msg[i].name+"</option>");
		        	}
		        	$("#tid").val("${p.eduTeacher.id}");
		        	renderForm();
		        });
			   
			
		   
	   });
		
		
		function toEditKpoint(){
			var kpointType = $("#kpointType").val();
			var fileType = $("#fileType").val();
			if(kpointType==0){
				document.forms[0].action="/admin/kpoint/kpointCatalogEdit";
				document.forms[0].submit();
			}
			if(kpointType==1&&fileType==('TXT')){
				var fileType = $("#fileType").val();
				if(fileType==("TXT") ){
				    var context= UM.getEditor('myEditor').getContentTxt();
					$("#content").val(context);
				}
				document.forms[0].action="/admin/kpoint/kpointEdit";
				document.forms[0].submit();
			}
			if(kpointType==1&&fileType==('VIDEO')){
				document.forms[0].action="/admin/kpoint/kpointVideoEdit";
				document.forms[0].submit();
			}
		}
		
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span id="sp1">修改课程节点</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="#" method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<label class="layui-form-label ">节点名称:</label>
						<div class="layui-input-block">
						<input type="hidden"  name="id"  value="${p.id }" />
						    <input type="hidden"  value="${p.kpointType }"  name="kpointType" id="kpointType" lay-verify="kpointType"/>
						    <input type="hidden"  value="${p.fileType }" name="fileType" id="fileType" lay-verify="fileType"/>
							<input type="text"  id="name" name="name"  value="${p.name }" autocomplete="off"
								class="layui-input "  lay-verify="name" />
						</div>
					</div>
					
					<c:if test="${p.kpointType==0 }">
						<div class="layui-form-item">
							<label class="layui-form-label">排序:</label>
							<div class="layui-input-block">
								<input type="text"  name="sort" value="${p.sort }" autocomplete="off" class="layui-input " >
							</div>
						</div>
					</c:if>
					<c:if test="${p.kpointType==1 }">
						<c:if test="${p.fileType.equals('TXT') }">
							<div class="layui-form-item">
								<label class="layui-form-label ">文件上传:</label>
								<div class="layui-input-block">
								    <input type="hidden" value="${p.videoUrl }" name="videoUrl3" />
									<input type="file" id="videoUrl1" name="videoUrl1"
										autocomplete="off" class="layui-input ">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label ">文本内容:</label>
								<div class="layui-input-block">
									<script type="text/plain" id="myEditor" style="width: 650px; ">
                                           <p>${p.content}</p>
                                    </script>
									<textarea rows="5" id="content" name="content" cols="78" class="layui-textarea"></textarea>
								</div>
							</div>
						</c:if>
						<c:if test="${p.fileType.equals('VIDEO') }">
						    <div class="layui-form-item">
								<label class="layui-form-label ">视频上传:</label>
								<div class="layui-input-block">
									<input type="file" id="fileupload" class="vam" id="filename" name="mp4" style="display: block !important;" />
									<div id="fileQueue" class="mt10"></div>
									<input type="hidden" name="videourl2" id="videourl2" value="" />
								</div>
							</div>
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
							<button class="layui-btn"  lay-submit="" lay-filter="demo1" >确定</button>
							<a  href="/admin/kpoint/toBlank"   class="layui-btn layui-btn-primary">取消</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="/common/larry/layui/layui.js"></script>
	<script type="text/javascript">
	
	
	//表单验证
	layui.use(['form', 'layedit', 'laydate'], function(){
		  var form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  
		  //创建一个编辑器
		  var editIndex = layedit.build('LAY_demo_editor');
		 
		  //自定义验证规则
		  form.verify({
			  name: function(value){
		      if(value.length < 3){
		        return '课程章节名至少得3个字符啊';
		      }
		      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		          return '课程章节名不能有特殊字符';
		        }
		    }
		  });
		  
		  //监听提交
		  form.on('submit(demo1)', function(data){
			  var b = true;
		      if(data.field.kpointType==0){
		    	  if(!/^([1-9]\d*|[0]{1,1})$/.test(data.field.sort)){
		    		  layer.alert('排序只能是自然数!');
		    		  return false;
		    	  }
		    	  document.forms[0].action="/admin/kpoint/kpointCatalogEdit";
				  document.forms[0].submit();
		      }
		      if(data.field.kpointType==1){
		    	  if(data.field.fileType==('TXT') ){
					    var context= UM.getEditor('myEditor').getContentTxt();
						$("#content").val(context);
						if(context.trim().length<10){
							layer.alert('章节信息不能少于10个字');
							return false;
						}
						document.forms[0].action="/admin/kpoint/kpointEdit";
						document.forms[0].submit();
					}
		    	  if(data.field.fileType==('VIDEO')){
		    		  if(!/^([1-9]\d*|[0]{1,1})$/.test(data.field.sort)){
			    		  layer.alert('排序只能是自然数!');
			    		  return false;
			    	  }
		    		  if(!/^([1-9]\d*|[0]{1,1})$/.test(data.field.playTime)){
			    		  layer.alert('播放时间只能是自然数!');
			    		  return false;
			    	  }
		    		  if(data.field.tid==-1){
		    			  layer.alert('请选择老师!');
		    			  return false;
		    		  }
						document.forms[0].action="/admin/kpoint/kpointVideoEdit";
						document.forms[0].submit();
					}
		      }
			  /*  layer.alert(JSON.stringify(data.field), {
			      title: '最终的提交信息'
			    }); 
			  return false; */
		  });
		});
	
	//实例化编辑器
    var um = UM.getEditor('myEditor');
	//视屏上传
    //上传控件加载
function uploadPicLoad(fileupload,showId,fileQueue){
	$("#fileuploadUploader").remove();
	$("#"+fileupload).uploadify({
		'uploader' : '/static/common/uploadify/uploadify.swf?ver='+Math.random(), //上传控件的主体文件，flash控件  默认值='uploadify.swf'
		'script'  :'/admin/kpoint/storeVideo',
		'scriptData':{"fileType":"mp4","param":"upload/video"},
		'queueID' : fileQueue, //文件队列ID
		'fileDataName' : 'uploadfile', //您的文件在上传服务器脚本阵列的名称
		'auto' : true, //选定文件后是否自动上传
		'multi' :false, //是否允许同时上传多文件
		'hideButton' : false,//上传按钮的隐藏
		'buttonText' : '选择文件',//默认按钮的名字
		'buttonImg' : '/static/common/uploadify/liulan.png',//使用图片按钮，设定图片的路径即可
		'width' : 105,
		'simUploadLimit' : 3,//多文件上传时，同时上传文件数目限制
		'sizeLimit' : 5120000000,//控制上传文件的大小
		'queueSizeLimit' : 3,//限制在一次队列中的次数（可选定几个文件）
		'fileDesc' : '支持格式:mp4.',//出现在上传对话框中的文件类型描述
		'fileExt' : '*.MP4;*.mp4;*.flv;',//支持的格式，启用本项时需同时声明fileDesc
		'cancelImg' : '/static/common/uploadify/cancel.png',
		onSelect : function(event, queueID,fileObj) {
			fileuploadIndex = 1;
			$("#"+fileQueue).html("");
			if (fileObj.size > 5120000000) {
				alert('文件太大最大限制5120000kb');
				return false;
			}
		},
		onComplete : function(event,queueID, fileObj, response,data) {
			alert("上传成功!");
			$("#videourl2").val(response);
			$("#"+showId).val(response);
		},
		onError : function(event, queueID, fileObj,errorObj) {
			$("#"+fileQueue).html("<br/><font color='red'>"+ fileObj.name + "上传失败</font>");
		}
	});
	}

function initUpdateKpoint(){
	uploadPicLoad('fileupload','videourl2','fileQueue');
}
$(function(){
	initUpdateKpoint();
	});
</script>
</body>
</html>