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

		<title>信息管理系统界面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<frameset framespacing="0" border="0" frameborder="no" cols="*"
		rows="88,*">
		<frame id="topFrame" title="topFrame" noresize="noresize"
			scrolling="no" name="topFrame" src="JSP/Top.jsp">
		<frameset framespacing="0" border="0" frameborder="no" cols="187,*">
			<frame id="leftFrame" title="leftFrame" noresize="noresize" scrolling="no"
			name="leftFrame" src="JSP/StoreLeft.jsp">
			<frame id="rightFrame" title="rightFrame" name="rightFrame" src="JSP/Welcome.jsp">
		</frameset>
	</frameset>
</html>
