<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/themes/default/default.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/themes/light/light.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/themes/dark/dark.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/themes/bar/bar.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="<%=path %>/js/nivo-slider/style.css" type="text/css" media="screen" />
<script type="text/javascript" src="<%=path %>/js/nivo-slider/scripts/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/nivo-slider/jquery.nivo.slider.js"></script>

<script type="text/javascript" src="<%=path %>/js/laypage/laypage.js"></script>
<link href="<%=path %>/js/bootstrap-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />


<title>系统管理员主页</title>
<style type="text/css">
.slider-wrapper {
    width: 750px;
    margin-left:2px;
    margin-top: 0px;
    }
.top-banner{
    background-color: #333;
}
.tablelist{
	width: 750px;
}
.tablelist td{
text-align: center;
}
</style>
</head>
<body>
    <div class="mainbox">
    <div class="mainleft">
		    <div class="leftinfo" style="border-style: hidden;">
		    <div id="wrapper">
		        <div class="slider-wrapper theme-default">
		            <div id="slider" class="nivoSlider">
		                <img src="<%=path %>/js/nivo-slider/images/2.png" data-thumb="<%=path %>/js/nivo-slider/images/2.png" alt="" />
		                <img src="<%=path %>/js/nivo-slider/images/4.png" data-thumb="<%=path %>/js/nivo-slider/images/4.png" alt="" title="节约能源，从我做起" />
		                <img src="<%=path %>/js/nivo-slider/images/3.png" data-thumb="<%=path %>/js/nivo-slider/images/3.png" alt="" data-transition="slideInLeft" />
		                <img src="<%=path %>/js/nivo-slider/images/1.png" data-thumb="<%=path %>/js/nivo-slider/images/1.png" alt="" title="随手关灯" />
		            </div>
		        </div>
		    </div>
		    </div>
	    <!--leftinfo end-->
	    <div class="leftinfos" style="margin-top: 65px;">
		   <table class='tablelist'>
		   		<tr>
		   		   <td>宿舍楼</td>
		   		   <td>宿舍数</td>
		   		   <td>人数</td>
		   		   <td>水电费统计图</td>
		   		</tr>
		   		<c:forEach items="${sslxxs }" var="s" varStatus="i">
		   		<tr>
		   		   <td>${s.sslh }号楼</td>
		   		   <td>${s.ssgs }间</td>
		   		   <td>${s.ssrs }个</td>
		   		   <td>
		   		   		<a href="#">查看</a>
		   		   </td>
		   		</tr>
		   		</c:forEach>
		   </table>
	    </div>
    </div>
    <!--mainleft end-->
    <div class="mainright">
	    <div class="dflist" style="width: 380px; height: 300px;">
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
	    <div class="dflist1" style="width: 380px; height: 300px;">
		    <div class="listtitle"><a href="#" class="more1">更多</a>信息统计</div>    
		    <ul class="newlist">
			    <li><i>会员数：</i>2535462</li>
			    <li><i>文档数：</i>5546</li>
			    <li><i>普通文章：</i>2315</li>
			    <li><i>软件：</i>1585</li>
			    <li><i>评论数：</i>5342</li>    
		    </ul>        
	    </div>
    </div>
    <!--mainright end-->
    </div>
</body>
<script type="text/javascript">
	$(window).load(function() {
	    $('#slider').nivoSlider({controlNav:false});
	});
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
	
	
</script>
</html>