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
<title>用户信息</title>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>管理用户信息</li>
    <li>用户信息</li>
    </ul>
    </div>
    <div id="usual1" class="usual"style="margin-top: 20px;">
    <div class="itab">
  	<ul> 
  	<c:if test="${bz == 1 }">
	    <li><a href="#tab1" class="selected" id="stutab">学生信息</a></li> 
	    <li><a href="#tab2" id="admintab">管理员信息</a></li> 
  	</c:if>
  	<c:if test="${bz == 2 }">
	    <li><a href="#tab1" id="stutab">学生信息</a></li> 
	    <li><a href="#tab2"  class="selected" id="stutab">管理员信息</a></li> 
  	</c:if>
  	</ul>
    </div>
    
    <div class="rightinfo tabson" id="tab1">
    
    <table class="tablelist">
    	<thead>
    	<tr>
    	    <th>序号</th>
	        <th>学号</th>
	        <th>姓名</th>
	        <th>性别</th>
	        <th>学历</th>
	        <th>院系</th>
	        <th>专业</th>
	        <th>宿舍楼</th>
	        <th>宿舍号</th>
	        <th>手机号码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${students }" var="s" varStatus="i">
	        <tr>
	            <td>
	               ${pager.page * 5 + i.index + 1 }
	            </td>
	        	<td>${s.dlzh }</td>
	        	<td>${s.yhm }</td>
	        	<td>
				   <c:if test="${s.sex == 0}">女</c:if>
	    	  	   <c:if test="${s.sex == 1}">男</c:if>
				</td>
	        	<td>
	        	   <c:if test="${s.xl == 0}">本科</c:if>
		    	   <c:if test="${s.xl == 1}">专科</c:if>
		    	</td>
	        	<td>${s.xb }</td>
	        	<td>${s.zy }</td>
	        	<td>${s.sslh }号楼</td>
	        	<td>${s.ssh }</td>
	        	<td>${s.sjhm }</td>
	        </tr> 
        </c:forEach>
        
    </table>
    
   
       <div class="pagin">
			<div class="message">
				共<i class="blue">${pager.totalPages }</i>页，当前显示第&nbsp;<i class="blue">${pager.page + 1 }&nbsp;</i>页
			<div id="page" style="position: relative; float: right;"></div>
			</div>
		</div>
    </div>
    <div id="tab2" class="tabson">
    	<div class="rightinfo tabson" id="tab1">
    <table class="tablelist">
    	<thead>
    	<tr>
	        <th><input type="checkbox" id="glyalldel" onclick="glydelall()"/></th>
	        <th>登录账号</th>
	        <th>姓名</th>
	        <th>管理类型</th>
	        <th>性别</th>
	        <th>宿舍楼</th>
	        <th>手机号码</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ssAadmins }" var="s" varStatus="i">
	        <tr>
	            <td>
	            	<input id="admindel${i.index }" type="checkbox" name="glybox"  class="glybox1"  value="${s.ssglyid }"/>
	            	${pager.page * 5 + i.index + 1 }
	            </td>
	        	<td>${s.dlzh }</td>
	        	<td>${s.yhm }</td>
	        	<td>
				   <c:if test="${s.sfbz == 0}">系统管理员</c:if>
	    	  	   <c:if test="${s.sfbz == 2}">宿舍管理员</c:if>
				</td>
	        	<td>
				   <c:if test="${s.sex == 0}">女</c:if>
	    	  	   <c:if test="${s.sex == 1}">男</c:if>
	    	  	   <c:if test="${s.sex == 3}"></c:if>
				</td>
	        	<td>${s.sslh }</td>
	        	<td>${s.sjhm }</td>
	        </tr> 
        </c:forEach>
        
    </table>
    
   
       <div class="pagin">
			<div class="message">
				共<i class="blue">${pager1.totalPages }</i>页，当前显示第&nbsp;<i class="blue">${pager1.page + 1 }&nbsp;</i>页
			<div id="page1" style="position: relative; float: right;"></div>
			</div>
		</div>
    </div>
    </div>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	$("#usual1 ul").idTabs(); 
	$(function(){
		//分页
		laypage({
			  cont: 'page', //容器。值支持id名、原生dom对象，jquery对象,
			  pages: '${pager.totalPages }', //总页数
			  curr: '${pager.page + 1 }',
			  skip: true, //是否开启跳页
			  jump: function(obj,first){
		    	  if (!first) {//如果不是首页
		            location = "<%=path %>/hsxy/sdjf/admin/yhxx?page="+(obj.curr - 1)+"&bz=1";
				}
		      }
			});
		
		laypage({
			  cont: 'page1', //容器。值支持id名、原生dom对象，jquery对象,
			  pages: '${pager1.totalPages }', //总页数
			  curr: '${pager1.page + 1 }',
			  skip: true, //是否开启跳页
			  jump: function(obj,first){
		    	  if (!first) {//如果不是首页
		            location = "<%=path %>/hsxy/sdjf/admin/yhxx?page="+(obj.curr - 1)+"&bz=2";
				}
		      }
			});
		
		$("#stutab").click(function(){
			location = "<%=path %>/hsxy/sdjf/ssadmin/yhxx?page=0&bz=1";
		});
		$("#admintab").click(function(){
			location = "<%=path %>/hsxy/sdjf/ssadmin/yhxx?page=0&bz=2";
		});
		
		$(".addstu").click(function(){
			location = "<%=path %>/hsxy/sdjf/admin/adduser?bz=1";
		});
		
		$(".addgly").click(function(){
			location = "<%=path %>/hsxy/sdjf/admin/adduser?bz=2";
		});
		
	});
	
	function updateStu(){
		var stus = document.getElementsByName("stubox");
		check_val = [];
	    for(k in stus){
	        if(stus[k].checked)
	            check_val.push(stus[k].value);
	    }
	    if(check_val.length == 1){
	    	var stuid = check_val[0];
	        location = "<%=path %>/hsxy/sdjf/admin/xgxx?id="+stuid+"&sdbz=1";
	    }else if(check_val.length > 1){
	    	alert("请逐个修改！");
	    }
	}
	
	function updateGly(){
		var glys = document.getElementsByName("glybox");
		check_val = [];
	    for(k in glys){
	        if(glys[k].checked)
	            check_val.push(glys[k].value);
	    }
	    if(check_val.length == 1){
	    	var glyid = check_val[0];
	        location = "<%=path %>/hsxy/sdjf/admin/xgxx?id="+glyid+"&sdbz=2";
	    }else if(check_val.length > 1){
	    	alert("请逐个修改！");
	    }
	}
	
	function studelall(){
		var i = $("#stualldel").attr("checked");
		if(i){
			$(".stubox1").attr("checked",'true');//全选
		}else{
			$(".stubox1").removeAttr("checked");
		}
	};
	
	function delAllStuAjax(){
		var stus = document.getElementsByName("stubox");
		check_val = [];
	    for(k in stus){
	        if(stus[k].checked)
	            check_val.push(stus[k].value);
	    }
	    if(check_val.length != 0){
		    if(confirm("确认删除吗？")){
		        var ids = check_val.toString();
		        $.ajax({
	     	       type:"POST",
	     	       url:"<%=path%>/hsxy/sdjf/admin/delallstu",
	     	       data:{
	     	    	     "ids":ids
	     			     },
	     	       success:function(data){
	     	    	  if(data){
	     	    		  location = "<%=path %>/hsxy/sdjf/admin/yhxx?page=0&bz=1";
	     	    	  }
	     	       },
	                error: function() {
	                    //请求出错
	                    alert("请求出错");
	                }
	     		   });
		    }
	    }
	}
	
	function glydelall(){
		var i = $("#glyalldel").attr("checked");
		if(i){
			$(".glybox1").attr("checked",'true');//全选
		}else{
			$(".glybox1").removeAttr("checked");
		}
	};
	
	function delAllGlyAjax(){
		var glys = document.getElementsByName("glybox");
		check_val = [];
	    for(k in glys){
	        if(glys[k].checked)
	            check_val.push(glys[k].value);
	    }
	    if(check_val.length != 0){
	    	if(confirm("确认删除吗？")){
		        var ids = check_val.toString();
		        $.ajax({
	     	       type:"POST",
	     	       url:"<%=path%>/hsxy/sdjf/admin/delallgly",
	     	       data:{
	     	    	     "ids":ids
	     			     },
	     	       success:function(data){
	     	    	  if(data){
	     	    		  location = "<%=path %>/hsxy/sdjf/admin/yhxx?page=0&bz=2";
	     	    	  }
	     	       },
	                error: function() {
	                    //请求出错
	                    alert("请求出错");
	                }
	     		   });
		    }
	    }
	}
	</script>
</body>
</html>