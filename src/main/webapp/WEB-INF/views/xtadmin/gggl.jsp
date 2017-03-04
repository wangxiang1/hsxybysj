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
<title>Insert title here</title>
<style type="text/css">
 .slider-wrapper {
        width: 800px;
    }
    .top-banner{
        background-color: #333;
    }
</style>
</head>
<div id="wrapper">
        <div class="slider-wrapper theme-default">
            <div id="slider" class="nivoSlider">
                <img src="<%=path %>/js/nivo-slider/images/toystory.jpg" data-thumb="<%=path %>/js/nivo-slider/images/toystory.jpg" alt="" />
                <img src="<%=path %>/js/nivo-slider/images/up.jpg" data-thumb="<%=path %>/js/nivo-slider/images/up.jpg" alt="" title="This is an example of a caption" />
                <img src="<%=path %>/js/nivo-slider/images/walle.jpg" data-thumb="<%=path %>/js/nivo-slider/images/walle.jpg" alt="" data-transition="slideInLeft" />
                <img src="<%=path %>/js/nivo-slider/images/nemo.jpg" data-thumb="<%=path %>/js/nivo-slider/images/nemo.jpg" alt="" title="#htmlcaption" />
            </div>
            <div id="htmlcaption" class="nivo-html-caption">
                <strong>This</strong> is an example of a <em>HTML</em> caption with <a href="#">a link</a>. 
            </div>
        </div>
        <div class="footer-banner" style="width:728px; margin:0 auto"></div>
    </div>

<body>
 <script type="text/javascript">
 $(window).load(function() {
     $('#slider').nivoSlider();
 });
</script>
</body>
</html>