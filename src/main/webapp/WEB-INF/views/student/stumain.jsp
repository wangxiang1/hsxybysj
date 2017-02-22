<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/js/laypage/laypage.js"></script>
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<title>学生主页</title>
<style type="text/css">
#hoverid :hover{background:white;}
.c{text-align: center;}
</style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
	    </ul>
    </div>
    
    <div class="mainbox">
	    <div style="width: 850px; height: auto;">
		    <div class="leftinfo" style="height: auto;">
		        <div><span style="font-size: 20px; position:relative; left: 35%; margin: 15px; margin-bottom: 0px;">宿舍缴费信息总览</span></div>
			    <table class="tablelist" style="border: 0px;">
			       <tr>
			         <td class="c">序号</td>
				     <td class="c">宿舍号</td>
				     <td class="c">用水量</td>
				     <td class="c">水费</td>
				     <td class="c">用电量</td>
				     <td class="c">电费</td>
				     <td class="c">总计</td>
				     <td class="c">是否缴费</td>
				     <td class="c">日期</td>
				     <td class="c">操作</td>
			       </tr>
			       <c:forEach items="${sdfxxs }" var="s" varStatus="i">
			           <tr>
			              <td class="c">${pager.page * 5 + i.index + 1 }</td>
			              <td class="c">${s.ssh }</td>
			              <td class="c">${s.ysl } 吨</td>
			              <td class="c">${s.sf } 元</td>
			              <td class="c">${s.ydl } 千瓦时</td>
			              <td class="c">${s.df } 元</td>
			              <td class="c">${s.zj } 元</td>
			              <td class="c">
			              	<c:if test="${s.ssfjf  == 1 }">是</c:if>
			              	<c:if test="${s.ssfjf  == 0 }">否</c:if>
			              </td>
			              <td class="c">${s.date }</td>
			              <td class="c">
			                 <a href="<%=path %>/hsxy/sdjf/gostujf?stuid=${user.yhid }&date=${s.date }" style="color: #46A3FF;">缴费</a>&nbsp;
			                 <a href="<%=path %>/hsxy/sdjf/findSdfxxBydate?ssid=${s.ssid }&date=${s.date }" style="color: #46A3FF;">查看详情</a>
			              </td>
			           </tr>
			       </c:forEach>
			       <tr id="hoverid">
			         <td colspan='10'>
				        <div id="page" style="margin-top: 25px;"></div> 
			         </td>
			       </tr>
			    </table>
		    </div>
		    <!--leftinfo end-->
	    </div>
	    <!--mainleft end-->
	    <div class="mainright">
		    <div class="dflist">
		   	    <div class="listtitle"><a href="#" class="more1">更多</a>最新信息</div>    
			    <ul class="newlist">
				    <li><a href="#">上海自贸区今日正式挂牌成立</a></li>
				    <li><a href="#">习近平将访东南亚两国 首次出席APEC峰会</a></li>
				    <li><a href="#">最高法:谎称炸弹致航班备降者从重追刑责</a></li>
				    <li><a href="#">华北大部遭遇雾霾天 北京全城陷重污染</a></li>
				    <li><a href="#">"环保专家"董良杰涉嫌寻衅滋事被刑拘</a></li>
				    <li><a href="#">中央巡视组：重庆对一把手监督不到位</a></li>
				    <li><a href="#">囧!悍马没改好成华丽马车(图)</a></li>
				    <li><a href="#">澳门黄金周加派稽查人员监察出租车违规行为</a></li>
				    <li><a href="#">香港环境局长吁民众支持政府扩建堆填区</a></li> 
			    </ul>        
		    </div>
	    </div>
	    <!--mainright end-->
    </div>
</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	};
	//分页
	laypage({
		  cont: 'page', //容器。值支持id名、原生dom对象，jquery对象,
		  pages: '${pager.totalPages }', //总页数
		  curr: '${pager.page + 1 }',
		  skip: true, //是否开启跳页
		  jump: function(obj,first){
	    	  if (!first) {//如果不是首页
	            location = "<%=path %>/hsxy/sdjf/gostumain?stuid=${user.yhid }&page="+(obj.curr - 1);
			}
	      }
		});
</script>
</html>