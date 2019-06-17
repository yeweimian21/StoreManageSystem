<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sh.manage.entity.Right"%>
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

		<title>My JSP 'ShowRight.jsp' starting page</title>

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
					查看权限信息
				</h1>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>
								权限编号
							</th>
							<th>
								权限名称
							</th>
						</tr>
					</thead>
					<tbody id="rightTableOuter">
						
					</tbody>
				</table>
			</div>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
			<script src="JS/MyJS/ShowUserJS/ShowRightCopy.js" type="text/javascript"></script>
	</body>
</html>
