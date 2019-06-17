<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sh.manage.entity.User"%>
<%@page import="com.sh.manage.entity.Role"%>
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

		<title>My JSP 'ShowUserRole.jsp' starting page</title>

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
					查看用户角色
				</h1>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						请输入要查看的用户
					</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="rolename" class="col-sm-2 control-label">
							用户名
						</label>
						<div class="col-sm-8">
							<select class="form-control" id="userIdSelect">
								
							</select>
						</div>
					</div>
				</div>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>
								用户编号
							</th>
							<th>
								用户名
							</th>
							<th>
								角色编号
							</th>
							<th>
								角色
							</th>
						</tr>
					</thead>
					<tbody id="userRoleTable">
						
					</tbody>
				</table>
			</div>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="JS/MyJS/ShowUserJS/ShowUserRoleCopy.js" type="text/javascript"></script>
	</body>
</html>
