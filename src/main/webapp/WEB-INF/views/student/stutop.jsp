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
    	<a href="main.html" target="_parent"><img src="<%=path %>/js/model/images/logo.png" title="系统首页" /></a>
    </div>
        
    <ul class="nav">
	    <li><a href="<%=path %>/hsxy/sdjf/gostumain" target="rightFrame" class="selected"><img src="<%=path %>/js/model/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
	    <li><a href="<%=path %>/hsxy/sdjf/gostumain" target="rightFrame"><img src="<%=path %>/js/model/images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
	    <li><a href="imglist.html"  target="rightFrame"><img src="<%=path %>/js/model/images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
	    <li><a href="tools.html"  target="rightFrame"><img src="<%=path %>/js/model/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
	    <li><a href="computer.html" target="rightFrame"><img src="<%=path %>/js/model/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
	    <li><a href="tab.html"  target="rightFrame"><img src="<%=path %>/js/model/images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    </ul>
            
    <div class="topright">    
	    <ul>
		    <li><span><img src="<%=path %>/js/model/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
		    <li><a href="#">关于</a></li>
		    <li><a href="login.html" target="_parent">退出</a></li>
	    </ul>
    <div class="user">
	    <span>${user.yhm }</span>
	    <i>消息</i>
	    <b>5</b>
    </div>    
    
    </div>
</body>
</html>
