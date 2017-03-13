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
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>菜单</div>
    <dl class="leftmenu">
    <dd>
   <div class="title">
    <span><img src="<%=path %>/js/model/images/leftico01.png" /></span>管理信息
    </div> 
    	<ul class="menuson">
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostumain" target="rightFrame">首页</a><i></i></li>
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostussxx?stuid=${user.yhid }&page=0" target="rightFrame">宿舍信息总览</a><i></i></li>
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostugrxx?stuid=${user.yhid }" target="rightFrame">个人信息</a><i></i></li>
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostusdfxx?stuid=${user.yhid }" target="rightFrame">水电费信息</a><i></i></li>
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostujf?stuid=${user.yhid }" target="rightFrame">缴费管理</a><i></i></li>
	        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/gostuxgmm?stuid=${user.yhid }" target="rightFrame">修改密码</a><i></i></li>
        </ul>    
    </dd>
    </dl>
</body>
</html>
