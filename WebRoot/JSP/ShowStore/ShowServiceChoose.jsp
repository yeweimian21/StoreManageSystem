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

		<title>My JSP 'ShowServiceChoose.jsp' starting page</title>

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
					服务信息显示
				</h1>
				<p>
					您现在可以对各种服务信息进行查看。
				</p>
				<p>
					<div class="btn-group btn-group-justified">
						<div class="btn-group" id="serviceMenu">
							<a href="JSP/ShowStore/ShowService.jsp" target="_self">
								<button type="button" class="btn btn-primary">
									查看洗衣服务
								</button> </a>
						</div>
						<div class="btn-group" id="developmentMenu">
							<a href="JSP/ShowStore/ShowDevelopment.jsp" target="_self">
								<button type="button" class="btn btn-success">
									查看店铺动态
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
	</body>
</html>
