<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台登录页面</title>
<link href="${pageContext.request.contextPath}/css/manage/login.css" type="text/css" rel="stylesheet" media="all" />
</head>

<body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript">
var FancyForm=function(){
	return{
		inputs:".FancyForm input, .FancyForm textarea",
		setup:function(){
			var a=this;
			this.inputs=$(this.inputs);
			a.inputs.each(function(){
				var c=$(this);
				a.checkVal(c)
			});
			a.inputs.live("keyup blur",function(){
				var c=$(this);
				a.checkVal(c);
			});
		},checkVal:function(a){
			a.val().length>0?a.parent("li").addClass("val"):a.parent("li").removeClass("val")
		}
	}
}();
</script>

<div class="layout">
	<div class="sheet1 sheet" style="box-shadow: 6px 8px #dadada;height: auto;">
		<h1 style="padding-top: 30px;">后台管理系统<span style="padding-left: 20px;font-size: 16px;color: #e0e0e0;">Management</span></h1>
		<div align="center" style="color: red;font-size:  16px;"><s:actionerror/></div>
		<form name="form" action="${pageContext.request.contextPath}/adminUser_login" method="post" target="_parent">
			<ul class="Form FancyForm">
				<li style="margin-bottom: 10px;">
					<h2 style="font-weight:normal;">用  户  名：</h2>
				</li>
				<li>
					<input id="username" name="username" type="text" class="stext" style="box-shadow: 7px 6px #e0e0e0;"/>
					<label>管理员用户名</label>
					<span class="fff"></span>
				</li>
				<li style="margin-bottom: 10px;">
					<h2  style="font-weight:normal;">密  码：</h2>
				</li>
				<li>
					<input id="password" name="password" type="password" class="stext" style="box-shadow: 7px 6px #e0e0e0;"/>
					<label>登录密码</label>
					<span class="fff"></span>
				</li>
				<li class="last"><input type="submit" value="" class="btn-img" style="margin-right: 140px;margin-bottom: 20px;" /></li>
			</ul>
		</form>	
	</div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	FancyForm.setup();
});
</script>
</body>
</html>