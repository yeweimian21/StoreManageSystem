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

		<title>My JSP 'UserLeft.jsp' starting page</title>

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
		<dl class="leftmenu">
			<dd id="manageUserMenu">
				<div class="title">
					<span> <img src="Image/OtherImage/leftico03.png"> </span>
					用户管理
				</div>
				<ul class="menuson">
					<li id="manageUserItem">
						<cite></cite>
						<a href="JSP/ManageUser/ManageUserChoose.jsp" target="rightFrame">管理用户</a>
						<i></i>
					</li>
					<li id="manageRoleItem">
						<cite></cite>
						<a href="JSP/ManageUser/ManageRoleChoose.jsp" target="rightFrame">管理角色</a>
						<i></i>
					</li>
					<li id="manageRightItem">
						<cite></cite>
						<a href="JSP/ManageUser/ManageRightChoose.jsp" target="rightFrame">管理权限</a>
						<i></i>
					</li>
					<li id="manageUserRoleItem">
						<cite></cite>
						<a href="JSP/ManageUser/ManageUserRoleChoose.jsp" target="rightFrame">管理用户的角色</a>
						<i></i>
					</li>
					<li id="manageRoleRightItem">
						<cite></cite>
						<a href="JSP/ManageUser/ManageRoleRightChoose.jsp" target="rightFrame">管理角色的权限</a>
						<i></i>
					</li>
				</ul>
			</dd>
			<dd id="showUserMenu">
				<div class="title">
					<span> <img src="Image/OtherImage/leftico04.png"> </span>
					信息显示
				</div>
				<ul class="menuson">
					<li id="showUserItem">
						<cite class="menusonfirst"></cite>
						<a href="JSP/ShowUser/ShowUser.jsp" target="rightFrame">用户列表</a>
						<i></i>
					</li>
					<li id="showRoleItem">
						<cite></cite>
						<a href="JSP/ShowUser/ShowRole.jsp" target="rightFrame">角色列表</a>
						<i></i>
					</li>
					<li id="showRightItem">
						<cite></cite>
						<a href="JSP/ShowUser/ShowRight.jsp" target="rightFrame">权限列表</a>
						<i></i>
					</li>
					<li id="showUserRoleItem">
						<cite></cite>
						<a href="JSP/ShowUser/ShowUserRole.jsp" target="rightFrame">用户角色列表</a>
						<i></i>
					</li>
					<li id="showRoleRightItem">
						<cite></cite>
						<a href="JSP/ShowUser/ShowRoleRight.jsp" target="rightFrame">角色权限列表</a>
						<i></i>
					</li>
				</ul>
			</dd>
		</dl>
		<script src="JS/OtherJS/jquery.js" type="text/javascript"></script>
		<script src="JS/MyJS/LeftJS.js" type="text/javascript"></script>
		<script src="JS/MyJS/UserLeftCopy.js" type="text/javascript"></script>
	</body>
</html>
