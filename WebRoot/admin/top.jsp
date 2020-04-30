<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>图书商城后台管理系统</title>
<link href="${pageContext.request.contextPath}/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/main.js"></script>
</head>
<body>

	<table width="100%" height="100%" border=0 cellpadding="0" cellSpacing=0 style="background: url(${pageContext.request.contextPath}/images/manage/bg.jpg);">
		<tr>
			<td height="90">
				<img src="${pageContext.request.contextPath}/images/manage/logo.png" style="width:600px;height:70px;margin-left: 0px;" alt="BookStore-后台管理" class="logo" />
				<div class="user" style="font-size: 16px;">当前用户：<s:property value="#session.adminUser.username" />    (  <a href="${pageContext.request.contextPath}/index" target="_parent">商城首页</a> | <a href="${pageContext.request.contextPath}/adminUser_quit" target="_parent">退出登陆</a>  )</div>
			</td>
		</tr>
		<tr>
			<td width="18" align="right"
			background="${pageContext.request.contextPath}/images/manage/mis_01.jpg">
			<img src="${pageContext.request.contextPath}/images/manage/mis_01.jpg" width="6" height="18">
			</td>
		</tr>
	</table>
</body>	
</html>	