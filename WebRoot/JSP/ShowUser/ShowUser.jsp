<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sh.manage.entity.User"%>
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

		<title>My JSP 'ShowUser.jsp' starting page</title>

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
	</head>

	<body>
		<div class="container">
			<div class="page-header">
				<h1>
					查看用户信息
				</h1>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>
								用户编号
							</th>
							<th>
								用户姓名
							</th>
							<th>
								登录密码
							</th>
							<th>
								性别
							</th>
							<th>
								年龄
							</th>
							<th>
								联系电话
							</th>
							<th>
								电子邮箱
							</th>
						</tr>
					</thead>
					<tbody id="userTableOuter">
						
					</tbody>
				</table>
			</div>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
			<script src="JS/MyJS/ShowUserJS/ShowUserCopy.js" type="text/javascript"></script>
	</body>
</html>
