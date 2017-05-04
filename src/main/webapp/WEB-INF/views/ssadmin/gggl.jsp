<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/laypage/laypage.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/select-ui.min.js"></script>
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/js/model/css/select.css" rel="stylesheet" type="text/css" />
<title>公告信息</title>
</head>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>公告管理</li>
			<li>公告信息</li>
		</ul>
	</div>
<div class="rightinfo col-sm-12">
		<table class="tablelist">
			<thead>
				<tr>
					<th style="width: 60px;">编号</th>
					<th style="width: 150px;">公告主题</th>
					<th style="width: 300px;">公告内容</th>
					<th style="width: 120px;">日期</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ggxxs }" var="g" varStatus="i">
				<tr>
					<td>${pager.page * 5 + i.index + 1 }</td>
					<td>${g.ggzt }</td>
					<td>${g.ggnr }</td>
					<td>${g.ggrq }</td>
				</tr>
            </c:forEach>
			</tbody>
		</table>


	    <div class="pagin">
			<div class="message">
				共<i class="blue">${pager.totalPages }</i>页，当前显示第&nbsp;<i class="blue">${pager.page + 1 }&nbsp;</i>页
			<div id="page" style="position: relative; float: right;"></div>
			</div>
		</div>

	</div>
<body>
 <script type="text/javascript">
 $('.tablelist tbody tr:odd').addClass('odd');
 $(document).ready(function(){
   $(".click").click(function(){
   $(".tip").fadeIn(200);
   });
   
   $(".tiptop a").click(function(){
   $(".tip").fadeOut(200);
 });

   $(".sure").click(function(){
   $(".tip").fadeOut(100);
 });

   $(".cancel").click(function(){
   $(".tip").fadeOut(100);
 });
 });

</script>
</body>
</html>