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
<title>缴费</title>
<style type="text/css">
.tablelist td{border: solid 1px #c7c7c7;}
</style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>缴费管理</li>
    </ul>
    </div>
    
    <div class="rightinfo">
        <div><span style="font-size: 20px; position:relative; left: 45%; margin: 15px;">宿舍水电缴费</span></div>
	    <table class="tablelist" style="position:relative; width: 700px; left: 20%;">
	    	<tr>
	    	   <td class="wz">宿舍楼号</td>
	    	   <td>${sdfxx.sslh }号楼</td>
	    	   <td class="wz">宿舍号</td>
	    	   <td>${sdfxx.ssh }</td>
	    	   <td class="wz">宿舍余额</td>
	    	   <td>${sdfxx.ssye }元</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">本月水费</td>
	    	   <td>${sdfxx.sf }元</td>
	    	   <td class="wz">本月电费</td>
	    	   <td>${sdfxx.df }元</td>
	    	   <td class="wz">总计</td>
	    	   <td>${sdfxx.sf + sdfxx.df - sdfxx.ssye}元</td>
	    	</tr>
	    </table>
    </div>
    <script type="text/javascript">
    </script>
</body>
</html>