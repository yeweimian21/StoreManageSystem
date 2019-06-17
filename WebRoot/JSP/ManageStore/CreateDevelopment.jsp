<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sh.manage.entity.Store"%>
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

		<title>My JSP 'CreateDevelopment.jsp' starting page</title>

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
					增加店铺动态
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="addDevelopment"
				method="get" id="form1">
				<div class="form-group">
					<label for="developmentstorelabel" class="col-sm-2 control-label">
						动态店铺
					</label>
					<div class="col-sm-8">
						<select class="form-control" id="storeIdSelect"
							name="developmentStoreIdParam">
							<!-- value为店铺的id -->
							
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="developmentTypeLabel" class="col-sm-2 control-label">
						动态类型
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="developmentTypeLabel"
							placeholder="动态类型" name="developmentType">
					</div>
				</div>
				<div class="form-group">
					<label for="developmenTitleLabel" class="col-sm-2 control-label">
						动态标题
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="developmenTitleLabel"
							placeholder="动态标题" name="developmentTitle">
					</div>
				</div>
				<div class="form-group">
					<label for="developmentContentLabel" class="col-sm-2 control-label">
						动态详情
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control"
							id="developmentContentLabel" placeholder="动态详情"
							name="developmentContent">
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
		<script src="JS/MyJS/ManageStoreJS/CreateDevelopmentCopy.js" type="text/javascript"></script>
	</body>
</html>
