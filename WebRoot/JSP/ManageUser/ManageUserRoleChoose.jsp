<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.context.request.RequestScope"%>
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

		<title>My JSP 'ManageUserRole.jsp' starting page</title>

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
					管理用户的角色
				</h1>
			</div>
			<form class="form-horizontal" role="form"
				action="deleteUserRoleManage" method="get">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入要修改的用户和角色信息
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="usernamelabel" class="col-sm-2 control-label">
								用户名
							</label>
							<div class="col-sm-8">
								<select class="form-control" name="userIdParam"
									id="userIdSelect">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="usernamelabel" class="col-sm-2 control-label">
								角色
							</label>
							<div class="col-sm-8" id="roleIdDivOuter">

							</div>
						</div>
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
		<script src="JS/MyJS/ManageUserJS/ManageUserRoleChooseCopy.js"
			type="text/javascript"></script>
	</body>
</html>
