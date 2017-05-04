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
<title>新增公告</title>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li>公告管理</li>
    <li>新增公告</li>
    </ul>
    </div>
<div class="formbody">
    <div class="formtitle"><span>添加公告</span></div>
	    <ul class="forminfo">
		    <li><label>公告标题</label><input id="ggbt" type="text" class="dfinput" maxlength="20" /><i>标题不能超过20个字符</i></li>
		    <li><label>公告内容</label><textarea id="ggnr" cols="" rows="" class="textinput"></textarea></li>
		    <li><label>&nbsp;</label><input id="qrbtn" type="button" class="btn" value="确认保存"/></li>
	    </ul>   
    </div>
<script type="text/javascript">
$("#qrbtn").click(function(){
	  var ggbt = $("#ggbt").val();
	  var ggnr = $("#ggnr").val();
	  
	  location = "<%=path%>/hsxy/sdjf/ssadmin/addgg?ggbt="+ggbt+"&ggnr="+ggnr;
});
</script>
</body>
</html>