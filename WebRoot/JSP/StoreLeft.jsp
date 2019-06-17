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

		<title>My JSP 'Left.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link href="CSS/OtherCSS/style.css" type="text/css" rel="stylesheet">
	</head>

	<body>
		<dl class="leftmenu" id="storeMenu">
			<dd id="manageStoreMenu">
				<div class="title">
					<span> <img src="Image/OtherImage/leftico01.png"> </span>
					店铺管理
				</div>
				<ul class="menuson">
					<li id="manageStoreItem">
						<cite></cite>
						<a href="JSP/ManageStore/StoreManageChoose.jsp" target="rightFrame">店铺信息管理</a>
						<i></i>
					</li>
					<li id="manageServiceItem">
						<cite></cite>
						<a href="JSP/ManageStore/ServiceManageChoose.jsp" target="rightFrame">店铺服务管理</a>
						<i></i>
					</li>
				</ul>
			</dd>
			<dd id="showStoreMenu">
				<div class="title">
					<span> <img src="Image/OtherImage/leftico02.png"> </span>
					信息显示
				</div>
				<ul class="menuson">
					<li id="showStoreItem">
						<cite></cite>
						<a href="JSP/ShowStore/ShowStore.jsp" target="rightFrame">店铺信息显示</a>
						<i></i>
					</li>
					<li id="showServiceItem">
						<cite></cite>
						<a href="JSP/ShowStore/ShowServiceChoose.jsp" target="rightFrame">服务信息显示</a>
						<i></i>
					</li>
				</ul>
			</dd>
		</dl>
		<script src="JS/OtherJS/jquery.js" type="text/javascript"></script>
		<script src="JS/MyJS/LeftJS.js" type="text/javascript"></script>
		<script src="JS/MyJS/StoreLeftCopy.js" type="text/javascript"></script>
	</body>
</html>
