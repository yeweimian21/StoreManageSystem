<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html lang="zh-CN">
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'ServiceManageChoose.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link href="bootstrap-3.3.0/dist/css/bootstrap.min.css"
			type="text/css" rel="stylesheet">
		<link href="bootstrap-3.3.0/dist/css/bootstrap-theme.min.css"
			type="text/css" rel="stylesheet">
		<link href="CSS/MyCSS/FullCSS.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<div class="container">
			<div class="jumbotron" id="outerdiv">
				<h1>
					店铺服务管理
				</h1>
				<p>
					您现在可以对店铺的服务内容进行各种操作。
				</p>
				<p>
					<div class="btn-group" id="serviceMenu">
						<button type="button" class="btn btn-primary">
							洗衣服务管理
						</button>
						<button type="button" class="btn btn-primary dropdown-toggle"
							data-toggle="dropdown">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li>
								<a href="JSP/ManageStore/CreateService.jsp" target="_self">增加服务项目</a>
							</li>
							<li>
								<a href="JSP/ManageStore/UpdateService.jsp" target="_self">修改服务项目</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="JSP/ManageStore/DeleteService.jsp" target="_self">删除服务项目</a>
							</li>
						</ul>
					</div>
					<div class="btn-group" id="developmentMenu">
						<button type="button" class="btn btn-success">
							店铺动态管理
						</button>
						<button type="button" class="btn btn-success dropdown-toggle"
							data-toggle="dropdown">
							<span class="caret"></span>
							<span class="sr-only">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li>
								<a href="JSP/ManageStore/CreateDevelopment.jsp" target="_self">增加店铺动态</a>
							</li>
							<li>
								<a href="JSP/ManageStore/UpdateDevelopment.jsp" target="_self">修改店铺动态</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="JSP/ManageStore/DeleteDevelopment.jsp" target="_self">删除店铺动态</a>
							</li>
						</ul>
					</div>
				</p>
			</div>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
	</body>
</html>
