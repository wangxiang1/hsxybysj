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
<title>水电费信息</title>
<style type="text/css">
.tablelist td{border: solid 1px #c7c7c7;}
</style>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>水电费信息</li>
    </ul>
 </div>
    
    <div class="rightinfo">
        <div><span style="font-size: 20px; position:relative; left: 45%; margin: 15px;">水电费信息</span></div>
        <div class="chaxun" style="position : relative; margin-bottom: 5px; left: 55%; ">
            <div style="position:relative; float: left;"><label style="font-size: 14px;">时间：</label></div>
            <div style="position:relative; float: left; border: solid 1px black; margin-right: 10px;">
            <select id="date">
				<c:forEach items="${dates }" var="d">
					<option value="${d.substring(0, 19) }">${d.substring(0, 11) }</option>
				</c:forEach>
			</select>
			</div>
            <button class="btn-xs btn-primary" onclick="chaxun()">查询</button>
        </div>
	    <table class="tablelist" style="position:relative; width: 700px; left: 20%;">
	    	<tr>
	    	   <td class="wz">宿舍楼</td>
	    	   <td>${sdfxx.sslh }</td>
	    	   <td class="wz">宿舍号</td>
	    	   <td>${sdfxx.ssh }</td>
	    	   <td class="wz">宿舍余额</td>
	    	   <td>${sdfxx.ssye }</td>
	    	</tr>
	    	<tr><td colspan='6'><span style="margin-left: 28px;">水费信息</span></td></tr>
	    	<tr>
	    	   <td class="wz">用水类型</td>
	    	   <td>${sdfxx.yslx }</td>
	    	   <td class="wz">水表起码</td>
	    	   <td>${sdfxx.sbqm}</td>
	    	   <td class="wz">水表止码</td>
	    	   <td>${sdfxx.sbzm }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">用水量</td>
	    	   <td>${sdfxx.ysl }吨</td>
	    	   <td class="wz">水费单价</td>
	    	   <td>${sdfxx.sfdj }元/吨</td>
	    	   <td class="wz">水费</td>
	    	   <td>${sdfxx.sf }元</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">查表管理员</td>
	    	   <td>${sdfxx.scbry }</td>
	    	   <td class="wz">日期</td>
	    	   <td colspan='4'>${sdfxx.date }</td>
	    	</tr>
	    	<tr><td colspan='6'><span style="margin-left: 28px;">电费信息</span></td></tr>
	    	<tr>
	    	   <td class="wz">用电类型</td>
	    	   <td>${sdfxx.ydlx }</td>
	    	   <td class="wz">电表起码</td>
	    	   <td>${sdfxx.dbqm }</td>
	    	   <td class="wz">电表止码</td>
	    	   <td>${sdfxx.dbzm }</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">用电量</td>
	    	   <td>${sdfxx.ydl }千瓦时</td>
	    	   <td class="wz">电费单价</td>
	    	   <td>${sdfxx.dfdj }元/千瓦时</td>
	    	   <td class="wz">电费</td>
	    	   <td>${sdfxx.df }元</td>
	    	</tr>
	    	<tr>
	    	   <td class="wz">查表管理员</td>
	    	   <td>${sdfxx.dcbry }</td>
	    	   <td class="wz">日期</td>
	    	   <td colspan='4'>${sdfxx.date }</td>
	    	</tr>
	    </table>
    </div>
    <script type="text/javascript">
    	$(function(){
    		$(".wz").css("text-align","center");
    		$("td").css("width","150px");
    	});
    	
    	function chaxun(){
    		var ssid = "${sdfxx.ssid }";
    		var date = $("#date").val();
    		location = "<%=path %>/hsxy/sdjf/findSdfxxBydate?ssid="+ssid+"&date="+date;
    	}
    </script>
</body>
</html>