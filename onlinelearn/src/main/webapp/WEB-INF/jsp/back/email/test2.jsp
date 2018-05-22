 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/js/layui.js"></script>
<script src="/js/layui.all.js"></script>
<link rel="stylesheet" href="/css/layui.css">

<title>Insert title here</title>
<script>  
layui.use(['form', 'layedit', 'laydate'], function(){  
  var form = layui.form()  
  ,layer = layui.layer  
  ,layedit = layui.layedit  
  ,laydate = layui.laydate;  
   
  //自定义验证规则  
  form.verify({  
        title: function(value){  
          if(value.length < 5){  
            return '标题至少得5个字符啊';  
          }  
        }, fname: function(value){  
          if(value.length < 4){  
            return '请输入至少4位的用户名';  
          }  
        }, contact: function(value){  
          if(value.length < 4){  
            return '内容请输入至少4个字符';  
          }  
        }  
        ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']  
        ,email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']  
  });  
    
  //创建一个编辑器  
  layedit.build('LAY_demo_editor');  
    
  //监听提交  
  form.on('submit(demo1)', function(data){  
    layer.alert(JSON.stringify(data.field), {  
      title: '最终的提交信息'  
    })  
    return false;  
  });  
    
   
});  
</script>  
</head>
<body>

		
                       <form class="layui-form" action="/admin/email/sendEmailList">  
                          <div class="layui-form-item">  
                            <label class="layui-form-label">反馈主题</label>  
                            <div class="layui-input-block">  
                              <input name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off" lay-verify="title">  
                            </div>  
                          </div>  
                          <div class="layui-form-item">  
                            <label class="layui-form-label">姓名</label>  
                            <div class="layui-input-block">  
                              <input name="fname" class="layui-input" type="text" placeholder="请输入姓名" autocomplete="off" lay-verify="fname">  
                            </div>  
                          </div>  
                          <div class="layui-form-item">  
                            <label class="layui-form-label">手机</label>  
                            <div class="layui-input-block">  
                              <input name="phone" class="layui-input" type="tel" autocomplete="off" placeholder="请输入手机" lay-verify="phone">  
                            </div>  
                          </div>  
                          <div class="layui-form-item">  
                            <label class="layui-form-label">邮箱</label>  
                            <div class="layui-input-block">  
                              <input name="email" class="layui-input" type="text" autocomplete="off" placeholder="请输入邮箱" lay-verify="email">  
                            </div>  
                          </div>  
                          <div class="layui-form-item">  
                            <label class="layui-form-label">单选框</label>  
                            <div class="layui-input-block">  
                              <input name="sex" title="男" type="radio" checked="" value="男">  
                              <input name="sex" title="女" type="radio" value="女">  
                              <input name="sex" title="保密" type="radio" value="密">  
                            </div>  
                          </div>  
                          <!--<div class="layui-form-item layui-form-text">  
                            <label class="layui-form-label">普通文本域</label>  
                            <div class="layui-input-block">  
                              <textarea class="layui-textarea" placeholder="请输入内容">请输入内容</textarea>  
                            </div>  
                          </div> 
                          <div class="layui-form-item layui-form-text">  
                            <label class="layui-form-label">内容</label>  
                            <div class="layui-input-block">  
                              <textarea class="layui-textarea layui-hide"  name="contact" id="LAY_demo_editor" lay-verify="contact"></textarea>  
                            </div>  
                          </div>  
                          <div class="layui-form-item">  
                            <div class="layui-input-block">  
                              <button class="layui-btn" lay-filter="demo2" lay-submit="">跳转式提交</button>  
                              <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>  
                              <button class="layui-btn layui-btn-primary" type="reset">重置</button>  
                            </div>  
                          </div>  
                        </form>  
		


</body>
</html> -->













<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>www.jb51.net layui 表单验证</title>

<!-- <script src="/js/layui.js"></script> -->
<!-- <script src="/js/layui.all.js"></script>  -->
<!-- <link rel="stylesheet" href="/css/layui.css">  -->

<script src="/layui/layui.js"></script>
<script src="/layui/lay/dest/layui.all.js"></script> 
<link rel="stylesheet" href="/layui/css/layui.css"> 
</head>
<body>
<form class="layui-form" action="">
 <div class="layui-form-item">
 <label class="layui-form-label">标题</label>
 <div class="layui-input-block">
  <input name="title" class="layui-input" type="text" placeholder="请输入标题" autocomplete="off" lay-verify="title">
 </div>
 </div>
 <div class="layui-form-item">
 <label class="layui-form-label">姓名</label>
 <div class="layui-input-block">
  <input name="fname" class="layui-input" type="text" placeholder="请输入姓名" autocomplete="off" lay-verify="fname">
 </div>
 </div>
 <div class="layui-form-item">
 <label class="layui-form-label">手机</label>
 <div class="layui-input-block">
  <input name="phone" class="layui-input" type="tel" autocomplete="off" placeholder="请输入手机" lay-verify="phone">
 </div>
 </div>
 <div class="layui-form-item">
 <label class="layui-form-label">邮箱</label>
 <div class="layui-input-block">
  <input name="email" class="layui-input" type="text" autocomplete="off" placeholder="请输入邮箱" lay-verify="email">
 </div>
 </div>
 <div class="layui-form-item">
 <label class="layui-form-label">单选框</label>
 <div class="layui-input-block">
  <input name="sex" title="男" type="radio" checked="" value="男">
  <input name="sex" title="女" type="radio" value="女">
  <input name="sex" title="保密" type="radio" value="密">
 </div>
 </div>
 <!--<div class="layui-form-item layui-form-text">
 <label class="layui-form-label">普通文本域</label>
 <div class="layui-input-block">
  <textarea class="layui-textarea" placeholder="请输入内容">请输入内容</textarea>
 </div>
 </div>-->
 <div class="layui-form-item layui-form-text">
 <label class="layui-form-label">内容</label>
 <div class="layui-input-block">
  <textarea class="layui-textarea layui-hide" name="contact" id="LAY_demo_editor" lay-verify="contact"></textarea>
 </div>
 </div>
 <div class="layui-form-item">
 <div class="layui-input-block">
  <button class="layui-btn" lay-filter="demo2" lay-submit="">跳转式提交</button>
  <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
  <button class="layui-btn layui-btn-primary" type="reset">重置</button>
 </div>
 </div>
</form>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
 var form = layui.form
 ,layer = layui.layer
 ,layedit = layui.layedit
 ,laydate = layui.laydate;
 //自定义验证规则
 form.verify({
    title: function(value){
     if(value.length < 5){
      return '标题至少得5个字符';
     }
    }
 , fname: function(value){
     if(value.length < 1){
      return  '请输入用户名';
     }
    }, contact: function(value){
     if(value.length < 4){
      return '内容请输入至少4个字符';
     }
    }
    ,phone: [/^1[3|4|5|7|8]\d{9}$/, '手机必须11位，只能是数字！']
    ,email: [/^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/, '邮箱格式不对']
 });
 //创建一个编辑器
 layedit.build('LAY_demo_editor');
 //监听提交
 form.on('submit(demo1)', function(data){
  layer.alert(JSON.stringify(data.field), {
   title: '最终的提交信息'
  });
  return false;
 });
});
</script>
</body>
</html>




