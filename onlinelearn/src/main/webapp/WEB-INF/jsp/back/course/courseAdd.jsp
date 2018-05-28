<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>课程添加</title>
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
   .layui-form-item{
      width:68%
   }
</style>
<script type="text/javascript">
    var tids = new Array();
    var count =0;
	function renderForm(){
		 layui.use('form', function(){
		 var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
		 form.render();
		 });
		 }
	   $(document).ready(function(){
		   $("#context").css("display","none");
		   $.post("/admin/subject/getSubjectList/2",
				   function(msg){
			           
			           for(i=0;i<msg.length;i++){
				            $("#parent_id").append("<option value='"+msg[i].subjectId+"'>"+msg[i].subjectName+"</option>");
			   }
			   renderForm();
		   });
		   
		   layui.use('form', function () {
			    var form = layui.form;
			    
			    form.on('select(subId)', function(data){
			        if(data.value!=-1){
			        	$.post("/admin/subject/getChildList/"+data.value,function(msg){
			        		$(".op").remove();
				        	for(i=0;i<msg.length;i++){
				        		$("#subject_id").append("<option class='op' value='"+msg[i].subjectId+"'>"+msg[i].subjectName+"</option>");
				        	}
			        		 form.render();
				        });
			        	$.post("/admin/teacher/getTeacherBySubjectId/"+data.value,function(msg){
			        		$(".op1").remove();
				        	for(i=0;i<msg.length;i++){
				        		$("#id").append("<option class='op1' value='"+msg[i].id+"'>"+msg[i].name+"</option>");
				        	}
			        		 form.render();
				        });
			        }
			     });  
			    
			    
			    
			    form.on('select(loseTy)',function(data){
			    	if(data.value==0){
			    		$("#day1").css("display","none");
			    		$("#time1").css("display","block");
			    	}else if(data.value==1){
			    		$("#day1").css("display","block");
			    		$("#time1").css("display","none");
			    	}
			    	 form.render();
			    });
			    
			    form.on('select(teaId)',function(data){
			    	if(data.value!=-1){
			    		var a = data.elem[data.elem.selectedIndex].text;
			    		if(count>0){
			    			//判断集合中是否已经包含教师的id,如已包含再次选中时就删掉
			    			for(var i=0;i<tids.length;i++){
			    				if(tids[i]==data.value){
			    					tids.splice(i,1);
			    					count--;
			    					$("#tea1 li").each(function(){
			    						//判断ul li 的文本中是否包含  要删除的文本
			    						if($(this).text().indexOf(a)>=0){
			    							$(this).remove();
			    						}
			    					});
			    					return;
			    				}
			    			}
			    		}
    			    	$("#tea1").append("<li class='tli'>"+a+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<a href='#' onclick='removeTname(this,"+data.value+")' >删除</a></li>");
    			    	tids[count] = data.value;
    			    	count++;
    			    	$("#id").val("-1");
			    	}
			    	 form.render();
			    });
			    
			})
	   });
	   
	   function removeTname(a,b){
		   $(a).parent('li').remove();
		   for(var i=0;i<tids.length;i++){
				if(tids[i]==b){
					tids.splice(i,1);
					count--;
				}
			}
	   }
	   
		$(function(){
			  layui.use('form', function () {
				    var form = layui.form;
				    form.on('select(subjId)', function(data){
				        if(data.value!=-1){
				        	$.post("/admin/teacher/getTeacherBySubjectId/"+data.value,function(msg){
				        		$(".op2").remove();
					        	for(i=0;i<msg.length;i++){
					        		$("#id").append("<option class='op2' value='"+msg[i].id+"'>"+msg[i].name+"</option>");
					        	}
				        		 form.render();
					        });
				        }
				     });  
			  });
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
		
		/* function toAddCourse(){
			var teaids = "";
			for(var i=0;i<tids.length;i++){
				teaids+=tids[i]+"-";
			}
			$("#teaids").val(teaids);
			var context= UM.getEditor('myEditor').getContentTxt();
			$("#context").val(context);
			document.forms[0].action="/admin/course/courseAdd";
			document.forms[0].submit();
		} */
		
	</script>
</head>
<body>
	<section class="layui-larry-box">
		<div class="larry-personal">
			<header class="larry-personal-tit">
				<span id="sp1">添加课程</span>
			</header>
			<!-- /header -->
			<div class="larry-personal-body clearfix">
				<form class="layui-form col-lg-6" action="/admin/course/courseAdd" method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<label class="layui-form-label ">课程名称:</label>
						<div class="layui-input-block">
							<input type="text"  id="course_name" name="course_name" autocomplete="off"
								class="layui-input "  lay-verify="course_name">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">专业分类:</label>
						<div class="layui-input-inline">
							<select class="layui-input"   width="150"  lay-filter="subId" name="parent_id" id="parent_id">
								<option value="-1" selected="selected">请选择</option>
							</select>
						</div>
						<div class="layui-input-inline">
							<select class="layui-input" width="150"   lay-filter="subjId" name="subject_id"
								id="subject_id">
								<option value="-1" selected="selected">请选择</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态:</label>
						<div class="layui-input-block">
							<select class="layui-input" width="150" name="is_avaliable" id="is_avaliable">
								<option value="1" selected="selected">上架</option>
								<option value="2">下架</option>
								<option value="3">删除</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">总课时:</label>
						<div class="layui-input-block">
							<input type="text"  id="lession_num" name="lession_num" autocomplete="off"
								class="layui-input " lay-verify="lession_num">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程原价格:</label>
						<div class="layui-input-block">
							<input type="text" id="source_price" name="source_price" autocomplete="off"
								class="layui-input " lay-verify="source_price">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">课程销售价格:</label>
						<div class="layui-input-block">
							<input type="text" id="current_price" name="current_price" autocomplete="off"
								class="layui-input "  lay-verify="current_price">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">有效期类型:</label>
						<div class="layui-input-block">
							<select class="layui-input" width="150" lay-filter="loseTy" name="loseType" id="loseType">
								<option value="0" >到期时间</option>
								<option value="1" selected="selected">按天数</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item" id="day1">
						<label class="layui-form-label">按天数:</label>
						<div class="layui-input-block">
							<input type="text"  id="lose_time" name="lose_time" autocomplete="off" class="layui-input "  lay-verify="lose_time">天
						</div>
					</div>
					<div class="layui-form-item" id="time1">
						<label class="layui-form-label">有效结束时间:</label>
						<div class="layui-input-block">
							<input type="date" id="end_time"  name="endTime" autocomplete="off" class="layui-input " lay-verify="endTime">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label " >添加教师:</label>
						<div id="ddiv" class="layui-input-block">
							<ul id="tea1"></ul>
						</div>
						<div class="layui-input-block">
						<input type="hidden" id="teaids"  name="teaids" autocomplete="off" class="layui-input " lay-verify="teaids">
							<select class="layui-input" width="150"  lay-filter="teaId" name="id" id="id">
								<option value="-1" selected="selected">请选择</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">课程简介:</label>
						<div class="layui-input-block">
							<input type="text" id="title" name="title" autocomplete="off" class="layui-input "  lay-verify="title">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">课程图片:</label>
						<div class="layui-input-block">
						    <img alt="" src="" id="blah" name="image_urls" style="height: 200px; width: 300px" />
							<input type="file" id="logo1" name="logo1" autocomplete="off" class="layui-input " >(请上传640*357(长*宽)像素的图片)
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label ">课程详情:</label>
						<div class="layui-input-block">
						    <script type="text/plain" id="myEditor" style="width:650px;height:240px;">
                                <p>请输入课程详情</p>
                            </script>
							<textarea rows="5" id="context" name="context" cols="80"  class="layui-textarea"></textarea>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn"  lay-submit="" lay-filter="demo1" >立即提交</button>
							<button type="reset"  onclick="cleanText()" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript" src="/common/larry/layui/layui.js"></script>
	<script type="text/javascript">
	
	//实例化编辑器
    var um = UM.getEditor('myEditor');
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
			  course_name: function(value){
		      if(value.length < 3){
		        return '课程名至少得3个字符啊';
		      }
		      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		          return '课程名不能有特殊字符';
		        }
		        if(/^\d+\d+\d$/.test(value)){
		          return '课程名不能全为数字';
		        }
		    }
		    ,loginPwd: [/^(?:[1-9]\d?|[1234]\d{2}|500)$/, '课时为1~500之间的数字']
		    ,source_price: [/^[0-9]+\.{0,1}[0-9]{0,2}$/, '请输入正确的价格']
		    ,current_price:function(value){
		    	var sprice = $('input[name=source_price]').val();
		    	if(value > sprice){
		    	return '售价不能大于原价!';
		    	}
		    	 if(!/^[0-9]+\.{0,1}[0-9]{0,2}$/.test(value)){
			          return '请输入正确的价格';
			        }
		    	}
		    ,lose_time:function(value){
		    	 if(/^[0-9]*[1-9][0-9]*$/.test(value)||value==''){
		    		
			        }else{
			        	 return '请输入正确的天数';
			        }
		    	}
		    ,title:function(value){
		    	 if(value.trim().length<10||value.trim().length>30){
			          return '课程简介在10~30个字符';
			        }
		    	}
		  });
		  
		  //监听提交
		  form.on('submit(demo1)', function(data){
			  var b = true;
			  var teaids = "";
				for(var i=0;i<tids.length;i++){
					teaids+=tids[i]+"-";
				}
				$("#teaids").val(teaids);
				var context= UM.getEditor('myEditor').getContentTxt();
				$("#context").val(context);
				if(context.trim().length<20){
					layer.alert("课程详情要在20字以上!");
					return false;
				}
			  if(data.field.parent_id==-1){
				  layer.alert("请选择专业!");
				  return false;
			  }
			  if(teaids==''){
				  layer.alert("请选择老师!");
				  return false;
			  }
			  /* layer.alert(JSON.stringify(data.field), {
			      title: '最终的提交信息'
			    }); */
			  return true;
		  });
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

	$("#logo1").change(function() {
		readURL(this);
	});
	
</script>
</body>
</html>