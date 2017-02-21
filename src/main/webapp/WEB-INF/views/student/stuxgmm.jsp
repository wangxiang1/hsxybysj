<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/bootstrap-dist/js/bootstrap.min.js"></script>
<title>修改密码</title>
<style type="text/css">
.mytable {margin-top: 30px;}
.mytable td {padding: 10px;}
.mytable .font{width: 80px; text-align: center;  }
.mytable .jg{width: 130px; text-align: left; padding-left: 2px; color: red;}
.mytable .input{width: 105px; padding: 0px;}
.mytable .input input{width: 200px; border: solid 1px gray; height: 26px; border-radius: 4px;}
</style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    <li>首页</li>
	    <li>修改密码</li>
	    </ul>
	 </div>
	 <div class="rightinfo">
	    <div><span style="font-size: 20px; position:relative; left: 45%; margin: 15px;">修改密码</span></div>
	    <table class="mytable" style="position:relative;left: 34%;">
	    	<tr>
	    		<td class="font">密码:</td>
	    		<td class="input"><input type="password" id="mima" onblur="checkMima()"></td>
	    		<td class="jg"><span id="mimajg"></span></td>
	    	</tr>
	    	<tr>
	    		<td class="font">新密码:</td>
	    		<td class="input"><input type="password" id="newmima1" onblur="checkMima1()"></td>
	    		<td class="jg"><span id="mima1jg"></span></td>
	    	</tr>
	    	<tr>
	    		<td class="font">确认密码:</td>
	    		<td class="input"><input type="password" id="newmima2" onblur="checkMima2()"></td>
	    		<td class="jg"><span id="mima2jg"></span></td>
	    	</tr>
	    	<tr>
	    		<td colspan='2' style="text-align: center;">
	    		   <button class="btn-primary btn-sm" onclick="quren()">确认</button>
                </td>
	    	</tr>
	    </table>
    </div>
    <script type="text/javascript">
       var m1 = false;
       var m2 = false;
       var m3 = false;
       var outpwd = "${user.yhid }";
        function quren(){
            if(m1 && m2 && m3){
            	qrAjax();
            }else{
            	alert("输入有误");
            }
        };
        function qrAjax(){
        	var pwd = $("#newmima1").val();
        	$.ajax({
     	       type:"POST",
     	       url:"<%=path%>/hsxy/sdjf/xiugaimima",
     	       data:{
     	    	     "yhid":"${user.yhid }",
     	    	      "pwd":pwd
     			     },
     	       success:function(data){
     	    	   if (data == 1) {
     	    		   alert("改密成功");
     				   location = "<%=path %>/hsxy/sdjf/gostuxgmm?stuid=${user.yhid }";
     			   }else{
     				   alert("改密失败，请重试");
     			   }
     	       },
                error: function() {
                    //请求出错
                    alert("请求出错");
                }
     		   });
        };
        function qrOutAjax(){
        	$.ajax({
     	       type:"POST",
     	       url:"<%=path%>/hsxy/sdjf/mimaqr",
     	       data:{
     	    	     "yhid":"${user.yhid }",
     			     },
     	       success:function(data){
     	    	  outpwd = data;
     	       },
                error: function() {
                    //请求出错
                    alert("请求出错");
                }
     		   });
        };
        function checkMima(){
        	qrOutAjax();
        	var mima = $("#mima").val();
        	if (mima == "") {
				$("#mimajg").html("请输入密码!");
				$("#mima").focus();
				m1 = false;
			}else if(mima != outpwd){
				$("#mimajg").html("旧密码输入有误！");
				$("#mima").focus();
				m1 = false;
			}else{
				$("#mimajg").html("");
				m1 =  true;
			}
        };
        
        function checkMima1(){
        	var mima1 = $("#newmima1").val();
        	if (mima1 == "") {
				$("#mima1jg").html("请输入新密码!");
				$("#mima1").focus();
				m2 =  false;
			}else{
				$("#mima1jg").html("");
				m2 =  true;
			}
        };
        
        function checkMima2(){
        	var mima1 = $("#newmima1").val();
        	var mima2 = $("#newmima2").val();
        	if (mima2 == "") {
				$("#mima2jg").html("请确认新密码!");
				$("#mima2").focus();
				m3 =  false;
			}else if(mima1 != mima2){
				$("#mima2jg").html("两次密码输入不同!");
				$("#mima2").focus();
				m3 =  false;
			}else{
				$("#mima2jg").html("");
				m3 =  true;
			}
        };
        
    </script>
</body>
</html>