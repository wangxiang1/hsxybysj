<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>衡水学院水电缴费管理系统-登录</title>
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })   
});  
</script> 
</head>
<body style="background-color:#1c77ac; background-image:url(<%=path %>/js/model/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


    <div class="logintop">    
	    <span>欢迎登录水电缴费管理平台</span>    
	    <ul>
		    <li><a href="#">回首页</a></li>
		    <li><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
	    </ul>    
    </div>
    <div class="loginbody">
    	<div style="height:75px; margin-top:75px; text-align: center;">
    	   <img alt="logo" src="<%=path %>/js/model/images/hsxylogo.png" style="width: 80px;height: 80px;margin-bottom: -20px; margin-left: 40px;">
    	   <font style="font-size: 38px; color: #F0F0F0;">&nbsp;&nbsp;水电缴费管理系统</font>
    	 </div> 
	    <div class="loginbox">
		    <ul>
		    	<li><input id="dlzh"  type="text" class="loginuser" placeholder="学号" onclick=""/></li>
		    	<li><input id="pwd" type="password" class="loginpwd" placeholder="密码" onclick=""/></li>
		    	<li><input id="loginid" type="button" class="loginbtn" value="登录"  onclick="loginXt()"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
		    </ul>
	    </div>
    </div>
    <div class="loginbm">版权所有  2017  uimaker.com 仅供学习交流，勿用于任何商业用途</div>
    
<script type="text/javascript">

function loginXt(){
	var dlzh = $("#dlzh").val();
	var pwd = $("#pwd").val();
	if (checkDlzh(dlzh) && checkPwd(pwd)) {
		goLogin(dlzh,pwd);
	}
}

function checkDlzh(dlzh){
	if(dlzh == null || dlzh == ""){
		alert("不能为空");
		return false;
	}
	return true;
}

function checkPwd(pwd){
	if(pwd == null || pwd == ""){
		alert("不能为空");
		return false;
	}
	return true;
}

function goLogin(dlzh,pwd){
	 $.ajax({
	       type:"POST",
	       url:"<%=path%>/hsxy/sdjf/login",
	       data:{
	    	     "dlzh":dlzh,
	    	     "pwd":pwd
			     },
	       success:function(data){
	    	   if (data.sfbz == 1) {//学生 
				   location = "<%=path %>/hsxy/sdjf/gostu";
			   }else if(data.sfbz == 0){//系统管理员
				   location = "<%=path %>/hsxy/sdjf/admin/goxtgly"; 
			   }else if(data.sfbz == 2){//宿舍管理员
				   location = "<%=path %>/hsxy/sdjf/ssadmin/gossgly"; 
			   }else{
				   alert("密码或学号输入错误！")
			   }
	       },
           error: function() {
               //请求出错
               alert("请求出错");
           }
		   });
}
</script>

</body>
</html>
