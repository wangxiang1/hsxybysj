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
        <div><span style="font-size: 20px; position:relative; left: 42%; margin: 15px;">宿舍水电缴费</span></div>
        <div class="chaxun" style="position : relative; margin-bottom: 5px; left: 55%; ">
            <div style="position:relative; float: left;"><label style="font-size: 14px;">时间：</label></div>
            <div style="position:relative; float: left; border-radius:2px; border: solid 1px black; margin-right: 10px;">
            <select id="date">
				<c:forEach items="${dates }" var="d">
				<c:if test="${d.substring(0, 19) == sdfxx.date }">
					<option selected="selected" value="${d.substring(0, 19) }">${d.substring(0, 11) }</option>
				</c:if>
				<c:if test="${d.substring(0, 19) != sdfxx.date }">
					<option value="${d.substring(0, 19) }">${d.substring(0, 11) }</option>
				</c:if>
				</c:forEach>
			</select>
			</div>
            <button class="btn-xs btn-primary" onclick="chaxun()">查询</button>
        </div>
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
	    	   <td class="wz">本月总计</td>
	    	   <td>${sdfxx.zj }元</td>
	    	</tr>
	    	<tr>
		    	<c:if test="${sdfxx.ssfjf == 0 }">
		    		<td colspan='6' style="margin: 20px;">
			    		<font style="font-size: 22px; position: relative; float: left; color: red; margin-left: 35%;margin-right: 3%; margin-top: 8px;margin-bottom: 5px;">${sdfxx.zj } 元</font>
			    		<button class="btn-primary btn-lg" data-toggle="modal" data-target="#myModal"; style="position: relative; float: left; margin-top: 5px;margin-bottom: 5px;">缴费</button>
		    	    </td>
		    	</c:if>
		    	<c:if test="${sdfxx.ssfjf == 1 }">
		    	     <td colspan='6' style="margin: 20px;"> 
		    	        <font>本月已经缴费！</font>
		    	     </td>
		    	</c:if>
	    	</tr>
	    </table>
    </div>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	          <span class="sr-only">Close</span>
	        </button>
	        <h4 class="modal-title" id="myModalLabel">缴费</h4>
	      </div>
	      <div class="modal-body">
	      <div style="margin-bottom: 10px;">
	      	<div style="position: relative; float: left;margin-top: 3px;">
	       		<span id="hj" style="font-size: 18px;"></span>
	       	</div>
	       	<div style="position: relative; float: left; margin-left: 30px;">
	       	    <div style="float: left; margin-top: 3px;"><span style="font-size: 18px;">缴费金额：</span></div>
	       		<div style="float: left; margin-bottom: 5px;"><input type="text" id="jfje" class="form-control" style="width: 70px;" ></div>
	       		<div style="float: left; margin-top: 3px;"><span style="font-size: 18px;">元</span></div>
	       	</div>
	       </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">取消</button>
	        <button type="button" class="btn-sm btn-primary" onclick="qrjf()">确认</button>
	      </div>
	    </div>
	  </div>
    </div>
    <script type="text/javascript">
		var ssye = "${sdfxx.ssye}";
		var zj = "${sdfxx.zj}";
		var hj = (zj - ssye).toFixed(2);
    $(function(){
		$(".wz").css("text-align","center");
		$("td").css("width","150px");
		$("#hj").html("合计："+hj+"元");
	});
    
    function qrjf(){
    	var jfje = $("#jfje").val();
    	
    	if(jfje == ""){
    		alert("请输入缴费金额！");
    	}else if(isNaN(jfje)){ //判断缴费金额的输入是不是数字
    		alert("输入错误！");
    	}else if(jfje < hj){
    		alert("缴费金额小于应付金额，请重新输入金额！");
    	}else {
    		qrAjax(jfje,hj);
		}
    }
    
    function qrAjax(jfje,yjje){
    	$.ajax({
 	       type:"POST",
 	       url:"<%=path%>/hsxy/sdjf/gostuqrjf",
 	       data:{
 	    	     "jfje":jfje,
 	    	     "yjje":yjje,
 	    	     "ssid":"${sdfxx.ssid }",
 	    	     "stuid":"${user.yhid }",
 	    	     "sfid":"${sdfxx.sfid }",
 	    	     "dfid":"${sdfxx.dfid }"
 			     },
 	       success:function(data){
 	    	   if (data == 1) {
 	    		   alert("缴费成功！");
 				   location = "<%=path %>/hsxy/sdjf/gostujf?stuid=${user.yhid }";
 			   }else{
 				   alert("缴费失败，请重试");
 			   }
 	       },
            error: function() {
                //请求出错
                alert("请求出错");
            }
 		   });
    }
    function chaxun(){
		var stuid = "${user.yhid }";
		var date = $("#date").val();
		location = "<%=path %>/hsxy/sdjf/gostujf?stuid="+stuid+"&date="+date;
	}
    </script>
</body>
</html>