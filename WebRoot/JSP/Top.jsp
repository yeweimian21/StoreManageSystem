<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>模块管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link href="CSS/OtherCSS/style.css" type="text/css" rel="stylesheet">
		<link href="CSS/MyCSS/TopCSS.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div class="topleft">
			<a target="_parent" href="#"> <img
					src="Image/OtherImage/logo.png"> </a>
		</div>
		<ul class="nav">
			<li id="storeManageTag">
				<a class="selected" target="leftFrame" href="JSP/StoreLeft.jsp"> <img
						src="Image/OtherImage/icon01.png">
					<h2>
						店铺管理
					</h2> </a>
			</li>
			<li id="userManageTag">
				<a target="leftFrame" href="JSP/UserLeft.jsp"> <img
						src="Image/OtherImage/icon02.png">
					<h2>
						用户管理
					</h2> </a>
			</li>
		</ul>
		<div class="topright">
			<ul>
				<li>
					<span> <img src="Image/OtherImage/help.png"> </span>
					<a href="#">帮助</a>
				</li>
				<li>
					<a href="#">关于</a>
				</li>
				<li>
					<a href="exitUser" target="_top">退出</a>
				</li>
			</ul>
			<div class="user">
				<span id="welcomeTip">欢迎，</span>
				<span id="userTip"></span>
				<span id="roleTip"></span>
				<i>消息</i>
				<b>5</b>
			</div>
		</div>
		<script src="JS/OtherJS/jquery.js" type="text/javascript"></script>
		<script src="JS/MyJS/TopCopy.js" type="text/javascript"></script>
	</body>
</html>
