<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sh.manage.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html lang="zh-CN">
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

		<title>My JSP 'CreateStore.jsp' starting page</title>

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
					增加店铺信息
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="addStore"
				method="get" id="form1">
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">
						店长姓名
					</label>
					<div class="col-sm-8">
						<select class="form-control" id="managerIdSelect"
							name="managerIdParam">
							<!-- value为店长的id，方便查询；文本节点为店长的name -->

						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="storeNameLabel" class="col-sm-2 control-label">
						店铺名称
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="storeNameLabel"
							placeholder="店铺名称" name="storeName">
					</div>
				</div>
				<div class="form-group">
					<label for="storeAddressLabel" class="col-sm-2 control-label">
						店铺地址
					</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="storeAddressLabel"
							placeholder="店铺地址" name="storeAddress">
					</div>
				</div>
				<div class="form-group">
					<label for="storePhoneLabel" class="col-sm-2 control-label">
						联系电话
					</label>
					<div class="col-sm-8">
						<input type="tel" class="form-control" id="storePhoneLabel"
							placeholder="联系电话" name="storePhone">
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
		<script src="JS/MyJS/ManageStoreJS/CreateStoreCopy.js" type="text/javascript"></script>
	</body>
</html>
