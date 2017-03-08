<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/js/model/css/select.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/select-ui.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/editor/kindeditor.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<style type="text/css">
.vocation{border: 1px solid #C7C7C7;height: 30px;width: 60px;}
.select1{height: 28px; width: 58px;}

.cityleft,.cityright{border: 1px solid #C7C7C7;height: 30px;width: 120px; margin-right: 20px;}
.select2{height: 28px; width: 119px;}
</style>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>首页</li>
    <li>管理用户信息</li>
    <li>修改用户信息</li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
  	<c:if test="${bz == 1 }">
    	<li><a href="#tab1" class="selected">学生用户</a></li> 
  	</c:if>
  	<c:if test="${bz == 2 }">
        <li><a href="#tab2" class="selected">管理员用户</a></li>
    </c:if> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson" style="height: 500px;">
    
    <div class="formtext">修改学生用户</div>
    
    <ul class="forminfo">
    <li>
    	<label>学号<b>*</b></label>
   	    <input id="studlzh" type="text" class="dfinput" value="${student.dlzh }" readonly="readonly" style="width:508px;"/>
    </li>
    <li>
    	<label>姓名<b>*</b></label>
    	<input id="stuyhm" type="text" class="dfinput" value="${student.yhm }"  style="width:508px;" onblur="checkStuYhm()"/>
   </li>
   <li style="margin-top: 10px;"><label>性别<b>*</b></label>  
    <div class="vocation">
	    <select class="select1" id="stusex">
	    <c:if test="${student.sex == 0 }">
	    	<option value="0" selected="selected">女</option>
		    <option value="1">男</option>
	    </c:if>
	    <c:if test="${student.sex == 1 }">
	    	<option value="0">女</option>
		    <option value="1" selected="selected">男</option>
	    </c:if>
		    
	    </select>
    </div>
    </li>
    <li><label style="margin-top: 10px;">学历<b>*</b></label>  
    <div class="vocation" style="margin-top: 10px;">
	    <select class="select1" id="stuxl" onchange="getXb()">
	     <c:if test="${student.xl == 0 }">
		    <option value="0" selected = "selected">本科</option>
		    <option value="1">专科</option>
	     </c:if>
	     <c:if test="${student.xl == 1 }">
		    <option value="0">本科</option>
		    <option value="1" selected = "selected">专科</option>
	     </c:if>
	    </select>
    </div>
    </li>
    <li><label style="margin-top: 10px;">院系专业<b>*</b></label>
    <div class="usercity" style="margin-top: 10px;">
    <div class="cityleft">
    <select class="select2" id="stuxb" onchange="getZy()">
    </select>
    </div>
    
    <div class="cityright">
    <select class="select2" id="stuzy">
    </select>
    </div>
    
    </div>
    </li>
    
    <li><label style="margin-top: 10px;">宿舍<b>*</b></label>
    <div class="usercity" style="margin-top: 10px;">
    <div class="cityleft">
    <select class="select2" id="stusslh" onchange="getSshs()">
    </select>
    </div>
    
    <div class="cityright">
    <select class="select2" id="stussh">
    </select>
    </div>
    
    </div>
    </li>
    <li>
    	<label style="margin-top: 10px;">手机号<b>*</b></label>
    	<input id="stusjhm" type="text" class="dfinput" value="${student.sjhm }" onblur="checkTel(1)" style="width:508px;margin-top: 10px;"/>
    </li>
    <li><label>&nbsp;</label><input id="stuquren" type="button" class="btn" value="确认"/></li>
    </ul>
    </div> 
    
    
  	<div id="tab2" class="tabson" style="height: 500px;">
    
    <div class="formtext">修改管理员用户信息</div>
    
    <ul class="forminfo">
    <li>
    	<label>登录账号<b>*</b></label>
    	<input id="glydlzh" type="text" class="dfinput" value="${ssAadmin.dlzh }" readonly="readonly" style="width:508px;"/>
    </li>
    <li>
    	<label>姓名<b>*</b></label>
    	<input id="glyyhm" type="text" class="dfinput"  value="${ssAadmin.yhm }"  style="width:508px;" onblur="checkGlyYhm()"/>
    </li>
    <li style="margin-top: 10px;"><label>性别<b>*</b></label>  
    <div class="vocation">
	    <select class="select1" id="glysex">
			<c:if test="${ssAadmin.sex == 0 }">
		    	<option value="0" selected="selected">女</option>
			    <option value="1">男</option>
		    </c:if>
		    <c:if test="${ssAadmin.sex == 1 }">
		    	<option value="0">女</option>
			    <option value="1" selected="selected">男</option>
		    </c:if>
		    <c:if test="${ssAadmin.sex != 1 && ssAadmin.sex != 0 }">
		    	<option value="">请选择</option>
		    	<option value="0">女</option>
			    <option value="1">男</option>
		    </c:if>
	    </select>
    </div>
    </li>
    <li><label style="margin-top: 10px;">类型<b>*</b></label>  
    <div class="vocation" style="width: 100px; margin-top: 10px;">
	    <select class="select1" style="width: 98px;" id="glybz" onchange="getSslhs()">
		    <c:if test="${ssAadmin.sfbz == 0 }">
		    	<option value="0"  selected="selected">系统管理员</option>
		    	<option value="2">宿舍管理员</option>
		    </c:if>
		    <c:if test="${ssAadmin.sfbz == 2 }">
		    	<option value="0">系统管理员</option>
		    	<option value="2" selected="selected">宿舍管理员</option>
		    </c:if>
	    </select>
    </div>
    </li>
  	<li><label style="margin-top: 10px;">宿舍楼<b>*</b></label>  
    <div class="vocation" style="width: 100px; margin-top: 10px;">
	    <select class="select1" style="width: 98px;" id="glysslh" onblur="checkSsl()">
	    </select>
    </div>
    </li>
    <li>
       <label style="margin-top: 10px;">手机号<b>*</b></label>
       <input id="glysjhm" type="text" class="dfinput" onblur="checkTel(2)" value="${ssAadmin.sjhm }" style="width:508px;margin-top: 10px;"/>
    </li>
    <li><label>&nbsp;</label><input id="glyquren" type="button" class="btn" value="确认"/></li>
    </ul>
    </div>
    
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
      $(function(){
    	  getXb();
    	  getSslhs();
    	  if("${bz }" == 1){
    		  $("#tab2").hide();
    	  }else{
    		  $("#tab1").hide();
    	  }
      });
      
      $("#stuquren").click(function(){
    	  var studlzh = $("#studlzh").val();
    	  var stuyhm = $("#stuyhm").val();
    	  var stusex = $("#stusex").val();
    	  var stuxl = $("#stuxl").val();
    	  var stuxb = $("#stuxb").val();
    	  var stuzy = $("#stuzy").val();
    	  var stusslh = $("#stusslh").val();
    	  var stussh = $("#stussh").val();
    	  var stusjhm = $("#stusjhm").val();
    	  
    	  $.ajax({
    	       type:"POST",
    	       url:"<%=path%>/hsxy/sdjf/admin/updatestu",
    	       data:{
    	    	     "studlzh":studlzh,
    	    	     "stuyhm":stuyhm,
    	    	     "stusex":stusex,
    	    	     "stuxl":stuxl,
    	    	     "stuxb":stuxb,
    	    	     "stuzy":stuzy,
    	    	     "stusslh":stusslh,
    	    	     "stussh":stussh,
    	    	     "stusjhm":stusjhm
    			     },
    	       success:function(data){
    	    	 if(data){
    	    		 location = "<%=path %>/hsxy/sdjf/admin/yhxx?page=0&bz=1";
    	    	 }else{
    	    		 alert("修改失败");
    	    	 }
    	    	  
    	       },
               error: function() {
                   //请求出错
                   alert("请求出错");
               }
    		   });
      });
      $("#glyquren").click(function(){
    	  var glydlzh = $("#glydlzh").val();
    	  var glyyhm = $("#glyyhm").val();
    	  var glysex = $("#glysex").val();
    	  var glybz = $("#glybz").val();
    	  var glysslh = $("#glysslh").val();
    	  var glysjhm = $("#glysjhm").val();
    	  
    	  $.ajax({
   	       type:"POST",
   	       url:"<%=path%>/hsxy/sdjf/admin/updategly",
   	       data:{
   	    	     "glydlzh":glydlzh,
   	    	     "glyyhm":glyyhm,
   	    	     "glysex":glysex,
   	    	     "glybz":glybz,
   	    	     "glysslh":glysslh,
   	    	     "glysjhm":glysjhm
   			     },
   	       success:function(data){
   	    	 if(data){
   	    		 location = "<%=path %>/hsxy/sdjf/admin/yhxx?page=0&bz=2";
   	    	 }else{
   	    		 alert("修改失败");
   	    	 }
   	    	  
   	       },
              error: function() {
                  //请求出错
                  alert("请求出错");
              }
   		   });
      });
        function checkStuYhm(){
      	  var stuyhm = $("#stuyhm").val();
      	  if (stuyhm == "") {
  			alert("用户名不为空");
  			return false;
  		}
      	  return true;
        }

      	function checkXbZy(){
      		var stuxb = $("#stuxb").val();
      		var stuzy = $("#stuzy").val();
      		if(stuxb == "" || stuzy == ""){
      			alert("请选择院系专业");
      			return false;
      		}
      		return true;
      	}
      	
      	function checkSslSsh(){
      		var stusslh = $("#stusslh").val();
        	    var stussh = $("#stussh").val();
      		if(stusslh == "" || stussh == ""){
      			alert("请选择所属宿舍");
      			return false;
      		}
      		return true;
      	}
      	
      	function checkSsl(){
      		var glysslh = $("#glysslh").val();
      		if(glysslh == ""){
      			alert("请选择管理宿舍楼号");
      			return false;
      		}
      		return true;
      	}
      	
      	function checkTel(sjhm){
      		var id;
      		if(sjhm == 1){
      			id = "stusjhm";
      		}else{
      			id = "glysjhm";
      		}
      		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
      		if(!myreg.test($("#"+id).val())){ 
      		    alert('请输入有效的手机号码！'); 
      		    return false; 
      		}
      		return true;
          }
      	
      	function checkDlzhAjax(dlzh){
      		$.ajax({
        	       type:"POST",
        	       url:"<%=path%>/hsxy/sdjf/admin/finddlzh",
        	       data:{
        	    	     "dlzh":dlzh
        			     },
        	       success:function(data){
        	    	  return data;
        	       },
                   error: function() {
                       //请求出错
                       alert("请求出错");
                   }
        		   });
      	}
      	
      	function getXb(){
      	  var xl = $("#stuxl").val();
      	  $.ajax({
     	       type:"POST",
     	       url:"<%=path%>/hsxy/sdjf/admin/stuxb",
     	       data:{
     	    	     "stuxl":xl
     			     },
     	       success:function(data){
     	    	  var html = '<option value="">请选择</option>';
     	    	  var str = (data.xbs).toString();
  	    	  if(str != ""){
  	    		 var strs= new Array(); //定义一数组 
  	    		 strs = str.split(',');
  	    		 $.each(strs,function(s,d){
  	    			if("${student.xb}" == d){
  	    				html += '<option value="'+d+'" selected="selected">'+d+'</option>';
  	    			}else{
  	    				html += '<option value="'+d+'">'+d+'</option>';
  	    			}
  	   			      
  	   		      });
  	    	  }
     	    	  $("#stuxb").html(html);
     	    	  getZy();
     	    	  
     	       },
                error: function() {
                    //请求出错
                    alert("请求出错");
                }
     		   });
        }
        
        function getZy(){
        	debugger
      	  var xl = $("#stuxl").val();
      	  var xb = $("#stuxb").val();
      	  $.ajax({
     	       type:"POST",
     	       url:"<%=path%>/hsxy/sdjf/admin/stuzy",
     	       data:{
     	    	     "stuxl":xl,
     	    	     "stuxb":xb
     			     },
     	       success:function(data){
     	    	  var html = '<option value="">请选择</option>';
     	    	  var str = (data.zys).toString();
  	    	  if(str != ""){
  	    		 var strs= new Array(); //定义一数组 
  	    		 strs = str.split(',');
  	    		 $.each(strs,function(s,d){
  	    			if("${student.zy}" == d){
  	   			         html += '<option value="'+d+'" selected="selected">'+d+'</option>';
  	    			}else{
  	    				 html += '<option value="'+d+'">'+d+'</option>';
  	    			}
  	   		      });
  	    	  }
     	    	  $("#stuzy").html(html);
     	       },
                error: function() {
                    //请求出错
                    alert("请求出错");
                }
     		   });
        }
        
        function getSslhs(){
      	  var glybz = $("#glybz").val();
      	  $.ajax({
     	       type:"POST",
     	       url:"<%=path%>/hsxy/sdjf/admin/glysslh",
     	       data:{},
     	       success:function(data){
     	    	if (glybz == 0) {
     	    		var html = '<option value="all" selected = "selected">all</option>';
  			}else {
  				var html = '<option value="">请选择</option>';
  	   	    	  var str = (data.sslhs).toString();
  		    	  if(str != ""){
  		    		 var strs= new Array(); //定义一数组 
  		    		 strs = str.split(',');
  		    		 $.each(strs,function(s,d){
  		    			if("${ssAadmin.sslh}" == d){
  		   			      html += '<option value="'+d+'" selected = "selected">'+d+'号楼</option>';
  		    			}else{
  		    			  html += '<option value="'+d+'">'+d+'号楼</option>';
  		    			}
  		   		      });
  		    	  }
  			}
     	    	  $("#glysslh").html(html);
     	    	  
     	      var html1 = '<option value="">请选择</option>';
   	    	  var str = (data.sslhs).toString();
  	    	  if(str != ""){
  	    		 var strs= new Array(); //定义一数组 
  	    		 strs = str.split(',');
  	    		 $.each(strs,function(s,d){
  	    			if("${student.sslh}" == d){
  	   			          html1 += '<option value="'+d+'" selected = "selected">'+d+'号楼</option>';
  	    			}else{
		    			  html1 += '<option value="'+d+'">'+d+'号楼</option>';
		    			}
  	   		      });
  	    	  }
     	    	  
     	    	  $("#stusslh").html(html1);
     	    	  
     	    	  getSshs();
     	    	  
     	       },
                error: function() {
                    //请求出错
                    alert("请求出错");
                }
     		   });
        }
        
        function getSshs(){
    	      var stusslh = $("#stusslh").val();
        	  $.ajax({
       	       type:"POST",
       	       url:"<%=path%>/hsxy/sdjf/admin/fytj/findssh",
       	       data:{
       	    	     "sslh":stusslh
       			     },
       	       success:function(data){
       	    	  var html = '<option value="">请选择</option>';
       	    	  var str = (data.sshs).toString();
  	  	    	  if(str != ""){
  	  	    		 var strs= new Array(); //定义一数组 
  	  	    		 strs = str.split(',');
  	  	    		 $.each(strs,function(s,d){
  	  	    			if("${student.ssh}" == d){
  	  	   			         html += '<option value="'+d+'" selected="selected">'+d+'</option>';
  	  	    			}else{
  	  	    				 html += '<option value="'+d+'">'+d+'</option>';
  	  	    			}
  	  	   		      });
  	  	    	  }
  	     	    	  $("#stussh").html(html);
       	       },
                  error: function() {
                      //请求出错
                      alert("请求出错");
                  }
       		   });
          }
    </script>
    
</body>
</html>