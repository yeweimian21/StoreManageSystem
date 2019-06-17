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

		<title>登录界面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link href="CSS/OtherCSS/style.css" type="text/css" rel="stylesheet">
		<link href="CSS/MyCSS/LoginCSS.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<form action="loginUser" method="post">
			<div id="mainBody">
				<div id="cloud1" class="cloud"></div>
				<div id="cloud2" class="cloud"></div>
			</div>
			<div class="logintop">
				<span>欢迎登录后台管理平台界面</span>
				<ul>
					<li>
						<a href="JSP/Register.jsp" target="_top">注册</a>
					</li>
					<li>
						<a href="#">帮助</a>
					</li>
					<li>
						<a href="#">关于</a>
					</li>
				</ul>
			</div>
			<div class="loginbody">
				<span class="systemlogo"></span>
				<div class="loginbox">
					<ul>
						<li>
							<input class="loginuser" type="text" value="用户名" name="userName"
								id="username1">
						</li>
						<li>
							<input class="loginpwd" type="password" name="password">
						</li>
						<li>
							<input class="loginbtn" type="submit" value="登录">
							<label>
								<input type="checkbox">
								<span>记住密码</span>
							</label>
						</li>
					</ul>
				</div>
			</div>
			<div class="loginbm">
				<span>版权所有 2014</span>
				<a href="#">www.wash.com</a>
			</div>
		</form>
		<script src="JS/OtherJS/jquery.js" type="text/javascript"></script>
		<script src="JS/MyJS/LoginCopy.js" type="text/javascript"></script>
	</body>
</html>
