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

		<title>My JSP 'ManageUserChoose.jsp' starting page</title>

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
					用户管理
				</h1>
				<p>
					您现在可以对用户进行各种操作。
				</p>
				<p>
					<div class="btn-group btn-group-justified">
						<div class="btn-group" id="updateUserItem">
							<a href="JSP/ManageUser/UpdateUser.jsp" target="_self">
								<button type="button" class="btn btn-success">
									修改用户
								</button> </a>
						</div>
						<div class="btn-group" id="deleteUserItem">
							<a href="JSP/ManageUser/DeleteUser.jsp" target="_self">
								<button type="button" class="btn btn-danger">
									删除用户
								</button> </a>
						</div>
					</div>
				</p>
			</div>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="JS/MyJS/ManageUserJS/ManageUserChooseCopy.js"
			type="text/javascript"></script>
	</body>
</html>
