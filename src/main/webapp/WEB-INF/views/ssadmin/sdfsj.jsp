<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap-theme.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=path %>/js/laypage/laypage.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/model/js/select-ui.min.js"></script>
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/js/model/css/select.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<script src="<%=path %>/js/bootstrap-dist/js/bootstrap.min.js"></script>
<title>水电费数据表</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>管理水电费信息</li>
			<li>水电费数据表</li>
		</ul>
	</div>

	<div class="rightinfo col-sm-12">

		<div class="tools">
			 <ul class="seachform">
    
			    <li>
			      <label>宿舍楼号</label>
			      <c:if test="${sslh == '' }">
			         <input id="sslh" name="" type="text" class="scinput"/>
			      </c:if>
			      <c:if test="${sslh != '' }">
			         <input id="sslh" name="" type="text" class="scinput" value="${sslh }"/>
			      </c:if>
			    </li>
			    <li>
			      <label>宿舍号</label>
			       <c:if test="${ssh == '' }">
			         <input id="ssh" name="" type="text" class="scinput" />
			       </c:if>
			       <c:if test="${ssh != '' }">
			         <input id="ssh" name="" type="text" class="scinput" value="${ssh }" />
			       </c:if>
			    </li>
			    <li>
				    <label>是否缴费</label>  
				    <div class="vocation" style="border: 1px solid #C7C7C7; width: 60px; height: 30px;">
				   		 <select id="sfjf" style="width: 58px; height: 28px;">
				   		     <c:if test="${sfjf == '' }">
				   		         <option value="">请选择</option>
				   		         <option value="1">是</option>
				    	         <option value="0">否</option>
				   		     </c:if>
				   		     <c:if test="${sfjf != '' }">
					   		     <c:if test="${sfjf == 0 }">
					   		         <option value="">请选择</option>
					   		         <option value="1">是</option>
					    	         <option value="0" selected="selected">否</option>
					   		     </c:if>
					   		     <c:if test="${sfjf == 1 }">
					   		         <option value="">请选择</option>
					   		         <option value="1" selected="selected">是</option>
					    	         <option value="0">否</option>
					   		     </c:if>
				   		     </c:if>
				         </select>
				    </div>
			    </li>
			    <li>
			       <label>日期</label>
			       <div class="vocation" style="border: 1px solid #C7C7C7; width: 100px; height: 30px;">
           			 <select id="date" style="width: 98px; height: 28px;">
           			 <c:if test="${date == '' }">
          			   <option value="">请选择</option>
					   <c:forEach items="${dates }" var="d">
					      <option value="${d.substring(0, 19) }">${d.substring(0, 11) }</option>
					   </c:forEach>
           			 </c:if>
					 <c:if test="${date != '' }">
          			   <option value="">请选择</option>
					   <c:forEach items="${dates }" var="d">
					      <c:if test="${date == d.substring(0, 19) }">
					          <option value="${d.substring(0, 19) }" selected="selected">${d.substring(0, 11) }</option>
					      </c:if>
					      <c:if test="${date != d.substring(0, 19) }">
         					  <option value="${d.substring(0, 19) }">${d.substring(0, 11) }</option>
					      </c:if>
					   </c:forEach>
           			  </c:if>	
					</select>
			       </div>
			    </li>
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询" onclick="chaxun()"/></li>
			    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="下载模板" onclick="moban()"/></li>
			    <li><label>&nbsp;</label><button name="" type="button" class="scbtn" data-toggle="modal" data-target="#myModal">导入</button></li>
			    <li style="margin-left: -8px;"><label>&nbsp;</label><input name="" type="button" class="scbtn" value="导出" onclick="daochu()"/></li>
              </ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th>编号</th>
					<th>宿舍号</th>
					<th>宿舍楼号</th>
					<th>用水量（吨）</th>
					<th>水费（元）</th>
					<th>用电量（千瓦时）</th>
					<th>电费（元）</th>
					<th>总计（元）</th>
					<th>是否缴费</th>
					<th>时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${sdfxxs }" var="s" varStatus="i">
				<tr>
					<td>${pager.page * 5 + i.index + 1 }</td>
					<td>${s.ssh }</td>
					<td>${s.sslh }</td>
					<td>${s.ysl }</td>
					<td>${s.sf }</td>
					<td>${s.ydl }</td>
					<td>${s.df }</td>
					<td>${s.zj }</td>
					<td>
					    <c:if test="${s.ssfjf  == 1 }">是</c:if>
			            <c:if test="${s.ssfjf  == 0 }">否</c:if>
					</td>
					<td>${s.date }</td>
					<td>
					   <a href="#" class="tablelink">查看</a> 
					</td>
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
		
		 <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	          <span class="sr-only">Close</span>
	        </button>
	        <h4 class="modal-title" id="myModalLabel">导入水电数据</h4>
	      </div>
	      <div class="modal-body">
	      <div style="margin-bottom: 10px;">
	      	<div style="position: relative; float: left;margin-top: 3px;">
	       		<span id="hj" style="font-size: 18px;"></span>
	       	</div>
	       	<div style="position: relative; float: left; margin-left: 30px;">
	       	  <form enctype="multipart/form-data" id="batchUpload"  action="user/upload" method="post" class="form-horizontal">  
   				 <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">
  				  <input id="uploadEventPath"  disabled="disabled"  type="text" placeholder="请选择excel表" style="border: 1px solid #e6e6e6; height: 26px;width: 200px;" >                                         
			  	  <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>
			  </form>
	       	</div>
	       </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success btn-sm" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-success btn-sm"  onclick="user.uploadBtn()" >上传</button>
	      </div>
	    </div>
	  </div>
    </div>

	</div>

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

    var sslh = $("#sslh").val();
	var ssh = $("#ssh").val();
	var sfjf = $("#sfjf").val();
	var date = $("#date").val();
	//分页
	laypage({
		  cont: 'page', //容器。值支持id名、原生dom对象，jquery对象,
		  pages: '${pager.totalPages }', //总页数
		  curr: '${pager.page + 1 }',
		  skip: true, //是否开启跳页
		  jump: function(obj,first){
	    	  if (!first) {//如果不是首页
	            location = "<%=path %>/hsxy/sdjf/ssadmin/gosdfsj?page="+(obj.curr - 1)+"&sslh="+sslh+"&ssh="+ssh+"&sfjf="+sfjf+"&date="+date;
			}
	      }
		});
		
});
  function chaxun(){
	var sslh = $("#sslh").val();
	var ssh = $("#ssh").val();
	var sfjf = $("#sfjf").val();
	var date = $("#date").val(); 
	location = "<%=path %>/hsxy/sdjf/ssadmin/gosdfsj?page=0&sslh="+sslh+"&ssh="+ssh+"&sfjf="+sfjf+"&date="+date;
  }
  
  function moban(){
	  location = "<%=path%>/hsxy/sdjf/ssadmin/loadmodel";
	   
	  }
  
