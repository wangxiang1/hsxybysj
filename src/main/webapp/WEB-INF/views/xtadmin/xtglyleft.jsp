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
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="<%=path %>/js/model/images/leftico01.png" /></span>管理水电费信息
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/goxtglymain" target="rightFrame">首页</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/gosdfsj?page=0&sslh=&ssh=&sfjf&date=" target="rightFrame">水电费数据表</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/fytj?sslh=&ssh=&qssj=2016-01-01 00:00:00&jzsj=2017-07-08 00:00:00" target="rightFrame">费用统计</a><i></i></li>
        </ul>    
    </dd>
    
    <dd>
    <div class="title">
    <span><img src="<%=path %>/js/model/images/leftico02.png" /></span>管理用户信息
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/yhxx?page=0&bz=1" target="rightFrame">用户信息</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/adduser" target="rightFrame">新增用户</a><i></i></li>
        </ul>     
    </dd> 
    
    <dd>
    <div class="title"><span><img src="<%=path %>/js/model/images/leftico03.png" /></span>公告管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/gggl" target="rightFrame">公告信息</a><i></i></li>
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/gggl" target="rightFrame">新增公告</a><i></i></li>
    </ul>    
    </dd>
      
    <dd>
    <div class="title"><span><img src="<%=path %>/js/model/images/leftico03.png" /></span>其他设置</div>
    <ul class="menuson">
        <li><cite></cite><a href="<%=path %>/hsxy/sdjf/admin/goglyxgmm" target="rightFrame">修改密码</a><i></i></li>
    </ul>    
    </dd> 
    </dl>
</body>
</html>
