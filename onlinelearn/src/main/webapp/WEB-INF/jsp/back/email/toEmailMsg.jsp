<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html lang="en"> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>发送邮件</title> -->
<!-- <meta name="renderer" content="webkit"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
<!-- <meta name="viewport" -->
<!-- 	content="width=device-width, initial-scale=1, maximum-scale=1"> -->
<!-- <meta name="apple-mobile-web-app-status-bar-style" content="black"> -->
<!-- <meta name="apple-mobile-web-app-capable" content="yes"> -->
<!-- <meta name="format-detection" content="telephone=no"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="/common/layui/css/layui.css" media="all"> -->
<!-- <link rel="stylesheet" type="text/css" -->
<!-- 	href="/common/bootstrap/css/bootstrap.css" media="all"> -->
<!-- <link rel="stylesheet" type="text/css" href="/common/global.css" -->
<!-- 	media="all"> -->
<!-- <link rel="stylesheet" type="text/css" href="/css/personal.css" -->
<!-- 	media="all"> -->
<!-- <!-- <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script> --> 
<!-- <!-- <script type="text/javascript" src="/js/jquery.tips.js"></script> --> 

<!-- <link href="/js/utf8-jsp/themes/default/css/umeditor.css" -->
<!-- 	type="text/css" rel="stylesheet"> -->
<!-- <script type="text/javascript" src="/js/jquery.min.js"></script> -->
<!-- <script language="javascript" type="text/javascript" -->
<!-- 	src="/js/My97DatePicker/WdatePicker.js"></script> -->
<!-- <script type="text/javascript" charset="utf-8" -->
<!-- 	src="/js/utf8-jsp/umeditor.config.js"></script> -->
<!-- <script type="text/javascript" charset="utf-8" -->
<!-- 	src="/js/utf8-jsp/umeditor.min.js"></script> -->
<!-- <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script> -->

<!-- <script type="text/javascript"> -->
<!-- // //   var e=^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$; -->
<!-- // //   var em= ^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$; -->
<!-- // //   var reg1 = /^0?1[3|4|5|8][0-9]\d{8}$/; -->
  
<!-- //       function cz() { -->
    	  
<!-- //     	  $("#name").val(""); -->
<!-- //     	  $("#biaoti").val(""); -->
<!-- //     	  $("#neirong").val(""); -->
		
<!-- // 	} -->

<!-- // //        function list() { -->
<!-- // //     	   alert("a"); -->
<!-- // //     	  var s = $("#name").val(); -->
<!-- // //     	  alert(s); -->
<!-- // //            bool x = s.Contains("@");//判断输入字符里面是否有@ -->
<!-- // //            int a = s.IndexOf("@");//定义第一次出现@索引号为a -->
<!-- // //            int b = s.LastIndexOf("@");//定义最后一次出现@索引号为b -->
<!-- // //            string ss = s.Substring(a);//截取@开头的字符串 -->
<!-- // //            bool y = ss.Contains(".");//判断ss是否含有. -->
<!-- // //            int c = ss.IndexOf(".");//出现.第一次的索引号 -->
<!-- // //            bool z = ss.EndsWith(".");//判断结尾是不是. -->
<!-- // //            if (x == true && a == b && y == true && c > 1 && z == false) -->
<!-- // //            { -->
<!-- // // //                Console.WriteLine("您输入的邮箱格式正确！"); -->
<!-- // //                 alert("邮件发送成功！"); -->
<!-- // //                document.forms[0].action="/admin/email/sendemail"; -->
<!-- // //                document.forms[0].submit(); -->
               
<!-- // //            } -->
<!-- // //            else -->
<!-- // //            { -->
<!-- // //                Console.WriteLine("您输入的邮箱格式错误！"); -->
<!-- // //            } -->
		
<!-- // // 	} -->
       
      

  
<!-- </script> -->
<!-- <script type="text/javascript"> -->
<!-- // $(function(){ -->
<!-- // 	$("#div1").hide(); -->
<!-- // 	$("#tx").hide(); -->
<!-- // 	$("#tid").change(function(){ -->
<!-- // 		var type=$(this).val(); -->
<!-- // 		alert(type); -->
<!-- // 		if(type=='1'){ -->
<!-- // 			$("#div1").hide(); -->
<!-- // 		}else{ -->
<!-- // 			$("#div1").show(); -->
<!-- // 		} -->
<!-- // 	}); -->
<!-- // 	$("#btn").click(function(){ -->
<!-- // 		alert("12"); -->
<!-- // 		var content= UM.getEditor('myEditor').getContentTxt(); -->
<!-- // 		$("#tx").val(content); -->
<!-- // 		$("#form1").submit(); -->
<!-- // 	}); -->
<!-- // }); -->
<!-- </script> -->

