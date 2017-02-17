<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=path %>/js/model/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/js/model/js/jquery.js"></script>
<script src="<%=path %>/js/model/js/cloud.js" type="text/javascript"></script>
<script src="<%=path %>/js/jquery/jquery-2.0.3.min.js" type="text/javascript"></script>
<title>学生主页</title>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">工作台</a></li>
	    </ul>
    </div>
    
    <div class="mainbox">
	    <div class="mainleft">
		    <div class="leftinfo">
			    <div class="listtitle">数据统计</div>
			    <div class="maintj"> 
			       图表分析
			    </div>
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
	}
</script>
</html>