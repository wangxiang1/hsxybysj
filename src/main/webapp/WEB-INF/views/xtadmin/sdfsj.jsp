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
<title>水电费数据表</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">管理水电费信息</a></li>
			<li><a href="#">首页</a></li>
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
              </ul>
		</div>

		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" /></th>
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
					<td><input name="" type="checkbox" value="" /></td>
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


		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>

			<div class="tipinfo">
				<span><img src="<%=path %>/js/model/images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; 
				<input name="" type="button" class="cancel" value="取消" />
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
	            location = "<%=path %>/hsxy/sdjf/admin/gosdfsj?page="+(obj.curr - 1)+"&sslh="+sslh+"&ssh="+ssh+"&sfjf="+sfjf+"&date="+date;
			}
	      }
		});
		
});
  function chaxun(){
	var sslh = $("#sslh").val();
	var ssh = $("#ssh").val();
	var sfjf = $("#sfjf").val();
	var date = $("#date").val(); 
	location = "<%=path %>/hsxy/sdjf/admin/gosdfsj?page=0&sslh="+sslh+"&ssh="+ssh+"&sfjf="+sfjf+"&date="+date;
  }

</script>
</body>
</html>