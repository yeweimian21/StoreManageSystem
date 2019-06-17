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

		<title>My JSP 'UpdateService.jsp' starting page</title>

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
					修改服务信息
				</h1>
			</div>
			<form class="form-horizontal" role="form" action="updateService"
				method="get" id="form1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入要修改的洗衣服务
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="servicestore" class="col-sm-2 control-label">
								所属店铺
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="storeIdSelectBefore">
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="servicename" class="col-sm-2 control-label">
								服务名称
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="serviceIdSelect"
									name="serviceIdParam">
									<!-- value为服务的Id -->

								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							请输入修改后的服务信息
						</h3>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="servicestore" class="col-sm-2 control-label">
								所属店铺
							</label>
							<div class="col-sm-8">
								<select class="form-control" id="storeIdSelectAfter"
									name="storeIdParam">

								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="serviceNameLabel" class="col-sm-2 control-label">
								服务名称
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="serviceNameLabel"
									placeholder="服务名称" name="serviceName">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">
								优惠情况
							</label>
							<div class="col-sm-8">
								<label class="radio-inline">
									<input type="radio" name="serviceCheapParam" id="cheaper"
										value="cheaper">
									有优惠
								</label>
								<label class="radio-inline">
									<input type="radio" name="serviceCheapParam" id="notCheaper"
										value="notCheaper" checked="checked">
									暂无优惠
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="beforePriceLabel" class="col-sm-2 control-label">
								优惠前价格
							</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="beforePriceLabel"
									max="500" min="10" step="10" name="beforePrice">
							</div>
						</div>
						<div class="form-group">
							<label for="afterPriceLabel" class="col-sm-2 control-label">
								优惠后价格
							</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="afterPriceLabel"
									max="500" min="10" step="10" name="afterPrice">
							</div>
						</div>
						<div class="form-group">
							<label for="costTimeLabel" class="col-sm-2 control-label">
								服务耗时
							</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" id="costTimeLabel"
									max="10" min="1" step="1" name="costTime">
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
		<script src="JS/MyJS/ManageStoreJS/UpdateServiceCopy.js" type="text/javascript"></script>
	</body>
</html>
