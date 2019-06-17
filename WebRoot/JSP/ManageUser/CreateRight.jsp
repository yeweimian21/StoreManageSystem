<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<%
		if (session.getAttribute("operateState") == null) {
	%>
	<script type="text/javascript">
					var operateState=null;
				</script>
	<%
		} else {
	%>
	<script type="text/javascript">
					var operateState="<%=session.getAttribute("operateState")%>"
					;
				</script>
	<%
		}
	%>
	<script src="../../JS/MyJS/OperateSuccessfullyJS.js"
		type="text/javascript"></script>
	<%
		session.setAttribute("operateState", null);
	%>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'CreateRight.jsp' starting page</title>

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
					增加权限
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="addRight"
				method="get" id="form1">
				<div class="form-group">
					<label for="rightNameLabel" class="col-sm-2 control-label">
						权限名称
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="rightNameLabel"
							placeholder="权限名称" name="rightName">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-primary">
							确定
						</button>
					</div>
				</div>
			</form>
		</div>
		<script src="bootstrap-3.3.0/dist/js/jquery-2.1.1.min.js"
			type="text/javascript"></script>
		<script src="bootstrap-3.3.0/dist/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="JS/MyJS/ManageUserJS/CreateRightCopy.js"
			type="text/javascript"></script>
	</body>
</html>