<!-- </head> -->
<!-- <body> -->
<!-- 	<section class="layui-larry-box"> -->
<!-- 		<div class="larry-personal"> -->
<!-- 			<header class="larry-personal-tit"> -->
<!-- 				<span>邮箱发送</span> -->
<!-- 			</header> -->
<!-- 			<div class="larry-personal-body clearfix"> -->
<!-- 				<form action="/admin/email/saveEmail" method="post" id="form1"> -->
<!-- 					<div class="layui-form-item"> -->
<!-- 						<label class="layui-form-label">添加联系人</label> -->
<!-- 						<div class="layui-input-block"> -->
<!-- 							<input type="text" placeholder="邮箱格式为：*******@qq.com" name="name" -->
<!-- 								class="layui-input " autocomplete="off" style="width: 250px;"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="layui-form-item"> -->
<!-- 						<label class="layui-form-label">邮箱标题</label> -->
<!-- 						<div class="layui-input-block"> -->

<!-- 							<input type="text" name="biaoti" class="layui-input " -->
<!-- 								style="width: 250px;"> -->
<!-- 						</div> -->
<!-- 					</div> -->
                            
                    
<!--                     <script type="text/plain" id="myEditor" style="width:600px;height:240px;"> -->
<!--                             <p>这里我可以写一些输入提示</p> -->
<!--                      </script> -->
                                 
                                 

<!-- 					<div class="layui-form-item" id="tx"> -->
<!-- 						<label class="layui-form-label">发送内容</label> -->
<!-- 						<div class="layui-input-block"> -->
<!-- 							<textarea  cols="100" rows="10" name="neirong"></textarea> -->
<!-- 						</div> -->
<!-- 					</div> -->



<!-- 					<div class="layui-form-item"> -->
<!-- 						<label class="layui-form-label">邮箱类型</label> -->
<!-- 						<div class="layui-input-block"> -->
<!-- 							<select id="type" name="type" id="tid" class="form-control"> -->
<!-- 								<option value="1">普通</option> -->
<!-- 								<option value="2">定时</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 			</div> -->

<!-- 			<div id="div1"> -->
<!-- 				时间:<input type="text" name="time" -->
<!-- 					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> -->
<!-- 			</div> -->

<!-- 			<div class="layui-form-item"> -->
<!-- 				<div class="layui-input-block"> -->

<!-- 					<button type="submit" class="layui-btn" id="btn">发送</button> -->
<!-- 					<button type="reset" class="layui-btn" onclick="cz()">重置</button> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 		</div> -->
<!-- 		</form> -->
<!-- 	</section> -->

<!-- </body> -->
<!--  <!-- 实例化编辑器 --> 
<!--     <script type="text/javascript"> -->
<!-- //     //实例化编辑器 -->
<!-- //     var um = UM.getEditor('myEditor'); -->
   
<!--     </script> -->
<!-- </html> -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>邮件发送</title>

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
 <script type="text/javascript" src="../../../js/jquery-3.2.0.min.js"></script> 
 <script type="text/javascript" src="/js/jquery.tips.js"></script> 

<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript"
	src="/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
<script>

$(function(){
	$("#div1").hide();
	$("#tx").hide();
	$("#tid").change(function(){
		var type=$(this).val();
		if(type=='1'){
			$("#div1").hide();
		}else{
			$("#div1").show();
		}
	});
	$("#btn").click(function(){
		var content= UM.getEditor('myEditor').getContentTxt();
		$("#tx").val(content);
		$("#form1").submit();
	});
});

function cz() { 

    	  $("#email").val(""); 
    	  $("#title").val(""); 
    	  $("#myEditor").val("");
    	  $("#content").val(""); 
    	  $("#time").val(""); 
		
	} 
</script>
<style type="text/css">
body {font-family:Microsoft YaHei;
      font-size:18px;
}
</style>
</head>

<body>
<form method="post" action="/admin/email/saveEmail" id="form1"> 

 收件人邮箱: <input type="text" style="width: 500px" placeholder="邮箱格式为：*******@qq.com" name="email" id="email"/><br/>
 <dir></dir>
邮&nbsp;件&nbsp;表&nbsp;题: <input type="text" style="width: 500px" name="title" id="title"/>
<dir></dir>
<script type="text/plain" id="myEditor" style="width:600px;height:240px;">
    <p></p>
</script>
<textarea id="tx" cols="50" rows="10" name="content" style="width: 600px" id="content"></textarea><br>
发送方式:<select name="type" style="width: 520px"  id="tid">
<option value="1">普通发送</option>
<option value="2">定时发送</option>
</select>
<div></div>
<div id="div1">
时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间:<input type="text" name="time" id="time" style="width: 520px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
</div><br>
<input type="button" style="margin-left:240px;" class="layui-btn col-sm-6" id="btn" value="发送"/>
<!--                      <button type="submit" class="layui-btn" id="btn">发送</button> --> 
					<button type="reset" style="margin-right:220px;" class="layui-btn col-sm-9" onclick="cz()">重置</button>
</form>
</body>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
    //实例化编辑器
    var um = UM.getEditor('myEditor');
    </script>
</html>