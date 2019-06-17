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

		<title>My JSP 'UpdateDevelopment.jsp' starting page</title>

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
					修改店铺动态
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="updateDevelopment"
				method="get" id="form1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入要修改的店铺动态
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="developmentstore" class="col-sm-2 control-label">
								动态店铺
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="storeIdSelectBefore">
									<!-- value为店铺的Id -->
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="developmenttitle" class="col-sm-2 control-label">
								动态标题
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="developmentIdSelect"
									name="developmentIdParam">
									<!-- value为动态的Id -->

								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入修改后的店铺动态
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="developmentstore" class="col-sm-2 control-label">
								动态店铺
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="storeIdSelectAfter"
									name="storeIdParam">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="developmentTypeLabel" class="col-sm-2 control-label">
								动态类型
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									id="developmentTypeLabel" placeholder="动态类型"
									name="developmentType">
							</div>
						</div>
						<div class="form-group">
							<label for="developmentTitleLabel" class="col-sm-2 control-label">
								动态标题
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									id="developmentTitleLabel" placeholder="动态标题"
									name="developmentTitle">
							</div>
						</div>
						<div class="form-group">
							<label for="developmentContentLabel"
								class="col-sm-2 control-label">
								动态详情
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control"
									id="developmentContentLabel" placeholder="动态详情"
									name="developmentContent">
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
		<script src="JS/MyJS/ManageStoreJS/UpdateDevelopmentCopy.js" type="text/javascript"></script>
	</body>
</html>
