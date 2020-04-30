<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
body,td,th {
	color: #000000;
}
-->
    </style>
<style>
BODY {SCROLLBAR-FACE-COLOR: #cccccc; SCROLLBAR-HIGHLIGHT-COLOR: #ffffFF; SCROLLBAR-SHADOW-COLOR: #ffffff; SCROLLBAR-3DLIGHT-COLOR: #cccccc; SCROLLBAR-ARROW-COLOR:  #ffffff; SCROLLBAR-TRACK-COLOR: #ffffFF; SCROLLBAR-DARKSHADOW-COLOR: #cccccc; }
</style>
</head>

<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <div align="center">系  统  首  页</div>
   </div>
	<div align="center" style="font-size:  18px;margin-top: 20px;margin-bottom: 30px; ">
		登  录  成  功
	</div>
	<table border="0" >
		<tr>
			<td>
				<img src="${pageContext.request.contextPath}/images/manage/manage.png" style="width: 550px;height: 330px;margin-left: 100px;margin-top: 20px;">
			</td>
			<td style="padding-left: 100px">
				<div style="font-size: 24px;" style="padding-left: 150px;">
					<p>你好！ 管理员：<font color="red"><s:property value="#session.adminUser.username" /></font></p>
					欢迎登录后台管理系统！
				</div>
			</td>
		</tr>
		<tr><td height=2></td></tr>
	</table>
</body>
</html>