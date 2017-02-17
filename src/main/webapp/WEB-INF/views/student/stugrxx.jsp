<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<title>学生个人信息</title>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>个人信息</li>
    </ul>
    </div>
    
    <div class="rightinfo">
        <div><span style="font-size: 20px; position:relative; left: 45%; margin: 15px;">个人信息</span></div>
	    <table class="tablelist" style="position:relative; width: 700px; left: 20%;">
	    	<tr>
	    	   <td class="wz">姓名</td>
	    	   <td>${student.yhm }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">性别</td>
	    	   <td>
	    	   <c:if test="${student.sex == 0}">女</c:if>
	    	   <c:if test="${student.sex == 1}">男</c:if>   
	    	   </td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">学号</td>
	    	   <td>${student.dlzh }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">学历</td>
	    	   <td>
		    	   <c:if test="${student.xl == 0}">本科</c:if>
		    	   <c:if test="${student.xl == 1}">专科</c:if>
	    	   </td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">系别</td>
	    	   <td>${student.xb }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">专业</td>
	    	   <td>${student.zy }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">宿舍楼号</td>
	    	   <td>${student.sslh }号楼</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">宿舍号</td>
	    	   <td>${student.ssh }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">手机号</td>
	    	   <td>${student.sjhm }</td>
	    	</tr>
	    </table>
    </div>
    <script type="text/javascript">
    	$(function(){
    		$(".wz").css("text-align","center");
    		$("td").css("width","150px");
    	});
    </script>
</body>
</html>