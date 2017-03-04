<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=path %>/js/nivo-slider/scripts/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/laypage/laypage.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/My97DatePicker/WdatePicker.js"></script>
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/js/model/css/select.css" rel="stylesheet" type="text/css" />
<title>费用统计</title>
<style type="text/css">
.tablelist td{border: solid 1px #c7c7c7; text-align: center;}
.c{width: 200px;}
</style>
</head>
<body>
    <div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">管理水电费信息</a></li>
			<li><a href="#">费用统计</a></li>
		</ul>
	</div>
	<div class="rightinfo col-sm-12">
		<div class="tools" style="position:relative; left: 5%; margin-top: 10px;">
			 <ul class="seachform">
			    <li>
			      <label>宿舍楼号</label>
			      
			      <div class="vocation" style="border: 1px solid #C7C7C7; width: 100px; height: 30px;">
           			 <select id="sslh" style="width: 98px; height: 28px;" onchange="findSsh()">
          			   <option value="">请选择</option>
          			   <c:forEach items="${sslhs }" var="s" varStatus="i">
          			      <option value="${s }">${s }号楼</option>
          			   </c:forEach>
					</select>
			       </div>
			    </li>
			    <li>
			      <label>宿舍号</label>
			       <div class="vocation" style="border: 1px solid #C7C7C7; width: 100px; height: 30px;">
           			 <select id="ssh" style="width: 98px; height: 28px;">
          			  	<option value="">请选择</option>
					</select>
			       </div>
			    </li>
			    <li>
			       <label>起始日期</label>
           		   <input id="timeFrom" style="cursor: pointer; width: 150px;height: 30px;" class="Wdate" type="text" readonly="readonly" onfocus="timeStartfun()"/>
			    </li>
			    <li>
			       <label>截止日期</label>
			       <input id="timeTill" style="cursor: pointer; width: 150px;height: 30px;" class="Wdate" type="text" readonly="readonly" onfocus="timeTillfun()"/>
			    </li>
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询" onclick="chaxun()"/></li>
              </ul>
		</div>

		<table class="tablelist" style="position:relative; width: 1000px; left: 5%;">
				<tr>
					<td class="c" colspan='4' id="bt">
					   <font style="font-size: 16px;">费用统计表</font>
					</td>
				</tr>
				<tr>
					<td class="c">用水量</td>
					<td id="ysltd"></td>
					<td>用电量</td>
			    	<td id="ydltd"></td>
				</tr>
			    <tr>
			        <td class="c">水费</td>
					<td id="sftd"></td>
			    	<td>电费</td>
			    	<td id="dftd"></td>
			    </tr>
			    <tr>
			        <td>起始日期</td>
			    	<td id="qsrqtd"></td>
			    	<td>截止日期</td>
			    	<td id="jzrqtd"></td>
			    </tr> 
		</table>
		<div style="float: right; position: relative; right: 10%; margin-top: 10px;">
		    <a href="#" class="tablelink" style="margin-right: 20px;">导出Excel</a>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		chaxun();
	});
	
	function timeStartfun(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			onpicked:function(){$dp.$('timeTill').focus();},
			dateFmt:'yyyy-MM-dd HH:mm:ss',
			maxDate:'#F{$dp.$D(\'timeTill\')}'
			});
	}

	function timeTillfun(){
		WdatePicker({
			isShowClear:false,
			readOnly:true,
			dateFmt:'yyyy-MM-dd HH:mm:ss',
			minDate:'#F{$dp.$D(\'timeFrom\')}',
			maxDate:'%y-%M-%d'
			});
	}
	
	function findSsh(){
		var sslh = $("#sslh").val();
		$.ajax({
		       type:"POST",
		       url:"<%=path%>/hsxy/sdjf/admin/fytj/findssh",
		       data:{
		    	     "sslh":sslh
		    	      },
		       success:function(data){
		    	  var html = '<option value="">请选择</option>';
		    	  var str = (data.sshs).toString();
		    	  if(str != ""){
		    		 var strs= new Array(); //定义一数组 
		    		 strs = str.split(',');
		    		 $.each(strs,function(s,d){
		    			 html += '<option value="'+d+'">'+d+'</option>';
		    		 });
		    	  }
		    	  $("#ssh").html(html);
		       },
	           error: function() {
	               //请求出错
	               alert("请求出错");
	           }
			   });
	}
	
	function chaxun(){
		var sslh = $("#sslh").val();
		var ssh = $("#ssh").val();
		var qssj = $("#timeFrom").val();
		var jzsj = $("#timeTill").val();
		
		if("" == qssj || "" == jzsj){
			qssj = getYesterMouthDate();
			jzsj = getNowDate();
			$("#timeFrom").val(qssj);
			$("#timeTill").val(jzsj);
		}
		$.ajax({
		       type:"POST",
		       url:"<%=path%>/hsxy/sdjf/admin/fytj/table",
		       data:{
		    	     "sslh":sslh,
		    	     "ssh":ssh,
		    	     "qssj":qssj,
		    	     "jzsj":jzsj
		    	      },
		       success:function(data){
		    	  $("#ysltd").html(data.zjysl+"吨");
		    	  $("#sftd").html(data.zjsf+"元");
		    	  $("#ydltd").html(data.zjydl+"千瓦时");
		    	  $("#dftd").html(data.zjdf+"元");
		    	  $("#qsrqtd").html(qssj);
		    	  $("#jzrqtd").html(jzsj);
		       },
	           error: function() {
	               //请求出错
	               alert("请求出错");
	           }
			   });
		
	}
	
	//获取当前时间
	function getNowDate(){
		 var date = new Date();
	     var seperator1 = "-";
	     var seperator2 = ":";
	     var month = date.getMonth() + 1;
	     var strDate = date.getDate();
	     var strhours = date.getHours();
	     var strmin = date.getMinutes();
	     var strsecond = date.getSeconds();
	     if (month >= 1 && month <= 9) {
	         month = "0" + month;
	     }
	     if (strDate >= 0 && strDate <= 9) {
	         strDate = "0" + strDate;
	     }
	     if (strhours >= 0 && strhours <= 9) {
	     	strhours = "0" + strhours;
	     }
	     if (strmin >= 0 && strmin <= 9) {
	     	strmin = "0" + strmin;
	     }
	     if (strsecond >= 0 && strsecond <= 9) {
	     	strsecond = "0" + strsecond;
	     }
	     var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	             + " " + strhours + seperator2 + strmin
	             + seperator2 + "00";
	     return currentdate;
	};
	function getYesterMouthDate(){
		var date = new Date(new Date().getTime()-365 * 24 * 3600 * 1000);
	    var seperator1 = "-";
	    var seperator2 = ":";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    var strhours = date.getHours();
	    var strmin = date.getMinutes();
	    var strsecond = date.getSeconds();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    if (strhours >= 0 && strhours <= 9) {
	    	strhours = "0" + strhours;
	    }
	    if (strmin >= 0 && strmin <= 9) {
	    	strmin = "0" + strmin;
	    }
	    if (strsecond >= 0 && strsecond <= 9) {
	    	strsecond = "0" + strsecond;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + strhours + seperator2 + strmin
	            + seperator2 + "00";
	    return currentdate;
	};
	</script>
</body>
</html>