var User = function(){
	    
	    this.init = function(){
	        //模拟上传excel
	         $("#uploadEventBtn").unbind("click").bind("click",function(){
	             $("#uploadEventFile").click();
	         });
	         $("#uploadEventFile").bind("change",function(){
	             $("#uploadEventPath").attr("value",$("#uploadEventFile").val());
	         });
	         
	    };
	    //点击上传按钮
	    this.uploadBtn = function(){
	        var uploadEventFile = $("#uploadEventFile").val();
	        if(uploadEventFile == ''){
	            alert("请选择excel,再上传");
	        }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
	            alert("只能上传Excel文件");
	        }else{
	            var url =  '<%=path %>/hsxy/sdjf/ssadmin/upload';
	            var formData = new FormData($('form')[0]);
	            user.sendAjaxRequest(url,'POST',formData);
	        }
	    };
	     
	    this.sendAjaxRequest = function(url,type,data){
	        $.ajax({
	            url : url,
	            type : type,
	            data : data,
	            success : function(result) {
	                if(result){
	                	alert("上传成功！");
	                	location = "<%=path %>/hsxy/sdjf/ssadmin/gosdfsj?page=0&sslh=&ssh=&sfjf&date=";
	                }
	            },
	            error : function() {
	                alert( "excel上传失败");
	            },
	            cache : false,
	            contentType : false,
	            processData : false
	        });
	    };
	}
var user;
$(function(){
    user = new User();
    user.init();
});
</script>
</body>
</html>