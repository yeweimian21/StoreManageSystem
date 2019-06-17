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
	<script src="../../JS/MyJS/OperateSuccessfullyJS.js" type="text/javascript"></script>
	<%
		session.setAttribute("operateState", null);
	%>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'UpdateUser.jsp' starting page</title>

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
					修改用户
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="updateUser"
				method="post" id="form1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入要修改的用户名
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="rolename" class="col-sm-2 control-label">
								用户名
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="userIdSelect"
									name="userIdParam">

								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入修改后的用户信息
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="userNameLabel" class="col-sm-2 control-label">
								用户名
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="userNameLabel"
									placeholder="用户名" name="userName">
							</div>
						</div>
						<div class="form-group">
							<label for="passwordLabel" class="col-sm-2 control-label">
								密码
							</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="passwordLabel"
									name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="userSexLabel" class="col-sm-2 control-label">
								性别
							</label>
							<div class="col-sm-8">
								<label class="radio-inline">
									<input type="radio" name="userSexParam" id="maleRadio"
										value="male">
									男
								</label>
								<label class="radio-inline">
									<input type="radio" name="userSexParam" id="femaleRadio"
										value="female">
									女
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="userAgeLabel" class="col-sm-2 control-label">
								年龄
							</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="userAgeLabel"
									max="150" min="0" step="1" name="age">
							</div>
						</div>
						<div class="form-group">
							<label for="userPhoneLabel" class="col-sm-2 control-label">
								电话
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="userPhoneLabel"
									name="phone">
							</div>
						</div>
						<div class="form-group">
							<label for="userEmailLabel" class="col-sm-2 control-label">
								email
							</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="userEmailLabel"
									placeholder="email" name="email">
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
		<script src="JS/MyJS/ManageUserJS/UpdateUserCopy.js" type="text/javascript"></script>
	</body>
</html>
