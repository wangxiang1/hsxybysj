<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<title></title>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>
<body style="background:url(<%=path %>/js/model/images/topbg.gif) repeat-x;">
    <div class="topleft">
    	<a href="main.html" target="_parent"><img alt="logo" src="<%=path %>/js/model/images/hsxylogo.png" style="width: 60px;height: 60px; margin-left: 20px;">
    	  <div style="height: 50px; float: right; margin-right: 55px; margin-top: 30px;"><font style="font-size: 18px; color: #F0F0F0;">水电缴费管理系统</font></div></a>
    </div>
        
    <ul class="nav">
	    <li><a href="<%=path %>/hsxy/sdjf/admin/goxtglymain" target="rightFrame" class="selected"><img src="<%=path %>/js/model/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    </ul>
            
    <div class="topright">    
	    <ul>
		    <li><span><img src="<%=path %>/js/model/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    <li><a href="<%=path%>/hsxy/sdjf/" target="_parent">退出</a></li>
	    </ul>
    <div class="user">
	    <span>${user.yhm }</span>
    </div>    
    
    </div>
</body>
</html>
